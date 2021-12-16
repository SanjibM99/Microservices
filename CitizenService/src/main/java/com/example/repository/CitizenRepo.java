package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen,Integer>{

	public List<Citizen> findByVaccinationCenterId(Integer id);
}
