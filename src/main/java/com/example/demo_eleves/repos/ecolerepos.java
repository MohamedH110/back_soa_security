package com.example.demo_eleves.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo_eleves.entities.Ecole;

@RepositoryRestResource(path="eco")
@CrossOrigin(origins = "http://localhost:4200")
public interface ecolerepos extends JpaRepository<Ecole, Long> {

}
