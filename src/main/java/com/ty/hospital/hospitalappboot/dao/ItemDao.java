package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.repository.ItemRepository;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private MedorderDao medorderDao;
	
	public Item saveItem(int medorderId, Item item) {
		Medorder medorder = medorderDao.getMedorderById(medorderId);
		
		if(medorder != null) {
			item.setMedorder(medorder);
			itemRepository.save(item);
			return item;
		}
		return null;
	}
	public Item getItemById(int id) {
		Optional<Item> optional = itemRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public List<Item> getAllItem(){
		List<Item> items = itemRepository.findAll();
		return items;
	}
	public boolean deleteItemById(int id) {
		Item item = getItemById(id);
		if(item != null) {
			itemRepository.delete(item);
			return true;
		}
		return false;
	}
	

	
}
