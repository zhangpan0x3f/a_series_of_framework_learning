package com.cherry.service.Impl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : zhang pan
 * @date : 2:25 下午 2021/9/20
 * 描述：
 */
@Component
public class SimpleTriggerTest {

    @Bean
    public void trigger(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job1","group1")
                    .usingJobData("middleware", "dubbo")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInSeconds(3600)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger1(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job2","group1")
                    .usingJobData("middleware", "redis")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInMinutes(60)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger2(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job3","group1")
                    .usingJobData("middleware", "springcloud")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger3", "group1")
                    .startNow()
                    .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                            .withIntervalInMinutes(90))
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger3(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job4","group1")
                    .usingJobData("middleware", "springboot")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger4", "group1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 0))
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger4(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job5","group1")
                    .usingJobData("middleware", "spring")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger5", "group1")
                    .startAt(DateBuilder.tomorrowAt(15, 0, 0))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInHours(24) // interval is actually set at 24 hours' worth of milliseconds
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger5(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job6","group1")
                    .usingJobData("middleware", "cassandra")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger6", "group1")
                    .startAt(DateBuilder.tomorrowAt(15, 0, 0))
                    .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                            .withIntervalInDays(1))
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger6(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job7","group1")
                    .usingJobData("middleware", "aerospike")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger7", "group1")
                    .startAt(DateBuilder.tomorrowAt(15, 0, 0))
                    .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                            .withIntervalInDays(1))
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger7(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job8","group1")
                    .usingJobData("middleware", "cassandra")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger8", "group1")
                    .startAt(DateBuilder.tomorrowAt(15, 0, 0))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInHours(2 * 24) // interval is actually set at 48 hours' worth of milliseconds
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void trigger8(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job9","group1")
                    .usingJobData("middleware", "aerospike")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger9", "group1")
                    .startAt(DateBuilder.tomorrowAt(15, 0, 0))
                    .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                            .withIntervalInDays(2))
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    //Create a CronTrigger. that executes every Wednesday at 3:00PM:
    /**
     * trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.WEDNESDAY, 15, 0)) // fire every wednesday at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(cronSchedule("0 0 15 ? * WED")) // fire every wednesday at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startAt(tomorrowAt(15, 0, 0)  // first fire time 15:00:00 tomorrow
     *     .withSchedule(simpleSchedule()
     *             .withIntervalInHours(7 * 24) // interval is actually set at 7 * 24 hours' worth of milliseconds
     *             .repeatForever())
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startAt(tomorrowAt(15, 0, 0)  // 15:00:00 tomorrow
     *     .withSchedule(calendarIntervalSchedule()
     *             .withIntervalInWeeks(1)) // interval is set in calendar weeks
     *     .build();
     */

    //Trigger That Executes Every 2 Weeks
    /**
     * trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startAt(tomorrowAt(15, 0, 0)  // first fire time 15:00:00 tomorrow
     *     .withSchedule(simpleSchedule()
     *             .withIntervalInHours(14 * 24) // interval is actually set at 14 * 24 hours' worth of milliseconds
     *             .repeatForever())
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startAt(tomorrowAt(15, 0, 0)  // 15:00:00 tomorrow
     *     .withSchedule(calendarIntervalSchedule()
     *             .withIntervalInWeeks(2)) // interval is set in calendar weeks
     *     .build();
     */

    //Trigger That Executes Every Month
    /**
     * trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(monthlyOnDayAndHourAndMinute(5, 15, 0)) // fire on the 5th day of every month at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(cronSchedule("0 0 15 5 * ?")) // fire on the 5th day of every month at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(cronSchedule("0 0 15 L * ?")) // fire on the last day of every month at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(cronSchedule("0 0 15 LW * ?")) // fire on the last weekday day of every month at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startNow()
     *     .withSchedule(cronSchedule("0 0 15 L-3 * ?")) // fire on the third to last day of every month at 15:00
     *     .build();
     *
     *     trigger = newTrigger()
     *     .withIdentity("trigger3", "group1")
     *     .startAt(tomorrowAt(15, 0, 0)  // 15:00:00 tomorrow
     *     .withSchedule(calendarIntervalSchedule()
     *             .withIntervalInMonths(1)) // interval is set in calendar months
     *     .build();
     */

}
