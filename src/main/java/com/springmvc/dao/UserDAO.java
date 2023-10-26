package com.springmvc.dao;

import com.springmvc.model.User;

public interface UserDAO {
	public User findByUserName(String userName);
}
