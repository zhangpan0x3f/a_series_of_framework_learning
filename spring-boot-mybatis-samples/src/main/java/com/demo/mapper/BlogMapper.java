package com.demo.mapper;

import com.demo.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhang pan
 * @Description 映射器
 */
@Mapper
public interface BlogMapper {

    public Blog selectBlog(Integer id);

}
