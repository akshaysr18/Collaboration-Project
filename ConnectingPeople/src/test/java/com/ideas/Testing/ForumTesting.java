package com.ideas.Testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.ForumDAO;
import com.ideas.model.Forum;


public class ForumTesting {
	static ForumDAO forumDAO;

	@BeforeClass
	public static void initailize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ideas");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	
  
	
	@Test
	public void addForumTest() 
	{
		Forum forum=new Forum();
		forum.setForumName("Code Learning");
		forum.setForumContent(" C++,Python,");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("A");
		forum.setUserName("aki");
		
		assertTrue("Problem in Adding:",forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(1);
		assertTrue("Problem in Adding:",forumDAO.addForum(forum));
	}
	
@Ignore
@Test
public void updateForumTest()
{
	Forum forum=forumDAO.getForum(1);
	forum.setForumName("About JAVA");
	forum.setForumContent("Its is Progarmming Lanugae");
	assertTrue("Problem in Updating:",forumDAO.updateForum(forum));

}

@Test
public void approveForumTest()
{
	Forum forum=forumDAO.getForum(1);
	assertTrue("Problem in Approving the Forum",forumDAO.approvedForum(forum));
}
@Ignore
@Test
public void rejectForumTest()
{
	Forum forum=forumDAO.getForum(1);
	assertTrue("Problem in Rejectng the Forum",forumDAO.rejectForum(forum));
}

}
