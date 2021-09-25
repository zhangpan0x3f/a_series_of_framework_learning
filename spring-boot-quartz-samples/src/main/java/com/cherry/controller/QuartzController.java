package com.cherry.controller;

import com.cherry.service.JobsandJobDetails;
import com.cherry.service.QuartzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zhang pan
 * @date : 11:37 上午 2021/9/4
 * 描述：
 */
@RestController
public class QuartzController {

    @Resource
    private QuartzService quartzService;

    @Resource
    private JobsandJobDetails jobsandJobDetails;

    @GetMapping("/quartz")
    public String quartz(){
        quartzService.quartzTest();
        return "ok";
    }

    @GetMapping("/defineJob")
    public String defineJob(){
        quartzService.defineJob();
        return "ok";
    }

    @GetMapping("/storeJob")
    public String storeJob(){
        quartzService.storeJob();
        return "ok";
    }

    @GetMapping("/job")
    public String job(){
        jobsandJobDetails.job();
        return "ok";
    }

    @GetMapping("/job1")
    public String job1(){
        jobsandJobDetails.job1();
        return "ok";
    }

    @GetMapping("/job2")
    public String job2(){
        jobsandJobDetails.job2();
        return "ok";
    }

}
