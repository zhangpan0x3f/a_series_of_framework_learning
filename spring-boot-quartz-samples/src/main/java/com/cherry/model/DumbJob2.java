package com.cherry.model;

import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author : zhang pan
 * @date : 8:35 下午 2021/9/21
 * 描述：
 */
public class DumbJob2 implements Job {

    private String jobSays;
    private float myFloatValue;
    private ArrayList list;

    public DumbJob2() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getMergedJobDataMap();  // Note the difference from the previous example

        list.add(new Date());
        list.add(new Date(System.currentTimeMillis() + 100000000L));

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue + " " + list);

    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }
}
