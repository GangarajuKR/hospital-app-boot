package com.ty.hospital.hospitalappboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repository.EncounterRepository;

@Repository
public class EncounterDao {
	
	@Autowired
	private EncounterRepository encounterRepository;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;
	
	public Encounter saveEncounter(int personId,int branchId,Encounter encounter) {
		Person person = personDao.getPersonById(personId);
		Branch branch = branchDao.getBranchById(branchId);
		
		if(person !=null && branch !=null) {
			encounter.setBranch(branch);
			encounter.setPerson(person);
			encounterRepository.save(encounter);
			return encounter;
		}
		return null;
		
	}
	public Encounter updateEncounterById(int id) {
		Encounter encounter = getEncounterById(id);
		if(encounter != null) {
			encounterRepository.save(encounter);
			return encounter;
		}
		return null;
	}
	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public boolean deleteEncounterById(int id) {
		Encounter encounter = getEncounterById(id);
		if(encounter != null) {
			encounterRepository.delete(encounter);
			return true;
		}
		return false;
	}
	

}
