package com.example.demo_eleves.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo_eleves.entities.Image;


public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;

	
	Image uplaodImageEleve(MultipartFile file,Long id) throws IOException;
	List<Image> getImagesParEleve(Long Id);

	

}