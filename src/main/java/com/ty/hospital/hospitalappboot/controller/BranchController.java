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

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@ApiOperation(value = "save branch details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper branch data")
	})
	@PostMapping("/hospital/{hospitalid}/branch")
	public Branch saveBranch(@PathVariable(name = "hospitalid") int id, @RequestBody Branch branch) {
		return branchService.saveBranch(id, branch);
	}
	
	@ApiOperation(value = "Get the branch details" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Gets given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/branch")
	public Branch getBranchById(@RequestParam int id) {
		return branchService.getBranchById(id);
	}
	
	
	@ApiOperation(value = "update branch details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Branch updatet"),
		@ApiResponse(code = 405, message = "Bad request, not proper branch data")
	})
	@PutMapping("/branch")
	public Branch updateBranchById(@RequestParam int id,@RequestBody Branch branch) {
		return branchService.updateBranchById(id,branch);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/branch")
	public void deleteBranchById(@RequestParam int id) {
		 branchService.deleteBranchById(id);
	}
	

}
