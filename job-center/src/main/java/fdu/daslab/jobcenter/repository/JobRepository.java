package fdu.daslab.jobcenter.repository;

import fdu.daslab.thrift.base.*;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 *  对Job信息进行CRUD，目前先使用内存存储，为了开发方便
 *
 * @author 唐志伟
 * @version 1.0
 * @since 5/18/21 4:13 PM
 */
@Repository
public class JobRepository {

    private Map<String, Job> jobs = new HashMap<>();

    public void saveJob(Job job) {
        jobs.put(job.jobName, job);
    }

    public Job findJob(String jobName) {
        return jobs.get(jobName);
    }

    public void updateJob(Job job) {
        saveJob(job);
    }

    public void updateStage(Stage stage) {
        Job job = findJob(stage.jobName);
        /*
            更新job状态，所有任务都完成，则任务完成
            存在一个stage失败，则job失败
            存在一个任务开始，则任务开始，开始时间为最早的stage的开始时间；
            暂时假设当前任务的消息上报是及时的，也就是系统保证顺序一致性，第一个开始的stage的开始时间一定是最早的，
            最后一个结束的stage的结束时间一定是最晚的
         */
        job.subplans.put(stage.getStageId(), stage);
        if (job.jobStatus == null && ExecutionStatus.RUNNING.equals(stage.stageStatus)) {
            job.jobStatus = ExecutionStatus.RUNNING;
            job.startTime = stage.startTime;
        } else if (ExecutionStatus.FAILURE.equals(stage.stageStatus)){
            job.jobStatus = ExecutionStatus.FAILURE;
        } else if (ExecutionStatus.COMPLETED.equals(stage.stageStatus)) {
            // check是否所有任务都执行完成，TODO：未来【完成几个stage】的信息也会被存在job中，防止任务被重复check
            boolean allCompleted = true;
            for (Stage otherStage : job.subplans.values()) {
                if (!ExecutionStatus.COMPLETED.equals(otherStage.stageStatus)) {
                    allCompleted = false;
                    break;
                }
            }
            if (allCompleted) {
                job.jobStatus = ExecutionStatus.COMPLETED;
                job.endTime = stage.endTime;
            }
        }
        saveJob(job);
    }


    /**
     * 获取Job中各stages的结果
     * @param jobName 要查看结果的job名称
     * @return 每个stage的每个sinkNode对应的outputPath:
     * stageId -> ( sinkId -> outputPath )
     *
     */
    public Map<Integer, Map<Integer, String>> getResult(String jobName) {
        Job job = jobs.get(jobName);
        Map<Integer, Stage> subPlans = job.getSubplans();
        List<Integer> sourceStages = job.getSourceStages();
        Map<Integer, Map<Integer, String>> results = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> Q = new LinkedList<>();
        for (Integer stageId: sourceStages){
            visited.add(stageId);
            Q.add(stageId);
        }

        while(!Q.isEmpty()){
            Integer curStageId = Q.poll();
            Stage curStage = subPlans.get(curStageId);
            Plan planInfo = curStage.getPlanInfo();
            Map<Integer, PlanNode> nodes = planInfo.getNodes();
            Map<Integer, String> sinkIdToOutput = new HashMap<>();

            // 获取当前stage的所有sinkNodes的outputPath
            for(Integer sinkId: planInfo.getSinkNodes()){
                String outputPath = nodes.get(sinkId).
                        getOperatorInfo().getParams().
                        get("outputPath");
                sinkIdToOutput.put(sinkId, outputPath);
            }
            results.put(curStageId, sinkIdToOutput);

            // 向后面遍历
            for(int postStageId: curStage.getOutputStageId()){
                if(!visited.contains(postStageId)){
                    visited.add(curStageId);
                    Q.add(postStageId);
                }
            }
        }

        return results;
    }
}
