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

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService encounterService;
	
	
	@ApiOperation(value = "save encounter details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Encounter saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper encounter data")
	})
	@PostMapping("/person/{personid}/branch/{branchid}/encounter")
	public Encounter saveEncounter(@PathVariable (name="personid") int id, @PathVariable (name = "branchid") int bid,@RequestBody Encounter encounter) {
		return encounterService.saveEncounter(id, bid, encounter);
	}
	
	@ApiOperation(value = "Get encounter details" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "gets given encounter data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/encounter")
	public Encounter getEncounterById(@RequestParam int id) {
		return encounterService.getEncounterById(id);
	}
	
	@ApiOperation(value = "Update the encounter" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "updated the given encounter data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@PutMapping("/encounter")
	public Encounter updateEncounterById(@RequestParam int id) {
		return encounterService.updateEncounterById(id);
	}
	
	@ApiOperation(value = "Delete the encounter" , produces = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given encounter data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/encounter")
	public void deleteEncounterById(@RequestParam int id) {
		encounterService.deleteEncounterById(id);
	}

}
