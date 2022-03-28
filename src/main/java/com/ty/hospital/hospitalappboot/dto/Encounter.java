package com.ty.hospital.hospitalappboot.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@UpdateTimestamp
	private LocalDate dateOfAdmit;
	private String reason;
	private double cost;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@OneToMany(mappedBy = "encounter")
	private List<Medorder> medorders;
	
	
	
	public List<Medorder> getMedorders() {
		return medorders;
	}

	public void setMedorders(List<Medorder> medorders) {
		this.medorders = medorders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfAdmit() {
		return dateOfAdmit;
	}

	public void setDateOfAdmit(LocalDate dateOfAdmit) {
		this.dateOfAdmit = dateOfAdmit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	@JsonIgnore
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	

}
