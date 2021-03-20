package com.demo.controller;

import com.demo.service.MyUserDetailsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhang pan
 * @Description 类描述
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }

    @GetMapping("/index")
    public String index(){
        return "hello index";
    }

    @GetMapping("/update")
//    @Secured({"ROLE_admin","manager"})
    @PreAuthorize("hasAnyRole('ROLE_admin')")
    public String update(){
        return "hello index";
    }

}
