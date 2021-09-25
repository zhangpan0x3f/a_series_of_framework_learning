package com.cherry.model;

import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author : zhang pan
 * @date : 8:12 下午 2021/9/21
 * 描述：
 */
public class DumbJob1 implements Job {

    public DumbJob1() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //1.拿到key
        JobKey key = context.getJobDetail().getKey();
        //2.拿到datamap
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        ArrayList state = (ArrayList)dataMap.get("list");
        state.add(new Date());
        state.add(new Date(System.currentTimeMillis() + 100000000L));
        //3.相应的处理
        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue + " " + state);
    }
}
