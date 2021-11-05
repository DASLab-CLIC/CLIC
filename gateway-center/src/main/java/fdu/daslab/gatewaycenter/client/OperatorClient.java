package fdu.daslab.gatewaycenter.client;

import fdu.daslab.common.thrift.ThriftClient;
import fdu.daslab.thrift.operatorcenter.OperatorCenter;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 李姜辛
 * @description
 * @since 2021/9/25 17:07
 */

@Component
public class OperatorClient extends ThriftClient<OperatorCenter.Client> {

    @Value("${thrift.operator.host}")
    private String host;

    @Value("${thrift.operator.port}")
    private int port;


    @Override
    protected OperatorCenter.Client createClient(TBinaryProtocol protocol) {
        return new OperatorCenter.Client(protocol);
    }

    @Override
    protected String getHost() {
        return host;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
