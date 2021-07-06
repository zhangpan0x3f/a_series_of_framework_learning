package com.demo.controller;

import com.demo.entity.Blog;
import com.demo.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhang pan
 * @Description 类描述
 */
@RestController
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/selectBlog")
    public Blog blog(Integer id){
        return blogService.selectBlog(id);
    }

}
