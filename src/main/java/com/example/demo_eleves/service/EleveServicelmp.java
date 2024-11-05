package com.example.demo_eleves.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_eleves.dto.EleveDTO;
import com.example.demo_eleves.entities.Ecole;
import com.example.demo_eleves.entities.Eleve;
import com.example.demo_eleves.repos.eleverepos;

@Service
public class EleveServicelmp implements EleveService{
	
	@Autowired
	eleverepos EleveRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public EleveDTO saveEleve(EleveDTO e) {
		return convertEntityToDto(EleveRepository.save(convertDtoToEntity(e)));
		
	}

	@Override
	public EleveDTO updateEleve(EleveDTO e) {
		return convertEntityToDto(EleveRepository.save(convertDtoToEntity(e)));
	}

	@Override
	public void deleteEleve(Eleve e) {
		 EleveRepository.delete(e);
		
	}

	@Override
	public void deleteElevebyId(Long id) {
		 EleveRepository.deleteById(id);
	}

	@Override
	public EleveDTO getEleve(Long id) {
		return convertEntityToDto(EleveRepository.findById(id).get());
	}

	@Override
	public List<EleveDTO> getAllEleves() {
		/*return EleveRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());*/
		
    List<Eleve> eleves = EleveRepository.findAll();
	List<EleveDTO> listeleveDto = new ArrayList<>(eleves.size());
	
		for (Eleve e : eleves)
			listeleveDto.add(convertEntityToDto(e));
		
		return listeleveDto;

	}

	@Override
	public List<Eleve> findByNomEleve(String nom) {
		return EleveRepository.findByNom(nom);
	}

	@Override
	public List<Eleve> findByNomEleveContains(String nom) {
		// TODO Auto-generated method stub
		return  EleveRepository.findByNomContains(nom);
	}

	@Override
	public List<Eleve> findByNomAge(String nom, int age) {
		
		return  EleveRepository.findByNomAge(nom,age);
	}

	@Override
	public List<Eleve> findByEcole(Ecole ecole) {
	
		return  EleveRepository.findByEcole(ecole);
	}

	@Override
	public List<Eleve> findByEcoleId(Long id) {
		return  EleveRepository.findByEcoleId(id);
		}

	@Override
	public List<Eleve> findByOrderByNomEleveAsc() {
		return  EleveRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Eleve> trierEleveNomAge() {
		
		return EleveRepository.trierEleveNomAge();
	}

	
	@Override
	public EleveDTO convertEntityToDto(Eleve e) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		EleveDTO eleveDTO=  modelMapper.map(e, EleveDTO.class);
		return eleveDTO;
		/*return 	EleveDTO.builder()
				.id(e.getId())
				.nom(e.getNom())
				.age(e.getAge())
				.ecole(e.getEcole())
				//.nomEcole(e.getEcole().getNom())
				.build();*/
	
		
	}

	@Override
	public Eleve convertDtoToEntity(EleveDTO eleveDTO) {
		Eleve eleve = new Eleve();
		eleve = modelMapper.map(eleveDTO,Eleve.class);
		   return eleve;
		
	
		
		/*Eleve eleve = new Eleve();
		
		eleve.setId(eleveDTO.getId());
		eleve.setNom(eleveDTO.getNom());
		eleve.setAge(eleveDTO.getAge());
		eleve.setEcole(eleveDTO.getEcole());
	
		return eleve;
	}*/

}
}