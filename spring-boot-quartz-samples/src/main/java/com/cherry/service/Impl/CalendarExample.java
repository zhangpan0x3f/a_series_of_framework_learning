package com.cherry.service.Impl;

import org.quartz.impl.calendar.HolidayCalendar;

/**
 * @author : zhang pan
 * @date : 9:26 下午 2021/9/21
 * 描述：
 */
public class CalendarExample {
    /**
    HolidayCalendar cal = new HolidayCalendar();
    cal.addExcludedDate( someDate);
    cal.addExcludedDate( someOtherDate );

    sched.addCalendar("myHolidays", cal, false);


    Trigger t = newTrigger()
            .withIdentity("myTrigger")
            .forJob("myJob")
            .withSchedule(dailyAtHourAndMinute(9, 30)) // execute job daily at 9:30
            .modifiedByCalendar("myHolidays") // but not on holidays
            .build();

// .. schedule job with trigger

    Trigger t2 = newTrigger()
            .withIdentity("myTrigger2")
            .forJob("myJob2")
            .withSchedule(dailyAtHourAndMinute(11, 30)) // execute job daily at 11:30
            .modifiedByCalendar("myHolidays") // but not on holidays
            .build();

// .. schedule job with trigger2
     **/
}
