package fdu.daslab.gatewaycenter.service;

import fdu.daslab.gatewaycenter.client.JobClient;
import fdu.daslab.gatewaycenter.client.OperatorClient;
import fdu.daslab.gatewaycenter.utils.PlanBuilder;
import fdu.daslab.gatewaycenter.utils.PlatformBuilder;
import fdu.daslab.thrift.base.Job;
import fdu.daslab.thrift.base.Plan;
import fdu.daslab.thrift.base.Platform;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zjchenn
 * @since 2021/6/10 上午10:06
 * @description
 */

@Service
public class JobWebService {

    @Autowired
    public JobClient jobService;

    @Autowired
    public PlanBuilder planBuilder;


    public void submit(String jobName, String planJsonString) throws TException {
        Plan plan = planBuilder.parseJson(planJsonString);
        jobService.open();
        try {
            jobService.getClient().submit(plan, jobName);
        } finally {
            jobService.close();
        }
    }

    public Job checkJob(String jobName) throws TException {
        jobService.open();
        try {
            return jobService.getClient().findJob(jobName);
        } finally {
            jobService.close();
        }
    }

    public Map<Integer, Map<Integer, String>> getResult(String jobName) throws TException {
        jobService.open();
        try {
            return jobService.getClient().getResult(jobName);
        } finally {
            jobService.close();
        }
    }
}
