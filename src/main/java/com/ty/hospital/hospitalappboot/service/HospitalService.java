package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalDao.saveHospital(hospital);
	}

	public Hospital updateHospitalById(int id, Hospital hospital) {
		return hospitalDao.updateHospital(id, hospital);
	}

	public Hospital getHospitalById(int id) {
		  Hospital hospital = hospitalDao.getHospitalById(id);
		  if(hospital==null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		  }
		  return hospital;
	}

	public List<Hospital> getAllHospital() {
		return hospitalDao.getAllHospital();

	}
	public void deleteHospitalById(int id) {
		hospitalDao.deleteHospitalById(id);
	}
}
