package com.ideas.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ideas.DAO.JobDAO;
import com.ideas.model.Job;

public class JobTesting {
	
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initailize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ideas");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}


	@Test
	public void addJobTest() 
	{
		Job job=new Job();
		job.setDesgination("Developer");
		job.setJobDesc("Java");
		job.setQualification(" Any Degree, ");
		job.setStatus("A");
		job.setLastDate(new java.util.Date());
		
		assertTrue("Problem in Adding:",jobDAO.addJob(job));
		
	}
	@Ignore
	@Test
	public void deleteJobTest()
	{
		Job job=jobDAO.getJob(102);
		assertTrue("Problem in Deleting:",jobDAO.deleteJob(job));

	}
	@Ignore
	@Test
	public void updateJobTest()
	{
	Job job=jobDAO.getJob(52);
	job.setJobDesc("Financial Analyst ");
	job.setDesgination("Analyst");
	job.setQualification("MBA");
	assertTrue("Problem in Updating:",jobDAO.updateJob(job));

	}
	

	@Ignore
	@Test
	public void listJobTest()
	{
		List<Job>listJob=jobDAO.getJobDetail();
		assertTrue("Problem in Listing the Blog",listJob.size()>0);
		for(Job job:listJob)
		{
			System.out.println(job.getDesgination()+"\t");
			System.out.println(job.getJobDesc()+"\t");
			System.out.println(job.getQualification()+"\t");
			System.out.println(job.getStatus()+"\t");
		}
	}
}
