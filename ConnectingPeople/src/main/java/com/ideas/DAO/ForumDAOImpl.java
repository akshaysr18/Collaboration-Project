package com.ideas.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.Forum;


@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Adding the Forum"+e);
		return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Deleting the Forum"+e);
		return false;
		}
		
	}

	@Override
	public boolean updateForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Updating the Forum"+e);
		return false;
		}
	}

	@Override
	public Forum getForum(int forumId) {
		Session session=sessionFactory.openSession();
		Forum forum=session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Override
	public List<Forum> getAllForums() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> listForum=(List<Forum>)query.list();
		session.close();
		return listForum;
	}

	@Override
	public boolean approvedForum(Forum forum) {
		try
		{
		
		forum.setStatus("A");
		sessionFactory.getCurrentSession().update(forum);
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Approving the Forum:"+e );
	    return false;
	}
	}

	@Override
	public boolean rejectForum(Forum forum) {
		try
		{
		
		forum.setStatus("NA");
		sessionFactory.getCurrentSession().update(forum);
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Rejecting the Forum:"+e );
	    return false;
	}
	}

}
