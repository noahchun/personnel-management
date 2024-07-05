
package com.skillstorm.spring_initialzr_web_version.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spring_initialzr_web_version.models.Certification;

@Repository
public interface CertificationRepository extends CrudRepository<Certification, Integer> {

}
