package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User updateUser(User user,int id) {
		User existingUser = getUserById(id);
		if(existingUser != null) {
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public boolean deleteUserById(int id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;

	}
	public User validateUser(User user) {
		return userRepository.validateUser(user.getEmail(),user.getPassword());
	}

}
