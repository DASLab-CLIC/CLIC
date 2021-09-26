package fdu.daslab.operatorcenter.repository;

import fdu.daslab.operatorcenter.init.OperatorInit;
import fdu.daslab.operatorcenter.init.PlatformInit;
import fdu.daslab.thrift.base.Operator;
import fdu.daslab.thrift.base.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 算子和平台的存储和读写，暂时使用内存，后面都需要使用其他的存储方式
 *
 * @author 唐志伟
 * @version 1.0
 * @since 5/26/21 4:45 PM
 */
@Repository
public class OperatorRepository {

    private Map<String, Operator> operators;
    private Map<String, Platform> platforms;

    @Autowired
    public OperatorRepository(OperatorInit operatorInit, PlatformInit platformInit) {
        // 默认先加载项目中的logical的operator
        operators = operatorInit.init();
        platforms = platformInit.init();
    }

    public void addPlatform(Platform platform) {
        platforms.put(platform.name.toLowerCase(), platform);
    }

    public Platform findPlatformInfo(String platformName) {
        return platforms.get(platformName.toLowerCase());
    }

    public Map<String, Platform> listPlatforms() {
        return platforms;
    }

    public void setPlatformInfo(String platformName, Platform platform){
        Platform oldPlatform = platforms.get(platformName);
        if(platform.getDefaultImage() != null) oldPlatform.setDefaultImage(platform.getDefaultImage());
        oldPlatform.setUseOperator(platform.isUseOperator());
        if (platform.getExecCommand() != null) oldPlatform.setExecCommand(platform.getExecCommand());
        if(platform.getLanguage() != null) oldPlatform.setLanguage(platform.getLanguage());
        if(platform.getParams().size() != 0){
            for(Map.Entry<String, String> entry : platform.getParams().entrySet()){
                oldPlatform.getParams().put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void addOperator(Operator operator) {
        operators.put(operator.name, operator);
    }

    public Operator findOperatorInfo(String operatorName) {
        return operators.get(operatorName);
    }
}
