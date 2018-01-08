package com.ssm.service;

import java.util.List;

import com.ssm.model.User;

public interface UserService {
	public User getUserById(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> getAllUser();
}
