package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.UserDao;
import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	public User UpdateUserById(User user,int id) {
		return userDao.updateUser(user, id);
	}
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		if (user == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return user;
	}
	public List<User> getAllUser(){
		return userDao.getAllUser();
				
	}
	public void deleteUserById(int id) {
		 userDao.deleteUserById(id);
	}
	public User validateUser(User user) {
		return userDao.validateUser(user);
	}

}
