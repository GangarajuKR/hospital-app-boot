package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.repository.MedorderRepository;

@Repository
public class MedorderDao {
	@Autowired
	private MedorderRepository medorderRepository;
	
	@Autowired
	private EncounterDao encounterDao;
	
	public Medorder saveMedorder(int encounterId , Medorder medorder) {
		
		List<Item> items = medorder.getItems();
		
		if(items != null) {
			for(Item item : items) {
				item.setMedorder(medorder);
				
			}
		
		}
		Encounter encounter = encounterDao.getEncounterById(encounterId);
		if(encounter != null) {
			medorderRepository.save(medorder);
			return medorder;
		}
		return null;
	}
	public Medorder getMedorderById(int id) {
		Optional<Medorder> optional = medorderRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public Medorder updateMedorderById(int id) {
		Medorder medorder = getMedorderById(id);
		if(medorder != null) {
			medorderRepository.save(medorder);
			return medorder;
		}
		return null;
	}
	public boolean deleteMedorderById(int id) {
		Medorder medorder = getMedorderById(id);
		if(medorder != null) {
			medorderRepository.delete(medorder);
			return true;
		}
		return false;
	}
}
