package com.operations.CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operations.CRUD.entity.Employee;
import com.operations.CRUD.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/get")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = employeeService.saveEmployee(employee);
		return resp;
	}

	@GetMapping("/get/{employeeId}")
	public Optional<Employee> getEmployeeById(@PathVariable Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PutMapping("/{employeeid}")
	public ResponseEntity<ResponseEntity<Employee>> updateEmployee(@RequestBody Employee updatedEmployee) {
		Optional<Employee> emp = employeeService.getEmployeeById(updatedEmployee.getEmployeeid());
		if (emp.isPresent()) {
			ResponseEntity<Employee> savedEmployee = employeeService.saveEmployee(updatedEmployee);
			return ResponseEntity.ok(savedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{employeeId}")
	public Optional<Employee> deleteEmployee(@PathVariable Long employeeId) {
		Optional<Employee> emp = employeeService.getEmployeeById(employeeId);
		if (emp.isPresent()) {
			employeeService.deleteEmployee(employeeId);
			return emp;
		} else {
			return emp;

		}
	}
}