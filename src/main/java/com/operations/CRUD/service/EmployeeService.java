package com.operations.CRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.operations.CRUD.entity.Employee;
import com.operations.CRUD.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		return response;
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId);
	}

//	 public Employee saveEmployee(Employee employee) {
//	        return employeeRepository.save(employee);
//	    }
	
	
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	
}
