package com.example.demo_eleves.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_eleves.dto.EleveDTO;
import com.example.demo_eleves.entities.Ecole;
import com.example.demo_eleves.repos.ecolerepos;

@RestController
@RequestMapping("/eleves/eco")
@CrossOrigin("*")
public class ecoleRestController {
  
  @Autowired
  ecolerepos ecolerepos;
  
  @RequestMapping(method = RequestMethod.GET)
	public List<Ecole> getAllecoles() {
		return ecolerepos.findAll();
	 } 
  
  @RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Ecole getEcoleById(@PathVariable("id") Long id) {	
		return ecolerepos.findById(id).get();
  }

}
