package com.demo.service;

import com.demo.entity.Blog;

/**
 * @author zhang pan
 * @Description 类描述
 */
public interface BlogService {

    /**
     * 查看一篇博客
     * @param id
     * @return
     */
    public Blog selectBlog(Integer id);

}
