package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public Person savePerson(Person person) {
		return personDao.savePerson(person);
	}
	public Person updatePerson(int id, Person person) {
		return personDao.updatePerson(id, person);
	}
	public Person getPersonById(int id) {
		Person person = personDao.getPersonById(id);
		if (person == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return person;
	}
	public List<Person> getAllPerson(){
		return personDao.getAllPerson();
				
	}
	public void deletePersonById(int id) {
		personDao.deletePersonById(id);
	}

}
