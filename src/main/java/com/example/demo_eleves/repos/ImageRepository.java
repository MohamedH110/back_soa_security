package com.example.demo_eleves.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_eleves.entities.Image;



public interface ImageRepository extends JpaRepository<Image, Long> {

}