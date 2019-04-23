package com.ideas.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.ForumComment;


@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Adding the ForumComment"+e);
		return false;
		}
	}

	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Deleting the ForumComment"+e);
		return false;
		}
	}

	@Override
	public List<ForumComment> listForumComments(int forumId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where froumId=:myForumId");
		query.setParameter("myForumId", forumId);
		List<ForumComment> listForumComments=query.list();
		session.close();
		return listForumComments;
	}

	@Override
	public ForumComment getForumComment(int forumCommentId) {
		Session session=sessionFactory.openSession();
		ForumComment forumComment=session.get(ForumComment.class, forumCommentId);
		session.close();
		return forumComment;
	}

}
