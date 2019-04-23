package com.ideas.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.UserDetail;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception Arised: Adding User"+e);
			return false;
			
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);;
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception Arised: Updating User"+e);
			return false;
			
		}	}

	@Override
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class, username);
		session.close();
		return user;
		
	}

	@Override
	public boolean makeoffLine(UserDetail user) {
		try
		{
			user.setIsOnline("Of");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception Arised: Make off Line Like"+e);
			return false;
			
		}
	}

	@Override
	public boolean makeOnLine(UserDetail user) {
		try
		{
			user.setIsOnline("On");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception Arised: Make on Line Like"+e);
			return false;
			
		}
	}

	@Override
	public boolean approveUser(UserDetail user) {
		try
		{
		
		user.setStatus("A");;
		sessionFactory.getCurrentSession().update(user);
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Approving the User:"+e );
	    return false;
	}	
	}

	@Override
	public boolean rejectUser(UserDetail user) {
		try
		{
		
		user.setStatus("NA");
		sessionFactory.getCurrentSession().update(user);;
		return true;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised: Rejecting The User:"+e );
	    return false;
	}	

	}
}

