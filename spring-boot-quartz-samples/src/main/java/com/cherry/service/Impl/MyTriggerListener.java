package com.cherry.service.Impl;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @author : zhang pan
 * @date : 2:20 下午 2021/9/20
 * 描述：
 */
public class MyTriggerListener implements TriggerListener {

    private String name;

    public MyTriggerListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context,
                                Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        // do something with the event

    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        // do something with the event
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        // do something with the event
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        // do something with the event
        return false;
    }
}
