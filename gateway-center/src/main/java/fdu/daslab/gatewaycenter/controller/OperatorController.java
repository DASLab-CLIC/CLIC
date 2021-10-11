package fdu.daslab.gatewaycenter.controller;

import fdu.daslab.gatewaycenter.service.OperatorWebService;
import fdu.daslab.gatewaycenter.utils.api.R;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/11 14:32
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    OperatorWebService operatorWebService;

    @PutMapping("/updateinfo")
    public R updateOperator(@RequestParam String operatorName, @RequestBody String updateJson) throws TException{
        operatorWebService.updateOperator(operatorName, updateJson);
        return R.ok();
    }

}
