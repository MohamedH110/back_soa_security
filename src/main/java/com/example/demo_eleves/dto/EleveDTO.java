package com.example.demo_eleves.dto;

import com.example.demo_eleves.entities.Ecole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EleveDTO {
	    private Long id;
	    private String nom;
	    private String classe;
	    private int age;
	    private Ecole ecole;
	    
	    private String nomEcole;


}
