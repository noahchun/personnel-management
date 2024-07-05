
package com.skillstorm.spring_initialzr_web_version.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_initialzr_web_version.models.Detail;
import com.skillstorm.spring_initialzr_web_version.repositories.DetailRepository;

@Service
public class DetailService {
	
	@Autowired
	private DetailRepository repo;
	
	// get all
	public Iterable<Detail> getAllDetails() {
		return repo.findAll();
	}

}
