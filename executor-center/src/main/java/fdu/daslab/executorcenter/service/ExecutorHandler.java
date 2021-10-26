package fdu.daslab.executorcenter.service;

import fdu.daslab.executorcenter.executor.Executor;
import fdu.daslab.executorcenter.executor.ExecutorFactory;
import fdu.daslab.executorcenter.executor.KubernetesExecutor;
import fdu.daslab.executorcenter.executor.LocalExecutor;
import fdu.daslab.thrift.base.Stage;
import fdu.daslab.thrift.executorcenter.ExecutorService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 执行stage
 *
 * @author 唐志伟
 * @version 1.0
 * @since 5/18/21 7:50 PM
 */
@Service
public class ExecutorHandler implements ExecutorService.Iface {

    @Autowired
    private ExecutorFactory executorFactory;

    @Override
    public void executeStage(Stage stage) throws TException {
        // 执行stage
        Map<String, Executor> executorMap = executorFactory.getExecutorMap();
        executorMap.get(stage.others.getOrDefault("env", "kubernetes")).execute(stage);
    }
}
