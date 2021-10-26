package fdu.daslab.executorcenter.executor;

import fdu.daslab.executorcenter.environments.kubernetes.strategy.KubernetesResourceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zjchen
 * @time 2021/9/16 1:49 下午
 * @description
 */
@Component
public class ExecutorFactory {

    @Autowired
    private Map<String, Executor> ExecutorMap = new ConcurrentHashMap<>();

    public Map<String, Executor> getExecutorMap() {
        return ExecutorMap;
    }
}
