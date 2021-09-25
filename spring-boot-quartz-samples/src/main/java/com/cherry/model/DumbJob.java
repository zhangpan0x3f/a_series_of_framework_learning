package com.cherry.model;

import org.quartz.*;

/**
 * @author : zhang pan
 * @date : 7:43 下午 2021/9/21
 * 描述：
 */
//@DisallowConcurrentExecution
//@PersistJobDataAfterExecution
public class DumbJob implements Job {

    public DumbJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        System.out.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}
