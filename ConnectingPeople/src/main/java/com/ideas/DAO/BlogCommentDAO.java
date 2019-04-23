package com.ideas.DAO;

import java.util.List;

import com.ideas.model.BlogComment;

public interface BlogCommentDAO 
{

public boolean addBlogComment(BlogComment blogComment);
public boolean deleteBlogComment(BlogComment blogComment);
public List<BlogComment> listBlogComments(int blogId);
public BlogComment getBlogComment(int blogCommentId);
}
