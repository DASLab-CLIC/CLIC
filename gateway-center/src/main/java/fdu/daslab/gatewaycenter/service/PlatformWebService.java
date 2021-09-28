package fdu.daslab.gatewaycenter.service;

import fdu.daslab.gatewaycenter.client.OperatorClient;
import fdu.daslab.gatewaycenter.utils.PlatformBuilder;
import fdu.daslab.thrift.base.Platform;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李姜辛
 * @description
 * @since 2021/9/27 15:41
 */

@Service
public class PlatformWebService {

    @Autowired
    public PlatformBuilder platformBuilder;

    @Autowired
    public OperatorClient operatorClient;

    public void updatePlatform(String platformName, String updateJson) throws TException {
        Platform platform = platformBuilder.parseJson(updateJson);
        operatorClient.open();
        try {
            operatorClient.getClient().setPlatformInfo(platformName, platform);
        } finally {
            operatorClient.close();
        }
    }
}
