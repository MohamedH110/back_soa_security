package com.example.demo_eleves.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_eleves.dto.EleveDTO;
import com.example.demo_eleves.entities.Eleve;
import com.example.demo_eleves.service.EleveService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class eleveRestController {

	@Autowired
	EleveService eleveService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<EleveDTO> getAllProduits() {
		return eleveService.getAllEleves();
	 } 	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public EleveDTO getEleveById(@PathVariable("id") Long id) {	
		return eleveService.getEleve(id);
    }
	
	@RequestMapping(value="/addeleve",method = RequestMethod.POST)
	public EleveDTO createEleve(@RequestBody EleveDTO eleve) {
		return eleveService.saveEleve(eleve);
	}

	@RequestMapping(value="/updeleve",method = RequestMethod.PUT)
	public EleveDTO updateEleve(@RequestBody EleveDTO eleve) {
		return eleveService.updateEleve(eleve);
	}

	@RequestMapping(value="/deleleve/{id}",method = RequestMethod.DELETE)
	public void deleteEleve(@PathVariable("id") Long id)
	{
		eleveService.deleteElevebyId(id);
	}
	
	@RequestMapping(value="/eleveco/{id}",method = RequestMethod.GET)
	public List<Eleve> getEleveByIdecole(@PathVariable("id") Long id) {
		return eleveService.findByEcoleId(id);
	 }
	
	@RequestMapping(value="/elevebynom/{nom}",method = RequestMethod.GET)
	public List<Eleve> findByNomEleveContains(@PathVariable("nom") String nom) {
		return eleveService.findByNomEleveContains(nom);
	 }
}
