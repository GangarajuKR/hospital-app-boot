package com.ty.hospital.hospitalappboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class BranchService {
	
	@Autowired
	private BranchDao branchDao;
	
	public Branch saveBranch(int id, Branch branch) {
		return branchDao.saveBranch(id, branch);
	}
	public Branch getBranchById(int id) {
		Branch branch = branchDao.getBranchById(id);
		if (branch == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return branch;
	}
	public Branch updateBranchById(int id,Branch branch) {
		return branchDao.updateBranchById(id, branch);
	}
	public void deleteBranchById(int id) {
		branchDao.deleteBranchById(id);
	}

}
