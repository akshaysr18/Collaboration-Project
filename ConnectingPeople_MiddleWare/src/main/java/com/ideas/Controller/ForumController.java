package com.ideas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.DAO.ForumDAO;
import com.ideas.model.Forum;

@RestController
public class ForumController
{

	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping(value="/getForum")
	public ResponseEntity<List<Forum>> getAllForums()
	{
		List<Forum> listForum=forumDAO.getAllForums();
		
		if(listForum.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/addForum")
	public ResponseEntity<?> addForum(@RequestBody Forum forum)
	{
		
		forum.setCreateDate(new java.util.Date());;
		
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/deleteforum/{forumId}")
	public ResponseEntity<?> deleteforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/updateforum")
	public ResponseEntity<?> updateforum(@RequestBody Forum forum)
	{
		if(forumDAO.updateForum(forum))
			
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value="/approveForum/{forumId}")
	public ResponseEntity<?> approveforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.approvedForum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/rejectForum/{forumId}")
	public ResponseEntity<?> rejectForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.rejectForum(forum))
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/getforum/{forumId}")
	public ResponseEntity<Forum> getforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forum!=null)
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}




