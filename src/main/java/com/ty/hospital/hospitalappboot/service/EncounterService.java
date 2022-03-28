package com.ty.hospital.hospitalappboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.ty.hospital.hospitalappboot.dao.EncounterDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class EncounterService {
	
	@Autowired
	private EncounterDao encounterDao;
	
	public Encounter saveEncounter(int id,int bid,Encounter encounter) {
		return encounterDao.saveEncounter(id, bid, encounter);
	}
	public Encounter getEncounterById(int id) {
		Encounter encounter = encounterDao.getEncounterById(id);
		if (encounter == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return encounter;
	}
	public Encounter updateEncounterById(int id) {
		return encounterDao.updateEncounterById(id);
	}
	public void deleteEncounterById(int id) {
		encounterDao.deleteEncounterById(id);
	}

}
