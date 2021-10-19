package fdu.daslab.gatewaycenter.controller;

import fdu.daslab.gatewaycenter.service.JobWebService;
import fdu.daslab.gatewaycenter.utils.api.R;
import fdu.daslab.thrift.base.Job;
import org.apache.thrift.TException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.alibaba.fastjson.JSONObject;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/15 19:53
 */
public class JobControllerTest {

    @InjectMocks
    private JobController jobController;

    @Mock
    private JobWebService jobWebService;
    private MockMvc mockMvc;
    private R r = new R();
    private Job job = new Job();
    private Map<Integer, Map<Integer, String>> map = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(jobController).build();
    }

    @Test
    public void checkJob() throws Exception{
        Mockito.doReturn(job).when(jobWebService).checkJob(Mockito.anyString());
//        Mockito.when(jobWebService.checkJob(Mockito.any(String.class))).thenReturn(r);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/job/check?jobName=simple"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        R resObj = JSONObject.parseObject(result, R.class);
        resObj.put("data", null);
        Assert.assertEquals(r, resObj);
    }

    @Test
    public void getResult() throws Exception {
        Mockito.doReturn(map).when(jobWebService).getResult(Mockito.anyString());
//        Mockito.when(jobWebService.checkJob(Mockito.any(String.class))).thenReturn(r);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/job/check?jobName=simple"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        R resObj = JSONObject.parseObject(result, R.class);
        resObj.put("data", null);
        Assert.assertEquals(r, JSONObject.parseObject(result, R.class));
    }
}