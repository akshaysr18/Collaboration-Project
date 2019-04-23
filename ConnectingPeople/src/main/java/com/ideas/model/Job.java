package com.ideas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="jobidseq",sequenceName="myjobseq")

public class Job 
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")

 int JobId;
 String Desgination;
 String JobDesc;
 String Qualification;
 String status;
 @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
 Date LastDate;
public int getJobId() {
	return JobId;
}
public void setJobId(int jobId) {
	JobId = jobId;
}
public String getDesgination() {
	return Desgination;
}
public void setDesgination(String desgination) {
	Desgination = desgination;
}
public String getJobDesc() {
	return JobDesc;
}
public void setJobDesc(String jobDesc) {
	JobDesc = jobDesc;
}
public String getQualification() {
	return Qualification;
}
public void setQualification(String qualification) {
	Qualification = qualification;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getLastDate() {
	return LastDate;
}
public void setLastDate(Date lastDate) {
	LastDate = lastDate;
}
}
