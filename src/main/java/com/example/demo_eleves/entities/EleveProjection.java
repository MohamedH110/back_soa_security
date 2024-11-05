package com.example.demo_eleves.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomeleve", types = { Eleve.class })
public interface EleveProjection {
	public String getNom();
	


}
