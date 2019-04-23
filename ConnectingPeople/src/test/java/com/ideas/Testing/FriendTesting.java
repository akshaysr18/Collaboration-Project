package com.ideas.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.FriendDAO;
import com.ideas.model.Friend;
import com.ideas.model.UserDetail;

public class FriendTesting {
	
	static FriendDAO friendDAO;
	

	@BeforeClass
	public static void initailize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ideas");
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	

	
	@Test
	public void sendFriendrequest()
	{
		Friend friend=new Friend();
		
		friend.setUsername("ray");
		friend.setFriendname("adi");
		
		assertTrue("problem in Sending Friend Request",friendDAO.sendFriendRequest(friend));
	}
	
	@Ignore
	@Test
	public void acceptfriendrequest()
	{
		assertTrue("problem in accepting friend",friendDAO.acceptFriendRequest(2152));
	}
	
	@Ignore
	@Test
	public void deletefriendrequest()
	{
		assertTrue("problem in deleting friend",friendDAO.deleteFriendRequest(111));
	}
	
	@Ignore
	@Test
	public void showFriendListTest() 
	{
	
		List<Friend>friendList=friendDAO.showFriendList("akshaysr");
		assertTrue("Problem in Showing Friend List",friendList.size()>0);
		
		for(Friend friend:friendList)
		{
			System.out.print(friend.getUsername()+"           ");
			System.out.println(friend.getFriendname());

			
		}
		
	}
	
	@Ignore
	@Test
	public void showPendingFriendRequest()

	{
		List<Friend>friendList=friendDAO.showPendingFriendList("akshaysr");
		assertTrue("Problem in Showing Friend List",friendList.size()>0);

		System.out.println("==============Displaying Pending Friend Request List===================");
		for(Friend friend:friendList)
		{
			System.out.print(friend.getUsername()+"           ");
			System.out.println(friend.getFriendname());
		}

	}
	
	@Test
	public void showSuggestedFriend()
	{
		List<UserDetail> listsuggestedfriends=friendDAO.showSuggestedFriend("Adithya");
		assertTrue("problem in listing Friends",listsuggestedfriends.size()>0);
		System.out.println("*****Displaying Suggested Friend List*****");
		 for(UserDetail user:listsuggestedfriends)
		 {
			 System.out.print(user.getUsername()+"                 ");
				System.out.println(user.getCustomerName());
		 }
	}
	}
