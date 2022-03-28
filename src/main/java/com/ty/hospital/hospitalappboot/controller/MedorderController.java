package com.ty.hospital.hospitalappboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.service.MedorderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedorderController {
	
	@Autowired
	private MedorderService medorderService;
	
	
	@ApiOperation(value = "save branch details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper branch data")
	})
	@PostMapping("/encounter/{encounterid}/medorder")
	public Medorder saveMedorder(@PathVariable (name = "encounterid") int id, @RequestBody Medorder medorder) {
		return medorderService.saveMedorder(id, medorder);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/medorder")
	public Medorder getMedorderById(@RequestParam int id) {
		return medorderService.getMedorderById(id);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@PutMapping("/medorder")
	public Medorder updateMedorderById(@RequestParam int id) {
		return medorderService.updateMedorderById(id);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/medorder")
	public void deleteMedorderById(@RequestParam int id) {
		 medorderService.deleteMedorderById(id);
	}
}
