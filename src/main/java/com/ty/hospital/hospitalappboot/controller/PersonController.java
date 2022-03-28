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

import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	
	@ApiOperation(value = "save branch details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper branch data")
	})
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {

		return personService.savePerson(person);

	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person,@RequestParam int id) {
		return personService.updatePerson(id, person);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/person")
	public Person getPersonById(@RequestParam int id) {
		return personService.getPersonById(id);
		
	}
	
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/allperson")
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
				
	}
	
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/person")
	public void deleteById(@RequestParam int id) {
		personService.deletePersonById(id);
	}
	

}
