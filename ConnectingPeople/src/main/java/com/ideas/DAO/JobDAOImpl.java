package com.ideas.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Adding the Job"+e);
		return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Deleting the Job"+e);
		return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception as Arised: Updating the Job"+e);
		return false;
		}
	}

	@Override
	public Job getJob(int jobId) {
		Session session=sessionFactory.openSession();
		Job job=session.get(Job.class, jobId);
		session.close();
		return job;
	}

	@Override
	public List<Job> getJobDetail() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> listJob=(List<Job>)query.list();
		session.close();
		return listJob;
	}

}
