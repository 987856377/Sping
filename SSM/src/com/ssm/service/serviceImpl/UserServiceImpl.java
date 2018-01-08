package com.ssm.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.getAllUser();
		return list;
	}

}
