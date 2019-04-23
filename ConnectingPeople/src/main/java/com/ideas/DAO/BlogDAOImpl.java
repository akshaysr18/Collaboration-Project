package com.ideas.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addBlog(Blog blog) 
	{ 
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Adding the Blog"+e);
		return false;
		}
		
		
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Deleting the  Blog"+e);
		return false;
		}}

	@Override
	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Updating the  Blog"+e);
		return false;
		}
	}

	@Override
	public Blog getBlog(int blogId) 
	{
	Session session=sessionFactory.openSession();
	Blog blog=session.get(Blog.class, blogId);
	session.close();
	return blog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> listBlog=(List<Blog>)query.list();
		session.close();
		return listBlog;
		
		
	}

	@Override
	public boolean incrementLikes(Blog blog) {
		try
		{
		blog.setLikes(blog.getLikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Increment Like:"+e);
			return false;
		}
	}

	@Override
	public boolean incrementDisLikes(Blog blog)
	{
		try
		{
		blog.setDislikes(blog.getDislikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Increment DisLike:"+e);
			return false;
		}
	}

	@Override
	public boolean approvedBlog(Blog blog) {
		try
		{
		
		blog.setStatus("A");
		sessionFactory.getCurrentSession().update(blog);
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Approving the Blog:"+e );
	    return false;
	}	
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		
	
		try
		{
		
		blog.setStatus("NA");
		sessionFactory.getCurrentSession().update(blog);
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Rejecting the Blog:"+e );
	    return false;
	}
	}

}


