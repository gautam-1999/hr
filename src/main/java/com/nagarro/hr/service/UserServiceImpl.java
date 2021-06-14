package com.nagarro.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.hr.model.User;
import com.nagarro.hr.dao.UserDao;
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public boolean isUserValid(String username, String password) {
		List<User> users = userDao.getAllUsers(username, password);
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
