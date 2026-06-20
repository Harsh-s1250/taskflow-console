package com.taskflow.dao;

import com.taskflow.model.User;

public interface UserDAO {
	
	boolean register(User user);
	
	User login(String email, String Password);
	
}
