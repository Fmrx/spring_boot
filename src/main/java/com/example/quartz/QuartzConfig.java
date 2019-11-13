package com.example.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail myJobDetails() {
        JobDetail jobDetail = JobBuilder.newJob(TestTask.class)
                .withIdentity("job1", "jobGroup1")
                .usingJobData("job_params", "job_params1")
                .storeDurably()
                .build();
        return jobDetail;
    }

    @Bean
    public Trigger myTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(myJobDetails())
                .withIdentity("trigger1", "triggerGroup1")
                .usingJobData("trigger_params", "trigger_params1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5, *, *, *, *, ?"))
                .startNow()
                .build();
        return trigger;
    }

}
