package com.cherry.service.Impl;

/**
 * @author : zhang pan
 * @date : 2:21 下午 2021/9/20
 * 描述：
 */
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;

public class MyOtherTriggerListener extends TriggerListenerSupport {

    private String name;

    public MyOtherTriggerListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        // do something with the event
    }
}