package com.nagarro.hr.dao;

import java.util.List;

import com.nagarro.hr.model.User;

public interface UserDao {

	public List<User> getAllUsers(String username, String password);
}
