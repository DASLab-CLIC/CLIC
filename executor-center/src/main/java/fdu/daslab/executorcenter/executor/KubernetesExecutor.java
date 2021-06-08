package fdu.daslab.executorcenter.executor;

import fdu.daslab.executorcenter.adapter.ParamAdapter;
import fdu.daslab.executorcenter.client.OperatorClient;
import fdu.daslab.executorcenter.kubernetes.StrategyFactory;
import fdu.daslab.thrift.base.Platform;
import fdu.daslab.thrift.base.Stage;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 在kubernetes上执行
 *
 * @author 唐志伟
 * @version 1.0
 * @since 5/23/21 5:38 PM
 */
@Component
public class KubernetesExecutor implements Executor {

    @Autowired
    private OperatorClient operatorClient;

    @Autowired
    private ParamAdapter paramAdapter;

    @Autowired
    private StrategyFactory strategyFactory;

    @Override
    public void execute(Stage stage) throws TTransportException {
        Platform platform = null;
        operatorClient.open();
        try {
            platform = operatorClient.getClient().findPlatformInfo(stage.platformName);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            operatorClient.close();
        }

        // 创建 pod 或者 创建 operator
        assert platform != null;
        // 都是需要先获取容器相关参数
        List<String> params = paramAdapter.wrapperExecutionArguments(stage);
        // 调用kubernetes的rest接口去创建对应的任务
        strategyFactory.getStrategyForPlatform(platform.name)
                .create(stage, platform, params);

    }


//    // 如果是内部的kubernetes，可能通过轮询方法获取状态；但是对于外部的环境，只能通过获取
//    @Override
//    public Stage findStageStatus(Stage stage) {
//        return strategyFactory.getStrategyForPlatform(stage.platformName)
//                .findStatus(stage);
//    }


}
