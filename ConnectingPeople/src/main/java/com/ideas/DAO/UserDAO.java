package com.ideas.DAO;

import com.ideas.model.UserDetail;

public interface UserDAO 
{
public boolean registerUser(UserDetail user);
public boolean updateUserDetail(UserDetail user);
public UserDetail getUser(String username);
public boolean makeoffLine(UserDetail user);
public boolean makeOnLine(UserDetail user);
public boolean approveUser(UserDetail user);
public boolean rejectUser(UserDetail user);

}
