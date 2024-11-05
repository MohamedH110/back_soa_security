package com.example.demo_eleves;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo_eleves.entities.Eleve;
import com.example.demo_eleves.entities.Ecole;

@SpringBootApplication
public class DemoElevesApplication implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(DemoElevesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Eleve.class,Ecole.class);
	}
	
	@Bean
	public ModelMapper modelmMpper() {
		return new ModelMapper();
	}
	

}
