package fdu.daslab.executorcenter.executor;

import com.jcraft.jsch.JSchException;
import fdu.daslab.executorcenter.adapter.HpcParamAdapter;
import fdu.daslab.executorcenter.environments.hpc.HpcStrategy;
import fdu.daslab.thrift.base.Stage;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zjchen
 * @time 2021/9/16 1:51 下午
 * @description
 * 1. 解析stage的参数
 * 2. script template
 * 3. 提交任务
 */
@Component("hpc")
public class HpcExecutor implements Executor{

    private Logger logger = LoggerFactory.getLogger(KubernetesExecutor.class);

    @Autowired
    private HpcParamAdapter hpcParamAdapter;

    @Autowired
    private HpcStrategy hpcStrategy;

    @Override
    public void execute(Stage stage){
        String command = hpcParamAdapter.getScript(stage);
        logger.info("current command is :\n" + command);
        try {
            hpcStrategy.createJob(command, stage.others.get("hpc-username"), stage.others.get("hpc-password"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
