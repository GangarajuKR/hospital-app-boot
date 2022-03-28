package com.ty.hospital.hospitalappboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	@ApiOperation(value = "save item details" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Item saved"),
		@ApiResponse(code = 405, message = "Bad request, not proper item data")
	})
	@PostMapping("/medorder/{medorderid}/item")
	public Item saveItem(@PathVariable(name="medorderid")int medorderId, @RequestBody Item item) {
		return itemService.saveItem(medorderId, item);
		
	}
	
	
	@ApiOperation(value = "Get item" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/item")
	public Item getItemById(@RequestParam int id) {
		return itemService.getItemById(id);
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@GetMapping("/allitem")
	public List<Item> getAllItem(){
		return itemService.getAllItem();
				
	}
	
	@ApiOperation(value = "Delete the branch" , produces = "application/json" ,consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "deletes given branch data"),
		@ApiResponse(code = 404, message = "No given id found")
	})
	@DeleteMapping("/item")
	public void deleteItemById(@RequestParam  int id) {
		itemService.deleteItemById(id);
		
	}

}
