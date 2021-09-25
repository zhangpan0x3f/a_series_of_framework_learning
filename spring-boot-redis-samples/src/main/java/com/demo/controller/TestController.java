package com.demo.controller;

import com.demo.service.Impl.DistributedLocks;
import com.demo.service.JedisService;
import com.demo.service.TestService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zhang pan
 * @date : 11:15 上午 2021/6/10
 * 描述：
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private JedisService jedisService;

    @Resource
    private DistributedLocks distributedLocks;

    @PostMapping("/value")
    public String setValue(@RequestParam String key,@RequestParam String value){
        testService.setValue(key, value);
        return "ok";
    }

    @GetMapping("/value")
    public String getValue(@RequestParam String key){
        return testService.getValue(key);
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @GetMapping("/get")
    public String get(){
        jedisService.get();
        return "ok";
    }
    
}
