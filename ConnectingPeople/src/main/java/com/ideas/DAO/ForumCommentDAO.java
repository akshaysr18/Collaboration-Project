package com.ideas.DAO;

import java.util.List;

import com.ideas.model.ForumComment;


public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public List<ForumComment> listForumComments(int forumId);
	public ForumComment getForumComment(int forumCommentId);
}
