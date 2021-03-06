package fdu.daslab.schedulercenter.scheduling;

import fdu.daslab.schedulercenter.client.ExecutorClient;
import fdu.daslab.schedulercenter.client.JobClient;
import fdu.daslab.schedulercenter.client.SortPluginClient;
import fdu.daslab.schedulercenter.repository.SchedulerRepository;
import fdu.daslab.thrift.base.ExecutionStatus;
import fdu.daslab.thrift.base.Job;
import fdu.daslab.thrift.base.Stage;
import fdu.daslab.thrift.notifyservice.StageSnapshot;
import fdu.daslab.thrift.notifyservice.StageStatus;
import fdu.daslab.thrift.schedulercenter.PluginType;
import fdu.daslab.thrift.schedulercenter.SchedulerModel;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * stage的调度
 *
 * @author 唐志伟
 * @version 1.0
 * @since 6/1/21 7:31 PM
 */
@Component
public class StageScheduling {

    private Logger logger = LoggerFactory.getLogger(StageScheduling.class);

    @Resource
    private SchedulerRepository schedulerRepository;

    @Resource
    private ExecutorClient executorClient;

    @Resource
    private JobClient jobClient;

    // 还在等待调度被提交的stage
    private List<Stage> pendingStages = new ArrayList<>();

    // stage的cache，保存每一个jobName对应的stage，后续查询后继需要
    private Map<String, Job> jobCache = new HashMap<>();

    public void cacheJob(Job job) {
        jobCache.put(job.jobName, job);
    }

    private void cacheStage(Stage stage) {
        Job job = jobCache.get(stage.jobName);
        job.subplans.put(stage.stageId, stage);
        cacheJob(job);
        // 批量更新job的状态，在job-center中维护的是所有的状态，作为stage和job的统一管理
        try {
            jobClient.open();
            jobClient.getClient().updateStage(stage);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            jobClient.close();
        }
    }

    // 调度逻辑：触发动作主要有两块，一个是新的stage过来，一个是老的stage执行完成
    public void schedule(List<Stage> stageList) {
        // 对于需要同步启动的stage，采用pre scheduling的方式进行调度
        // TODO: stage的pre scheduling实现

        // 提交给scheduler plugin执行调度
        // 优化器可以有多层，但是调度器应该是固定的（互斥），应该类似Kubernetes，实现不同的拓展点
        // TODO:这里需要考虑多个拓展点的不同实现
        final Optional<SchedulerModel> sortModel = schedulerRepository.findAllScheduler().stream()
                .filter(scheduler -> scheduler.pluginType.equals(PluginType.SORT_PLUGIN))
                .max(Comparator.comparingInt(scheduler -> scheduler.priority));
        // 所有source都是待调度stage
        pendingStages.addAll(stageList);
        List<Stage> needScheduling = new ArrayList<>(pendingStages);
        // 调度之后，不一定所有的stage都能被调度，如果调度器没有返回，那么该stage暂时不被调度
        if (sortModel.isPresent()) {
            SortPluginClient client = new SortPluginClient(sortModel.get());
            try {
                client.open();
                needScheduling = client.getClient().sort(stageList);
            } catch (TException e) {
                e.printStackTrace();
            } finally {
                client.close();
            }
        }

        // 执行pendingStages
        for (Stage stage : needScheduling) {
            try {
                executorClient.open();
                // 更新状态
                stage.stageStatus = ExecutionStatus.PENDING;
                cacheStage(stage);
                executorClient.getClient().executeStage(stage);
                pendingStages.remove(stage);
            } catch (TException e) {
                e.printStackTrace();
            } finally {
                executorClient.close();
            }
        }
    }

    // 判断节点依赖(前置)是否都已经满足
    private boolean checkDependencies(Job job, Stage stage) {
        for (int stageId : stage.inputStageId) {
            Stage inputStage = job.subplans.get(stageId);
            if (!ExecutionStatus.COMPLETED.equals(inputStage.stageStatus)) {
                return false;
            }
        }
        return true;
    }

    // 更新stage状态，同时有可能触发调度
    public void updateStatus(String jobName, int stageId, StageSnapshot snapshot) {
        List<Stage> willScheduling = new ArrayList<>();
        Job job = jobCache.get(jobName);
        Stage stage = job.subplans.get(stageId);
        if (StageStatus.RUNNING.equals(snapshot.status)) { // 任务开始
            stage.setStageStatus(ExecutionStatus.RUNNING);
            stage.setStartTime(new Date().toString());
        } else if (StageStatus.FAILURE.equals(snapshot.status)) { // 任务失败
            stage.setStageStatus(ExecutionStatus.FAILURE);
            logger.error("job: {}, stageId: {} failed, message: {}", jobName, stageId, snapshot.message);
        } else if (StageStatus.COMPLETED.equals(snapshot.status)) {
            // 如果已经完成，则判断是否后继的节点的前驱都已经 触发后继节点的调度
            stage.setEndTime(new Date().toString());
            stage.setStageStatus(ExecutionStatus.COMPLETED);
            for (int outputId : stage.outputStageId) {
                Stage outStage = job.subplans.get(outputId);
                if (checkDependencies(job, outStage)) {
                    willScheduling.add(outStage);
                }
            }
        }
        handlerOthers(snapshot.others); // 其他需要处理的情况
        cacheStage(stage); // 更新stage状态
        if (!willScheduling.isEmpty()) {
            schedule(willScheduling);
        }
    }

    // 处理下游传来的其他参数
    private void handlerOthers(Map<String, String> others) {
        // 暂时仅仅输出
        others.forEach((key, val) -> logger.info(key + ":" + val));
    }
}
