package com.ideas.DAO;

import java.util.List;

import com.ideas.model.Blog;

public interface BlogDAO 
{
public boolean addBlog(Blog blog);
public boolean deleteBlog(Blog blog);
public boolean updateBlog(Blog blog);
public Blog getBlog(int blogId);
public List<Blog> getAllBlogs();
public boolean incrementLikes(Blog blog);
public boolean incrementDisLikes(Blog blog);
public boolean approvedBlog(Blog blog);
public boolean rejectBlog(Blog blog);

}
