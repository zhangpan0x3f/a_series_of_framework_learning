package com.demo.service.Impl;

import com.demo.entity.Blog;
import com.demo.mapper.BlogMapper;
import com.demo.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhang pan
 * @Description 类描述
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public Blog selectBlog(Integer id) {
        return blogMapper.selectBlog(id);
    }
}
