package com.ideas.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.DAO.UserDAO;
import com.ideas.model.UserDetail;

@RestController
public class UserController 
{

	@Autowired
	UserDAO userDAO;

	@PostMapping(value="/registeruser")
	public ResponseEntity<?> registeruser(@RequestBody UserDetail user)
	{
		if(userDAO.registerUser(user))
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/approveuser/{username}")
	public ResponseEntity<?> approveuser(@PathVariable("username") String username)
	{
		UserDetail user=userDAO.getUser(username);
		
		if(userDAO.approveUser(user))
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/rejectuser/{username}")
	public ResponseEntity<?> rejectuser(@PathVariable("username") String username)
	{
		UserDetail user=userDAO.getUser(username);
		
		if(userDAO.rejectUser(user))
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value="/updateuser")
	public ResponseEntity<?> updateuser(@RequestBody UserDetail user)
	{
		if(userDAO.updateUserDetail(user))
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
	@PostMapping(value="/checklogin")
	public ResponseEntity<UserDetail> checklogin(@RequestBody UserDetail user,HttpSession session)
	{
		UserDetail tempuser=userDAO.getUser(user.getUsername());
		if(tempuser!=null)
		{
			if(tempuser.getPassword().equals(user.getPassword()) && tempuser.getStatus().equals("A"))
			    {
				
				session.setAttribute("UserDetail", tempuser);
					return new ResponseEntity<UserDetail>(tempuser,HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<UserDetail>(tempuser,HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		else
		{
			return new ResponseEntity<UserDetail>(tempuser,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}