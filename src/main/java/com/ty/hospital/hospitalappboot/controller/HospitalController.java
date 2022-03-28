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

import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.service.HospitalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	
	@ApiOperation(value = "save hospital details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Hospital saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper hospital data")
	})
	@PostMapping("/hospital")
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@ApiOperation(value = "Update hospital details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "updates given hospital data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@PutMapping("/hospital")
	public Hospital updateHospital(@RequestBody Hospital hospital,@RequestParam int id) {
		return hospitalService.updateHospitalById(id, hospital);
		
	}
	
	@ApiOperation(value = "Get the hospital details" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "gets given hospital data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/hospital")
	public Hospital getHospitalById(@RequestParam int id) {
		return hospitalService.getHospitalById(id);
	}
	
	@ApiOperation(value = "Get all hospital details")
	@ApiResponses({
		@ApiResponse(code = 200,message = "gets all hospital data"),
		@ApiResponse(code = 405, message = "Bad request")
	})
	@GetMapping("/allhospital")
	public List<Hospital> getAllHospital(){
		return hospitalService.getAllHospital();
	}
	
	@ApiOperation(value = "Delete the hospital" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given hospital data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/hospital")
	public void deleteHospitalById(@RequestParam int id) {
		hospitalService.deleteHospitalById(id);
	}

}
