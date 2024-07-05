package com.skillstorm.spring_initialzr_web_version.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_initialzr_web_version.models.Employee;
import com.skillstorm.spring_initialzr_web_version.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	// get all
	@GetMapping
	public Iterable<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	// create one
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = service.createEmployee(employee);
		System.out.println("Created Employee: " + savedEmployee);
		return savedEmployee;
	}
	
	@GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) {
        return service.getEmployeeById(employeeId);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id) {
        if (!service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
