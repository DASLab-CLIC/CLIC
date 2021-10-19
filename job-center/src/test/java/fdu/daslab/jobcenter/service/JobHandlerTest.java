package fdu.daslab.jobcenter.service;

import fdu.daslab.jobcenter.client.OptimizerClient;
import fdu.daslab.jobcenter.repository.JobRepository;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/16 11:09
 */
public class JobHandlerTest {

    @InjectMocks
    private JobHandler jobHandler;

    @Mock
    private JobRepository jobRepository;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getResult() throws TException {
        Map<Integer, Map<Integer, String>> res = jobHandler.getResult("simpleTest");
        for(Map.Entry<Integer, Map<Integer, String>> entry : res.entrySet()){
            System.out.println(entry);
        }
    }
}