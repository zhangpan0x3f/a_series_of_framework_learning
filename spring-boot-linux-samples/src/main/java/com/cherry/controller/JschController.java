package com.cherry.controller;

import com.cherry.service.JschService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zhang pan
 * @date : 10:49 下午 2021/9/22
 * 描述：
 */
@RestController
public class JschController {

    @Resource
    private JschService jschService;

    @GetMapping("/exec")
    public String exec(@RequestParam String ip,@RequestParam String password){
        jschService.exec(ip,password);
        return "ok";
    }

}
