package com.ty.hospital.hospitalappboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.repository.BranchRepository;

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public Branch saveBranch(int hospitalId , Branch branch ) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		
		if(hospital != null) {
			branch.setHospital(hospital);
			branchRepository.save(branch);
			return branch;
		}
		return null;
	}
	public Branch getBranchById(int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public boolean deleteBranchById(int id) {
		Branch branch = getBranchById(id);
		if(branch != null) {
			branchRepository.delete(branch);
			return true;
		}
		return false;
	}
	public Branch updateBranchById(int id,Branch branch) {
		Branch branch1 = getBranchById(id);
		if(branch1 != null) {
			branchRepository.save(branch);
			return branch;
		}
		return null;
	}
	

}
