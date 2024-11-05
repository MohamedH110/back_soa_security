package com.example.demo_eleves.service;

import java.util.List;

import com.example.demo_eleves.dto.EleveDTO;
import com.example.demo_eleves.entities.Ecole;
import com.example.demo_eleves.entities.Eleve;

public interface EleveService {
	EleveDTO saveEleve(EleveDTO e);
	EleveDTO updateEleve(EleveDTO e);
	void deleteEleve(Eleve e);
	void deleteElevebyId(Long id);
	EleveDTO getEleve(Long id);

	 
	
	
	 List<EleveDTO> getAllEleves();
	 
	 List<Eleve> findByNomEleve(String nom);
	 List<Eleve> findByNomEleveContains(String nom);
	 List<Eleve> findByNomAge (String nom, int age);
	 List<Eleve> findByEcole (Ecole ecole);
	 List<Eleve> findByEcoleId(Long id);
	 List<Eleve> findByOrderByNomEleveAsc();
	 List<Eleve> trierEleveNomAge();
	 
	 
	 EleveDTO convertEntityToDto(Eleve e);
	 Eleve convertDtoToEntity(EleveDTO  eleveDTO);

	

}
