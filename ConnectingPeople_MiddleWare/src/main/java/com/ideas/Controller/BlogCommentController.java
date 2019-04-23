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

import com.ideas.DAO.BlogCommentDAO;
import com.ideas.model.Blog;
import com.ideas.model.BlogComment;


@RestController
public class BlogCommentController 
{
	
	@Autowired
	BlogCommentDAO blogCommentDAO;

	@PostMapping("/addBlogComment")
	public ResponseEntity<?> addBlogComment(@RequestBody BlogComment blogComment)
	{
		blogComment.setCommentDate(new java.util.Date());
		if(blogCommentDAO.addBlogComment(blogComment))
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogId")int blogId)
	{
		List<BlogComment> listBlogComments=blogCommentDAO.listBlogComments(blogId);
		
		if(listBlogComments.size()>0)
		{
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);		}
	}
	@GetMapping(value="/deleteblogComment/{blogCommentId}")
	public ResponseEntity<String> deleteblog(@PathVariable("blogCommentId") int blogCommentId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(blogCommentId);
		
		if(blogCommentDAO.deleteBlogComment(blogComment))
		{
			return new ResponseEntity<String>("successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/getBlogComment/{commentId}")
	public ResponseEntity<BlogComment> getblogComment(@PathVariable("commentId") int commentId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
		if(blogComment!=null)
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}

