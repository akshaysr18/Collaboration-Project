package com.ideas.DAO;

import java.util.List;

import com.ideas.model.Forum;

public interface ForumDAO 
{

	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getAllForums();
	public boolean approvedForum(Forum forum);
	public boolean rejectForum(Forum forum);
}
