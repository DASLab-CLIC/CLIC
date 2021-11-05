package fdu.daslab.jobcenter.service;

import fdu.daslab.gatewaycenter.client.JobClient;
import fdu.daslab.gatewaycenter.service.JobWebService;
import fdu.daslab.jobcenter.client.OptimizerClient;
import fdu.daslab.jobcenter.repository.JobRepository;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/16 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class JobHandlerTest {

//    @Autowired
//    private JobHandler jobHandler;
//
//    @Autowired
//    private JobRepository jobRepository;

    @Autowired
    private JobWebService jobWebService;
//
//    @Autowired
//    private JobClient jobClient;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getResult() throws TException, IOException {
        String file = "src/test/resources/pytorchJobPlan.json";
        String jsonStr = new String(Files.readAllBytes(Paths.get(file)));
//        System.out.println(jsonStr);

        jobWebService.submit("simpleTest", jsonStr);
        Map<Integer, Map<Integer, String>> res = jobWebService.getResult("simpleTest");
//        Map<Integer, Map<Integer, String>> res = jobHandler.getResult("simpleTest");
        System.out.println(res.isEmpty());
        for(Map.Entry<Integer, Map<Integer, String>> entry : res.entrySet()){
            System.out.println(entry);
        }
    }
}