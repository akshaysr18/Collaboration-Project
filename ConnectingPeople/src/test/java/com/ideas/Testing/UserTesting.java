package com.ideas.Testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.BlogDAO;
import com.ideas.DAO.UserDAO;
import com.ideas.model.UserDetail;

public class UserTesting {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ideas");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
		
	}

	@Ignore
	@Test
	public void registerUserTest() {
		
		UserDetail user=new UserDetail();
		
		
		user.setCustomerName("Akshay Surjith");
		user.setUsername("akshaysr");
		user.setPassword("1234");
		user.setEmailId("adi@gmail.com");
		user.setIsOnline("On");
		user.setRole("Student");
		user.setStatus("A");
		
		assertTrue("Problem in User Registering:",userDAO.registerUser(user));
	}

	@Ignore
	@Test
	public void updateUserDetail()
	{
		UserDetail user=userDAO.getUser("akshaysr");
		user.setEmailId("akshaysr@gmail.com");
		assertTrue("Problem in User Updating:",userDAO.updateUserDetail(user));
		
	}
	@Ignore
	@Test
	public void makeoffLineTest()
	{
		UserDetail user=userDAO.getUser("akshaysr");
		assertTrue("Problem in OffLine:",userDAO.makeoffLine(user));
	}
	@Ignore
	@Test
	public void makeonLineTest()
	{
		UserDetail user=userDAO.getUser("akshaysr");
		assertTrue("Problem in Online:",userDAO.makeOnLine(user));	
	}
	@Ignore
	@Test
	public void rejectUserTest()
	{
		UserDetail user=userDAO.getUser("akshaysr");
		assertTrue("Problem in Rejecting the User:",userDAO.rejectUser(user));
	}
	
	@Test
	public void approveUserTest()
	{
		UserDetail user=userDAO.getUser("akshaysr");
		assertTrue("Problem in Approving the User:",userDAO.approveUser(user));
	}
	
}

