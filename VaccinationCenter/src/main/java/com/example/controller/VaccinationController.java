package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.VaccinationCenter;
import com.example.model.Citizen;
import com.example.model.RequiredResponse;
import com.example.repos.CenterRepo;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {

	@Autowired
	private CenterRepo centerrepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path="/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationcenter){
		VaccinationCenter vcadded=centerrepo.save(vaccinationcenter);
		return new ResponseEntity<>(vcadded,HttpStatus.OK);
				
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDadaBasedonCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse =  new RequiredResponse();
		//1st get vaccination center detail
		VaccinationCenter center  = centerrepo.findById(id).get();
		requiredResponse.setCenter(center);
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
	
}
