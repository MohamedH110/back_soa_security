package com.example.demo_eleves.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo_eleves.entities.Ecole;
import com.example.demo_eleves.entities.Eleve;

@RepositoryRestResource(path = "rest")
public interface eleverepos extends JpaRepository<Eleve, Long> {

    // Standard query methods
    List<Eleve> findByNom(String nom);
    List<Eleve> findByNomContains(String nom);
    
    // Custom query with case-sensitive entity name and correct query structure
    @Query("SELECT e FROM Eleve e WHERE e.nom LIKE %:nom AND e.age > :age")
    List<Eleve> findByNomAge(@Param("nom") String nom, @Param("age") int age);

    // Query for finding students by school
    @Query("SELECT e FROM Eleve e WHERE e.ecole = ?1")
    List<Eleve> findByEcole(Ecole ecole);

    // Query for finding students by school ID
    List<Eleve> findByEcoleId(Long id);

    // Query to find all students ordered by name ascending
    List<Eleve> findByOrderByNomAsc();

    // Custom query to sort students by name (ascending) and age (descending)
    @Query("SELECT e FROM Eleve e ORDER BY e.nom ASC, e.age DESC")
    List<Eleve> trierEleveNomAge();
}
