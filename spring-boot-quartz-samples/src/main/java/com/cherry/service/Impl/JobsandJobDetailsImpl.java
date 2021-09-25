package com.cherry.service.Impl;

import com.cherry.model.DumbJob;
import com.cherry.model.DumbJob1;
import com.cherry.model.DumbJob2;
import com.cherry.service.JobsandJobDetails;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author : zhang pan
 * @date : 7:41 下午 2021/9/21
 * 描述：
 */
@Service
public class JobsandJobDetailsImpl implements JobsandJobDetails {

    @Override
    public void job(){
        try {
            //1.创建调度器
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            //2.构建job
            JobDetail job = JobBuilder.newJob(DumbJob.class)
                    .withIdentity("job2", "group2")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();
            //3.构建触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group2")
                    .startNow()
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void job1(){
        try {
            //1.创建调度器
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            //2.构建job
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("list",new ArrayList<Date>());
            JobDetail job = JobBuilder.newJob(DumbJob1.class)
                    .withIdentity("job1", "group2")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .usingJobData(dataMap)
                    .build();
            //3.构建触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group2")
                    .startNow()
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void job2(){
        try {
            //1.创建调度器
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            //2.构建job
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("list",new ArrayList<Date>());
            JobDetail job = JobBuilder.newJob(DumbJob2.class)
                    .withIdentity("job3", "group2")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .usingJobData(dataMap)
                    .build();
            //3.构建触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger3", "group2")
                    .startNow()
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
