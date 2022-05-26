package com.mapper;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    boolean addBlog(Blog blog);

    List<Blog> queryBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    boolean updateBlog(Map map);

    List<Blog> queryBlogBylist(Map map);
}
