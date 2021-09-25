package com.cherry.service.Impl;

/**
 * @author : zhang pan
 * @date : 2:24 下午 2021/9/20
 * 描述：
 */
import org.quartz.Trigger;
import org.quartz.listeners.SchedulerListenerSupport;

public class MyOtherSchedulerListener extends SchedulerListenerSupport {

    @Override
    public void schedulerStarted() {
        // do something with the event
    }

    @Override
    public void schedulerShutdown() {
        // do something with the event
    }

    @Override
    public void jobScheduled(Trigger trigger) {
        // do something with the event
    }

    //Registering A SchedulerListener With The Scheduler
    //scheduler.getListenerManager().addSchedulerListener(mySchedListener);
}