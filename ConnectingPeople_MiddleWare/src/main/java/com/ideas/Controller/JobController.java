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

import com.ideas.DAO.JobDAO;
import com.ideas.model.Job;

@RestController
public class JobController 
{

	@Autowired
	JobDAO jobDAO;
	
	@PostMapping(value="/addjob")
	public ResponseEntity<?> addjob(@RequestBody Job job)
	{
		job.setLastDate(new java.util.Date());
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updatejob")
	public ResponseEntity<?> updatejob(@RequestBody Job job)
	{
		if(jobDAO.updateJob(job))
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deletejob/{JobId}")
	public ResponseEntity<?> deletejob(@PathVariable("JobId") int jobId)
	{
		Job job= jobDAO.getJob(jobId);
		if(jobDAO.deleteJob(job))
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getjob/{JobId}")
	public ResponseEntity<Job> getjob(@PathVariable("JobId") int JobId)
	{
		Job job=jobDAO.getJob(JobId);
		
		if(job!=null)
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/listjobs")
	public ResponseEntity<List<Job>> listjobs()
	{
		List<Job> listjobs=jobDAO.getJobDetail();
		
		if(listjobs.size()>0)
		{
			return new ResponseEntity<List<Job>>(listjobs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listjobs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}


