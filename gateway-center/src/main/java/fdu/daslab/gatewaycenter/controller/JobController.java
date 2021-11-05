package fdu.daslab.gatewaycenter.controller;

import fdu.daslab.gatewaycenter.constant.ErrorCode;
import fdu.daslab.gatewaycenter.service.JobWebService;
import fdu.daslab.gatewaycenter.utils.api.R;
import fdu.daslab.thrift.base.Job;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zjchenn
 * @description
 * @since 2021/6/9 下午4:42
 */

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobWebService jobWebService;

    @PostMapping("/submit")
    public R submitJob(@RequestParam String jobName, @RequestBody String planJsonString) throws TException {
        jobWebService.submit(jobName, planJsonString);
            return R.ok();
    }

    @GetMapping("/check")
    public R checkJob(@RequestParam String jobName){
        try {
            Job job = jobWebService.checkJob(jobName);
            return R.ok(job);
        } catch (Exception e){
            return R.error(ErrorCode.QUERY_FAIL, ErrorCode.QUERY_FAIL_MSG);
        }

    }

    @GetMapping("/getresult")
    public R getResult(@RequestParam String jobName) throws TException {
        try {
            Map<Integer, Map<Integer, String>> result = jobWebService.getResult(jobName);
            return R.ok(result);
        } catch (Exception e){
            return R.error(ErrorCode.QUERY_FAIL, ErrorCode.QUERY_FAIL_MSG);
        }
    }
}
