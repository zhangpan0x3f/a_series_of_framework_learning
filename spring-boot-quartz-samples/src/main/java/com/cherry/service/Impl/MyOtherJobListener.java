package com.cherry.service.Impl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;

/**
 * @author : zhang pan
 * @date : 2:12 下午 2021/9/20
 * 描述：
 */
public class MyOtherJobListener extends JobListenerSupport {

    private String name;

    public MyOtherJobListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        super.jobWasExecuted(context, jobException);
    }
}
