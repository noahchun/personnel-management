
package com.skillstorm.spring_initialzr_web_version.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spring_initialzr_web_version.models.Department;

import jakarta.transaction.Transactional;

// a repository is an interface that contains all the database methods we need for basic CRUD operations
// we can write custom ones if we wish but don't have to if the default functionality is enough

// the @Repository annotation sets this up as a Bean that can be injected
// extending CrudRepository for basic functionality <Object Type, Primary Key Type>
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
	// we can put custom methods in here
	
	// ordering our results by id instead of name
	@Query(value = "SELECT * FROM department ORDER BY department_id", nativeQuery = true)  // nativeQuery lets us use familiar SQL
	public Iterable<Department> getAllDepartmentsOrderedById();
	
	// getting a count of the departments
	@Query(value = "SELECT COUNT(*) FROM department", nativeQuery = true)
	public int countDepartments();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE department SET department_id = ?1, department_name = ?2 WHERE department_id = ?3", nativeQuery = true)
	public int update(int id, String name, int oldId);

}
