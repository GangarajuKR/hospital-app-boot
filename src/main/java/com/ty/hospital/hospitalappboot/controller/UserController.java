package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ApiOperation(value = "save user details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "User saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper user data")
	})
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@ApiOperation(value = "Update tehe user" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "updated the user data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@PutMapping("/user")
	public User updateUser(@RequestBody User user,@RequestParam int id) {
		return userService.UpdateUserById(user, id);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/user")
	public User getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/alluser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/user")
	public void deleteUserById(@RequestParam int id) {
		userService.deleteUserById(id);
	}
	@PostMapping("/user/login")
	public User validateUser(@RequestBody User user) {
		return userService.validateUser(user);
	}

}
