package com.ideas.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.BlogCommentDAO;
import com.ideas.model.BlogComment;

public class BlogCommentTesting 
{
	static BlogCommentDAO blogCommentDAO;

	@BeforeClass
	public static void initailize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ideas");
		context.refresh();
		
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
		
	}
	
	@Ignore
	@Test
	public void addBlogCommentTest() 
	{
	    BlogComment blogComment=new BlogComment();
		blogComment.setBlogId(102);
	    blogComment.setCommentText("HelpFul");
	    blogComment.setCommentDate(new java.util.Date());
	    blogComment.setUsername("aki");

	    assertTrue("Problem in Adding :",blogCommentDAO.addBlogComment(blogComment));
	}

	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(2002);
	    assertTrue("Problem in Deleting:",blogCommentDAO.deleteBlogComment(blogComment));

	}
	@Ignore
	@Test
	public void listblogcmnts()
	{
		List<BlogComment> listblogComments=blogCommentDAO.listBlogComments(1052);
		assertTrue("problem in listing",listblogComments.size()>0);
		for(BlogComment blogComment: listblogComments)
		{
			System.out.print(blogComment.getUsername()+"\t");
			System.out.print(blogComment.getCommentText()+"\t");
			System.out.println(blogComment.getCommentDate()+"\t");
		}
	}
}
