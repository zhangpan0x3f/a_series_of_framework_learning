package com.cherry.service;

/**
 * @author : zhang pan
 * @date : 11:36 上午 2021/9/4
 * 描述：
 */
public interface QuartzService {
    void quartzTest();

    void defineJob();

    void storeJob();

    void removeTrigger();
}
