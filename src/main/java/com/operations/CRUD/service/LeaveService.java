package com.operations.CRUD.service;
// LeaveService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.operations.CRUD.entity.Employee;
import com.operations.CRUD.entity.LeaveTable;
import com.operations.CRUD.repository.LeaveRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public List<LeaveTable> getAllLeaveRequests() {
        return leaveRepository.findAll();
    }

    public Optional<LeaveTable> getLeaveById(Long leaveId) {
        return leaveRepository.findById(leaveId);
    }

    public ResponseEntity<LeaveTable> saveLeave(LeaveTable leave) {
    	LeaveTable updlev= leaveRepository.save(leave);
    	ResponseEntity<LeaveTable> resLev=new ResponseEntity<LeaveTable>(updlev, HttpStatus.ACCEPTED);
        return resLev;
    }
/*public ResponseEntity<Employee> saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		return response;
	}*/
    public void deleteLeave(Long leaveId) {
        leaveRepository.deleteById(leaveId);
    }
}
