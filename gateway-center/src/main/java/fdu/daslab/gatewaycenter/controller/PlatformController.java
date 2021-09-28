package fdu.daslab.gatewaycenter.controller;

import fdu.daslab.gatewaycenter.service.PlatformWebService;
import fdu.daslab.gatewaycenter.utils.api.R;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李姜辛
 * @description
 * @since 2021/9/27 15:39
 */

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    PlatformWebService platformWebService;

    @PutMapping("/updateinfo")
    public R updatePlatform(@RequestParam String platformName, @RequestBody String updateJson) throws TException {
        platformWebService.updatePlatform(platformName, updateJson);
        return R.ok();
    }
}
