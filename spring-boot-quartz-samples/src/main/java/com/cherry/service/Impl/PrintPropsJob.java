package com.cherry.service.Impl;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author : zhang pan
 * @date : 10:19 上午 2021/9/20
 * 描述：
 */
public class PrintPropsJob implements Job {

    // Instances of Job must have a public no-argument constructor.
    public PrintPropsJob() {
    }

    //Defining a Job
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getMergedJobDataMap();
        System.out.println("middleware = " + data.getString("middleware"));
    }
}
