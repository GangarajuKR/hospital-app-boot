package com.ty.hospital.hospitalappboot.service;

import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.MedorderDao;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class MedorderService {
	
	private MedorderDao medorderDao;
	
	public Medorder saveMedorder(int id,Medorder medorder) {
		return medorderDao.saveMedorder(id, medorder);
	}
	public Medorder getMedorderById(int id) {
		Medorder medorder = medorderDao.getMedorderById(id);
		if (medorder == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return medorder;
	}
	public Medorder updateMedorderById(int id) {
		return medorderDao.updateMedorderById(id);
	}
	public void deleteMedorderById(int id) {
		medorderDao.deleteMedorderById(id);
	}

}
