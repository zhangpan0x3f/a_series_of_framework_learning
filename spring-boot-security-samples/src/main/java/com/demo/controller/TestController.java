package com.demo.controller;

import com.demo.entity.Users;
import com.demo.service.MyUserDetailsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
//    @PreAuthorize("hasAnyRole('ROLE_admin')")  //访问前进行权限校验
    @PostAuthorize("hasAnyRole('ROLE_admin')")  //方法执行完进行一个权限的校验
//    @PreFilter() //传入方法数据进行过滤
//    @PostFilter() //方法返回数据进行过滤
    public String update(){
        System.out.println("update");
        return "hello admin";
    }

    @GetMapping("/getall")
    @PostAuthorize("hasAnyRole('ROLE_admin')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAll(){
        List<Users> l = new ArrayList<>();
        l.add(new Users(11,"admin1","6666"));
        l.add(new Users(21,"admin2","888"));
        System.out.println(l);
        return l;
    }

}
