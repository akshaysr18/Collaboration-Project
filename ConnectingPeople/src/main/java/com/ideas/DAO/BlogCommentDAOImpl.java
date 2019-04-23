package com.ideas.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO 
{

@Autowired
SessionFactory sessionFactory;
 

@Override
	public boolean addBlogComment(BlogComment blogComment) {
	try
	{
		sessionFactory.getCurrentSession().save(blogComment);
		return true;
	}
	catch(Exception e)
	{
	System.out.println("Exception as Arised: Adding the BlogComment"+e);
	return false;
	}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);;
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Deleting the BlogComment"+e);
		return false;
		}
	}

	

	

	@Override
	public List<BlogComment> listBlogComments(int blogId) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment Where blogId=:myBlogId");
		query.setParameter("myBlogId", blogId);
		List<BlogComment> listBlogComments=query.list();
		session.close();
		return listBlogComments;
		
	}

	@Override
	public BlogComment getBlogComment(int blogCommentId) {
		Session session=sessionFactory.openSession();
		BlogComment blogComment=session.get(BlogComment.class, blogCommentId);
		session.close();
		return blogComment;
	}

}
