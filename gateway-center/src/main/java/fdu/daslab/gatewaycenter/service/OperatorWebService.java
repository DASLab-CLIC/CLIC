package fdu.daslab.gatewaycenter.service;

import fdu.daslab.gatewaycenter.client.OperatorClient;
import fdu.daslab.gatewaycenter.utils.OperatorBuilder;
import fdu.daslab.thrift.base.Operator;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/11 15:21
 */
@Service
public class OperatorWebService {

    @Autowired
    public OperatorBuilder operatorBuilder;

    @Autowired
    public OperatorClient operatorClient;

    public void updateOperator(String operatorName, String updateJson) throws TException{
        Operator operator = operatorBuilder.parseJson(updateJson);
        operatorClient.open();
        try {
            operatorClient.getClient().setOperatorInfo(operatorName, operator);
        } finally {
            operatorClient.close();
        }
    }
}
