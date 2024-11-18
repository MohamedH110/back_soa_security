package com.example.demo_eleves.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo_eleves.entities.Eleve;
import com.example.demo_eleves.entities.Image;
import com.example.demo_eleves.repos.ImageRepository;
import com.example.demo_eleves.repos.eleverepos;




@Transactional
@Service
public class ImageServiceImpl implements ImageService {
	
	 @Autowired
	 ImageRepository imageRepository;


	 @Autowired
	 EleveService eleveService;
	 
	 @Autowired
	 eleverepos eleveRepository;
	 
		@Override
		public Image uplaodImage(MultipartFile file) throws IOException {
			/*
			 * Ce code commenté est équivalent au code utilisant le design pattern Builder
			 * Image image = new Image(null, file.getOriginalFilename(),
			 * file.getContentType(), file.getBytes(), null);
			 *   return imageRepository.save(image);
			 */
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).build());
		}

		@Override
		public Image getImageDetails(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
					.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
		}

		@Override
		public ResponseEntity<byte[]> getImage(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
					.body(dbImage.get().getImage());
		}

		@Override
		public void deleteImage(Long id) {
			imageRepository.deleteById(id);
		}

		@Override
		public Image uplaodImageEleve(MultipartFile file,Long idProd) 
		throws IOException {
				Eleve p = new Eleve();
				p.setId(idProd);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .eleve(p).build() );
		}

		@Override
		public List<Image> getImagesParEleve(Long prodId) {
			Eleve p = eleveRepository.findById(prodId).get(); 
			return p.getImages();
				
		}

		
		
		
		
		
	}
