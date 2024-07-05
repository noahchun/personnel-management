package com.skillstorm.spring_initialzr_web_version.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_initialzr_web_version.models.Certification;
import com.skillstorm.spring_initialzr_web_version.services.CertificationService;

@RestController
@RequestMapping("/certification")
@CrossOrigin(origins = "*")
public class CertificationController {
	
	@Autowired
	private CertificationService service;
	
	// get all
	@GetMapping
	public Iterable<Certification> getAllCertifications() {
		return service.getAllCertifications();
	}

}