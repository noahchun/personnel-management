
package com.skillstorm.spring_initialzr_web_version.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_initialzr_web_version.models.Certification;
import com.skillstorm.spring_initialzr_web_version.repositories.CertificationRepository;

@Service
public class CertificationService {
	
	@Autowired
	private CertificationRepository repo;
	
	// get all
	public Iterable<Certification> getAllCertifications() {
		return repo.findAll();
	}

}
