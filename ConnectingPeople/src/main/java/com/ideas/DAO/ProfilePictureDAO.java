package com.ideas.DAO;

import com.ideas.model.ProfilePicture;

public interface ProfilePictureDAO 
{

	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
