package com.ideas.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.ForumCommentDAO;
import com.ideas.model.ForumComment;

public class FroumCommentTesting {
	static ForumCommentDAO forumCommentDAO;

	@BeforeClass
	public static void initailize()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ideas");
	context.refresh();
	
	forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
}

	@Ignore
	@Test
	public void addForumCommentTest() {
		ForumComment forumComment=new ForumComment();
		forumComment.setCommentText("Excellent");
		forumComment.setCommentDate(new java.util.Date());
		forumComment.setForumId(952);
		forumComment.setUsername("aki");
		
		assertTrue("Problem in Adding:",forumCommentDAO.addForumComment(forumComment));
	}

	@Ignore
	@Test
	public void deleteForumCommentTest()
	{
		ForumComment forumComment=forumCommentDAO.getForumComment(0);
		assertTrue("Problem in Deleting",forumCommentDAO.deleteForumComment(forumComment));
	}
	

	
	@Test
	public void listForumComments()
	{
		List<ForumComment> listForumComments=forumCommentDAO.listForumComments(52);
		assertTrue("problem in listing",listForumComments.size()>0);
		for(ForumComment forumComment:listForumComments)
		{
			System.out.print(forumComment.getForumId()+"\t");
			System.out.print(forumComment.getCommentText()+"\t");
			System.out.print(forumComment.getUsername()+"\t");
			System.out.print(forumComment.getCommentDate()+"\t");
		}
	}
}
