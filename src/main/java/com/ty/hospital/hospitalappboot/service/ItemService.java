package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.ItemDao;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public Item saveItem(int id,Item item) {
		return itemDao.saveItem(id, item);
	}
	public Item getItemById(int id) {
		 Item item = itemDao.getItemById(id);
		 if (item == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return item;
	}
	public List<Item> getAllItem(){
		return itemDao.getAllItem();
	}
	public void deleteItemById(int id) {
		itemDao.deleteItemById(id);
	}

}
