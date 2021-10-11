package fdu.daslab.executorcenter.adapter;

import fdu.daslab.thrift.base.PlanNode;
import fdu.daslab.thrift.base.Stage;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zjchen
 * @time 2021/9/17 11:05 上午
 * @description
 */

@Component
public class HpcParamAdapter {

    private final static String SCRIPT_PATH = "/es01/shanhe/hpc_mnt/src/COAWST_v1467/Projects/JOE_TC/Coupled/clic.bash";
    private final Map<String, Integer> globalSetMap = new HashMap<String, Integer>(){{
        put("wrfOperator", 2);
        put("oceanOperator", 3);
        put("couplingOperator", 4);
    }};

    public String getScript(Stage stage){
        List<String> commandList= new ArrayList<>();
        List<String> globalSetFlag = new ArrayList<>(Arrays.asList(SCRIPT_PATH, "GLOBAL", "undef", "undef", "undef"));
        stage.planInfo.nodes.forEach((key, value)->{
            try {
                commandList.add(switchStrategy(value));

                // 遍历时设置全局配置
                if(globalSetMap.containsKey(value.operatorInfo.name)){
                    if(globalSetFlag.get(globalSetMap.get(value.operatorInfo.name)).equals("undef")){
                        globalSetFlag.set(globalSetMap.get(value.operatorInfo.name), "define");
                    } else {
                        throw new Exception("Don't submit duplicate operators");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // global set insert
        commandList.add(0, String.join(" ", globalSetFlag));
        return String.join(";", commandList);
    }

    private String switchStrategy(PlanNode planNode) throws ParseException {

        switch (planNode.operatorInfo.name){
            case "wrfOperator":
                return wrfOperatorWrapper(planNode);
            case "oceanOperator":
                return oceanOperatorWrapper(planNode);
            case "couplingOperator":
                return couplingOperatorWrapper(planNode);
            case "submitOperator":
                return submitOperatorWrapper(planNode);
            default:
                throw new IllegalArgumentException("HPC operator type error, please examine the operator name");
        }

    }

    private String submitOperatorWrapper(PlanNode planNode) {
        List<String> command = new ArrayList<>();
        command.add(0, SCRIPT_PATH);
        command.add(1, "COMMIT");
        command.add(2, planNode.operatorInfo.params.get("nodeNum"));
        return String.join(" ", command);
    }

    private String couplingOperatorWrapper(PlanNode planNode) {
        List<String> command = new ArrayList<>();
        command.add(0, SCRIPT_PATH);
        command.add(1, "MIX");
        command.add(2, planNode.operatorInfo.params.get("nodeATM"));
        command.add(3, planNode.operatorInfo.params.get("nodeOCN"));
        return String.join(" ", command);
    }

    private String oceanOperatorWrapper(PlanNode planNode) throws ParseException {
        List<String> command = new ArrayList<>();
        String endTime = planNode.operatorInfo.params.get("endTime");
        String startTime = planNode.operatorInfo.params.get("startTime");

        command.add(0, SCRIPT_PATH);
        command.add(1, "OCEAN");
        command.add(2, parseNtimes(startTime, endTime));
        command.add(3, planNode.operatorInfo.params.get("NtileI"));
        command.add(4, planNode.operatorInfo.params.get("NtileJ"));
        return String.join(" ", command);
    }

    private String wrfOperatorWrapper(PlanNode planNode) throws ParseException {
        List<String> command = new ArrayList<>();
        String endTime = planNode.operatorInfo.params.get("endTime");
        String startTime = planNode.operatorInfo.params.get("startTime");

        command.add(0, SCRIPT_PATH);
        command.add(1, "WRF");
        command.add(2, parseRunHour(startTime, endTime));
        command.add(3, planNode.operatorInfo.params.get("nproc_x"));
        command.add(4, planNode.operatorInfo.params.get("nproc_y"));
        return String.join(" ", command);
    }

    private String parseRunHour(String startTime, String endTime) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date start = ft.parse(startTime);
        Date end = ft.parse(endTime);
        int a = (int)((end.getTime() - start.getTime()) / (1000 * 60 * 60));
        return String.valueOf(a);
    }

    private String parseNtimes(String startTime, String endTime) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date start = ft.parse(startTime);
        Date end = ft.parse(endTime);
        int a = (int)((end.getTime() - start.getTime()) / (1000 * 25));
        return String.valueOf(a);
    }

}


