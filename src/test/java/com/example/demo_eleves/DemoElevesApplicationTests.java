package com.example.demo_eleves;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_eleves.entities.Eleve;
import com.example.demo_eleves.repos.eleverepos;

@SpringBootTest
class DemoElevesApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private eleverepos eleveRepository;

	@Test
	 public void testCreateEleve() {
		/*Eleve eleve1 = new Eleve("salah",11);
		eleveRepository.save(eleve1);*/
	}
	/* @Test
		public void testFindEleve()
		 {
			 Eleve e = eleveRepository.findById(1L).get();		  
			 System.out.println(e);
		 }

		@Test
		public void testUpdateEleve()
		 {
			 Eleve e = eleveRepository.findById(1L).get();
			 e.setNom("mohamed");
			 eleveRepository.save(e);
		 }
		
		
	@Test
		public void testDeleteEleve()
		 {
		   eleveRepository.deleteById(1L);;
			 
		 }

	   
	@Test
		public void testListerTousEleves()
		 {
			 List<Eleve>  prods = eleveRepository.findAll();	 
				for (Eleve p : prods)
				{
					System.out.println(p);
				}	 
		 }
	
	
	
	
	

	@Test
	public void testTrierEleveNomAge()
	 {
		List<Eleve>  prods = eleveRepository.trierEleveNomAge();	 
			for (Eleve p : prods)
			{
				System.out.println(p);
			}
	 }*/
}
