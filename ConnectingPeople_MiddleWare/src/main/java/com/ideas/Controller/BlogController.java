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

import com.ideas.DAO.BlogDAO;
import com.ideas.model.Blog;

@RestController
public class BlogController 
{

	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping(value="/getBlogDetails")
	public ResponseEntity<List<Blog>> getBlogDetails()
	{
		List<Blog> listBlogs=blogDAO.getAllBlogs();
		
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

@PostMapping(value="/addblog")
public ResponseEntity<?> addblog(@RequestBody Blog blog)
{
	blog.setCreateDate(new java.util.Date());
	
	if(blogDAO.addBlog(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping(value="/deleteblog/{blogId}")
public ResponseEntity<?> deleteblog(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.deleteBlog(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping(value="/updateblog")
public ResponseEntity<?> updateBlog(@RequestBody Blog blog)
{
	if(blogDAO.updateBlog(blog))
		
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
@GetMapping(value="/incrementlikes/{blogId}")
public ResponseEntity<?> incrementlikes(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.incrementLikes(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping(value="/incrementdislikes/{blogId}")
public ResponseEntity<?> incrementdislikes(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.incrementDisLikes(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping(value="/approveblog/{blogId}")
public ResponseEntity<?> approveblog(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.approvedBlog(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@GetMapping(value="/rejectblog/{blogId}")
public ResponseEntity<?> rejectblog(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.rejectBlog(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Successful",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping(value="/getblog/{blogId}")
public ResponseEntity<Blog> getblog(@PathVariable("blogId") int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blog!=null)
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}


