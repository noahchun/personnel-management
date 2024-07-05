
package com.skillstorm.spring_initialzr_web_version.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_initialzr_web_version.models.Employee;
import com.skillstorm.spring_initialzr_web_version.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	// get all
	public Iterable<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	// create one
	public Employee createEmployee(Employee employee) {
		if(repo.existsById(employee.getEmployeeId()))
			return null;
		return repo.save(employee);
	}
	
	public ResponseEntity<Employee> getEmployeeById(int employeeId) {
        if (!repo.existsById(employeeId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .header("Error", "An Employee with this ID doesn't exist!")
                                 .body(null);
        }
        Employee employee = repo.findById(employeeId).orElse(null);
        if (employee != null) {
            return ResponseEntity.status(HttpStatus.OK)
                                 .header("Message", "Successfully retrieved Employee by ID!")
                                 .body(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .header("Error", "Employee found in existence, but couldn't fetch details.")
                                 .body(null);
        }
    }
	
	public boolean existsById(int id) {
        return repo.existsById(id);
    }
	
	public void deleteEmployeeById(int id) {
        repo.deleteById(id);
    }

}
