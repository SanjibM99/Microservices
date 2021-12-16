package com.example.model;

import java.util.List;

import com.example.entity.VaccinationCenter;

public class RequiredResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
	
	
	
	public RequiredResponse(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}
	public RequiredResponse() {
		// TODO Auto-generated constructor stub
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	
}
