package com.ideas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.DAO.FriendDAO;
import com.ideas.model.Friend;
import com.ideas.model.UserDetail;

@RestController
public class FriendController 
{

	@Autowired
	FriendDAO friendDAO;
	
	@GetMapping(value="/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username")String username)
	{
		List<Friend>friendList=friendDAO.showFriendList(username);
		if(friendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/showPendingFriendList/{username}")
	public ResponseEntity<List<Friend>> pendingfriendrequest(@PathVariable("username") String username)
	{
		List<Friend> pendingfriends=friendDAO.showPendingFriendList(username);
		if(pendingfriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(pendingfriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(pendingfriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/showSuggestedFriend/{username}")
	public ResponseEntity<List<UserDetail>> showSuggestedFriend(@PathVariable("username") String username)
	{
		List<UserDetail> suggestedfriends=friendDAO.showSuggestedFriend(username);
		if(suggestedfriends.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(suggestedfriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(suggestedfriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest (@PathVariable("friendId")int friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId)) {
			
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest (@PathVariable("friendId")int friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId)) {
			
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

