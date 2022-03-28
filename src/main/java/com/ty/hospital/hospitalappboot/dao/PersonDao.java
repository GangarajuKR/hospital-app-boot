package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);

	}
	public Person updatePerson(int id,Person person) {
		Person existingPerson = getPersonById(id);
		if(existingPerson !=null) {
			personRepository.save(person);
			return person;
		}
		return null;
	}

	public Person getPersonById(int id) {
		Optional<Person> opt = personRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	public boolean deletePersonById(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			personRepository.delete(person);
			return true;
		}
		return false;

	}

}
