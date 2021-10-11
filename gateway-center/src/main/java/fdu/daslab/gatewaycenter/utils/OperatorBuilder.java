package fdu.daslab.gatewaycenter.utils;

import com.google.gson.Gson;
import fdu.daslab.thrift.base.Operator;
import org.springframework.stereotype.Component;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/11 15:24
 */
@Component
public class OperatorBuilder {
    public Operator parseJson(String jsonStr){
        Gson gson = new Gson();
        Operator operator = gson.fromJson(jsonStr, Operator.class);
        return operator;
    }
}
