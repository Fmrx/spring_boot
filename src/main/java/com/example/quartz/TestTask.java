package com.example.quartz;

import com.example.quartz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

@Slf4j
public class TestTask extends QuartzJobBean {

    @Resource
    private TestService testService;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        testService.testService();
    }
}
