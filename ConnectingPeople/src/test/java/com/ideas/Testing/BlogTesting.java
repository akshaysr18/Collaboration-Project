package com.ideas.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.BlogDAO;
import com.ideas.model.Blog;

public class BlogTesting 
{
static BlogDAO blogDAO;

@BeforeClass
public static void initailize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ideas");
	context.refresh();
	
	blogDAO=(BlogDAO)context.getBean("blogDAO");
	
}
@Ignore
@Test
public void addBlogTest()
{
	Blog blog=new Blog();
	blog.setBlogName("Programming");
	blog.setBlogContent("CoreJava Learning ");
	blog.setCreateDate(new java.util.Date());
	blog.setLikes(0);
	blog.setDislikes(0);
	blog.setStatus("NA");
	blog.setUsername("akshaysr");
	
	assertTrue("Problem in Adding the Blog",blogDAO.addBlog(blog));
	
}
@Ignore
@Test
public void deleteBlog()
{
	Blog blog=blogDAO.getBlog(252);
	assertTrue("Problem in Deleting the Blog",blogDAO.deleteBlog(blog));
}
@Ignore
@Test
public void updateBlog()
{
	Blog blog=blogDAO.getBlog(52);
	blog.setBlogContent("Spoken English");

	assertTrue("Problem in Updating the Blog",blogDAO.updateBlog(blog));

}

@Test
public void listBlogTest()
{
	List<Blog>listBlogs=blogDAO.getAllBlogs();
	assertTrue("Problem in Listing the Blog",listBlogs.size()>0);
	for(Blog blog:listBlogs)
	{
		System.out.println(blog.getBlogId()+"\t");
		System.out.println(blog.getBlogName()+"\t");
		System.out.println(blog.getBlogContent()+"\t");
		System.out.println(blog.getStatus());
	}
}

	
	
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(152);
		assertTrue("Problem in Approving the Blog",blogDAO.approvedBlog(blog));
	}

	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(202);
		assertTrue("Problem in Rejecting the Blog",blogDAO.rejectBlog(blog));
		
	}

	@Test
	public void incrementLikesTest()
	{
		Blog blog=blogDAO.getBlog(152);
		assertTrue("Problem in Increment Likes",blogDAO.incrementLikes(blog));

	}
	
	@Test
	public void incrementDislikesTest()
	{
		Blog blog=blogDAO.getBlog(102);
		assertTrue("Problem in increment Dislikes",blogDAO.incrementDisLikes(blog));

	}
}


