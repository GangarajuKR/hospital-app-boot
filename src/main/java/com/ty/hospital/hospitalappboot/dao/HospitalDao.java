package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		
		List<Branch> branchs = hospital.getBranchs();
		if(branchs != null) {
			for(Branch branch : branchs) {
				branch.setHospital(hospital);
			}
		
		}
		return hospitalRepository.save(hospital);
	}
	
	public Hospital updateHospital(int id,Hospital hospital) {
		Hospital existingHospital = getHospitalById(id);
		if(existingHospital != null) {
			hospitalRepository.save(hospital);
			return hospital;
		}
		return null;
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<Hospital> getAllHospital() {
		return hospitalRepository.findAll();
	}

	public boolean deleteHospitalById(int id) {

		Hospital hospital = getHospitalById(id);
		if (hospital != null) {
			hospitalRepository.delete(hospital);
			return true;
		}
		return false;

	}

}
