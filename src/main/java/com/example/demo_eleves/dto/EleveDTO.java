package com.example.demo_eleves.dto;

import java.util.List;

import com.example.demo_eleves.entities.Ecole;
import com.example.demo_eleves.entities.*;
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
	    
	    public List<Image> images;


}
