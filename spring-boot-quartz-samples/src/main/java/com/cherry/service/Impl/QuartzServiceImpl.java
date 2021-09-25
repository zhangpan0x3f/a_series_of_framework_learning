package com.cherry.service.Impl;

import com.cherry.model.HelloJob;
import com.cherry.service.QuartzService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerKey.triggerKey;
import static org.quartz.impl.matchers.EverythingMatcher.allJobs;
import static org.quartz.impl.matchers.GroupMatcher.groupEquals;

/**
 * @author : zhang pan
 * @date : 11:36 上午 2021/9/4
 * 描述：
 */
@Service
public class QuartzServiceImpl implements QuartzService {

    @Override
    public void quartzTest(){
        try {
            //实例化一个调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(
                            simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);

            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void instance(){
        StdSchedulerFactory sf = new StdSchedulerFactory();
        try {
            //Instantiating A Specific Scheduler From Specific Properties
            sf.initialize("quartz.properties");
            //Instantiating the Default Scheduler
            Scheduler scheduler = sf.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void standBy(){
        StdSchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler scheduler = sf.getScheduler();
            // start() was previously invoked on the scheduler
            scheduler.standby();
            // now the scheduler will not fire triggers / execute jobs
            scheduler.start();
            // now the scheduler will fire triggers and execute jobs
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void shutdown(){
        StdSchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler scheduler = sf.getScheduler();
            scheduler.start();
            //shutdown() does not return until executing Jobs complete execution
            scheduler.shutdown(true);
            //shutdown() returns immediately, but executing Jobs continue running to completion
            scheduler.shutdown();
            //or
            scheduler.shutdown(false);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void initializeWithServlet(){
        /**
         * ...
         *      <context-param>
         *          <param-name>quartz:config-file</param-name>
         *          <param-value>/some/path/my_quartz.properties</param-value>
         *      </context-param>
         *      <context-param>
         *          <param-name>quartz:shutdown-on-unload</param-name>
         *          <param-value>true</param-value>
         *      </context-param>
         *      <context-param>
         *          <param-name>quartz:wait-on-shutdown</param-name>
         *          <param-value>false</param-value>
         *      </context-param>
         *      <context-param>
         *          <param-name>quartz:start-scheduler-on-load</param-name>
         *          <param-value>true</param-value>
         *      </context-param>
         * ...
         *      <listener>
         *          <listener-class>
         *              org.quartz.ee.servlet.QuartzInitializerListener
         *          </listener-class>
         *      </listener>
         * ...
         */

        /**
         * ...
         * 	<servlet>
         * 	  <servlet-name>QuartzInitializer</servlet-name>
         * 	  <servlet-class>org.quartz.ee.servlet.QuartzInitializerServlet</servlet-class>
         * 	  <init-param>
         *
         * 	    <param-name>shutdown-on-unload</param-name>
         * 	    <param-value>true</param-value>
         * 	  </init-param>
         * 	  <load-on-startup>2</load-on-startup>
         *
         * 	</servlet>
         * ...
         */
    }

    @Override
    public void defineJob(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            //Defining a Job Instance
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("someProp", "someValue")
                    .build();
            // Define a Trigger that will fire "now", and not repeat
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .build();
            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2","group1")
                    .startNow()
                    .build();
            //Unschedule a particular trigger from the job (a job may have more than one trigger)
            scheduler.unscheduleJob(triggerKey("trigger1", "group1"));
            //Deleting a Job and Unscheduling All of Its Triggers
            // Schedule the job with the trigger
            //scheduler.deleteJob(jobKey("job1", "group1"));
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeJob(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            // Define a durable job instance (durable jobs can exist without triggers)
            JobDetail job = JobBuilder.newJob(PrintPropsJob.class)
                    .withIdentity("job4", "group1")
                    .usingJobData("someProp", "someValue")
                    .storeDurably()
                    .build();
            // Add the the job to the scheduler's store
            scheduler.addJob(job,false);

            //Scheduling an already stored job
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .forJob(jobKey("job4", "group1"))
                    .build();
            scheduler.scheduleJob(trigger);
            scheduler.start();
            scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTrigger(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("newTrigger", "group1")
                    .startNow()
                    .build();
            // tell the scheduler to remove the old trigger with the given key, and put the new one in its place
            scheduler.rescheduleJob(triggerKey("oldTrigger", "group1"), trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTrigger(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();


            // retrieve the trigger
            Trigger oldTrigger = scheduler.getTrigger(triggerKey("oldTrigger", "group1"));

            // obtain a builder that would produce the trigger
            TriggerBuilder tb = oldTrigger.getTriggerBuilder();

            // update the schedule associated with the builder, and build the new trigger
            // (other builder methods could be called, to change the trigger in any desired way)
            Trigger newTrigger = tb.withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(10)
                            .withRepeatCount(10))
                            .build();
            scheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void listenJobs(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            //Listing all Jobs in the scheduler
            // enumerate each job group
            for(String group: scheduler.getJobGroupNames()) {
                // enumerate each job in group
                for(JobKey jobKey : scheduler.getJobKeys(groupEquals(group))) {
                    System.out.println("Found job identified by: " + jobKey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listenTriggers(){
        try {
            //Listing all Triggers in the scheduler
            // enumerate each trigger group
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            for(String group: scheduler.getTriggerGroupNames()) {
                // enumerate each trigger in group
                for(TriggerKey triggerKey : scheduler.getTriggerKeys(groupEquals(group))) {
                    System.out.println("Found trigger identified by: " + triggerKey);
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void findTriggersOfJob(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            List<? extends Trigger> jobTriggers = scheduler.getTriggersOfJob(jobKey("jobName", "jobGroup"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void listenAllJobs(){
        try {
            StdSchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            //Registering A JobListener With The Scheduler To Listen To All Jobs
            scheduler.getListenerManager().addJobListener(new MyJobListener("myJobListener"),allJobs());
            //Registering A JobListener With The Scheduler To Listen To A Specific Job
            //scheduler.getListenerManager().addJobListener(new MyJobListener("myJobListener"),jobKeyEquals(jobKey("myJobName", "myJobGroup")));
            //Registering A JobListener With The Scheduler To Listen To All Jobs In a Group
            //scheduler.getListenerManager().addJobListener(myJobListener, jobGroupEquals("myJobGroup"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void listenAllTriggers(){
        //Registering A TriggerListener With The Scheduler To Listen To All Triggers
        //scheduler.getListenerManager().addTriggerListener(myTriggerListener, allTriggers());
        //Registering A TriggerListener With The Scheduler To Listen To A Specific Trigger
        //scheduler.getListenerManager().addTriggerListener(myTriggerListener, triggerKeyEquals(triggerKey("myTriggerName", "myTriggerGroup")));
        //Registering A TriggerListener With The Scheduler To Listen To All Triggers In a Group
        //scheduler.getListenerManager().addTriggerListener(myTriggerListener, triggerGroupEquals("myTriggerGroup"));
    }

}
