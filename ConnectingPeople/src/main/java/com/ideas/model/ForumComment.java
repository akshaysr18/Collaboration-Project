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
@SequenceGenerator(name="forumCommentidseq",sequenceName="myforumCommentseq")

public class ForumComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumCommentidseq")


	int forumCommentId;
	int forumId;
	String commentText;
	String username;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
	Date commentDate;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}