package com.operations.CRUD.controller;

import java.util.List;
import java.util.Optional;

// LeaveController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.operations.CRUD.entity.Employee;
import com.operations.CRUD.entity.LeaveTable;
import com.operations.CRUD.entity.Payroll;
import com.operations.CRUD.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {
	@Autowired
	private LeaveService leaveService;

	@GetMapping("/get")
	public List<LeaveTable> getAllLeaveRequests() {
		return leaveService.getAllLeaveRequests();
	}

	@GetMapping("/get/{leaveId}")
	public Optional<LeaveTable> getLeaveById(@PathVariable Long leaveId) {
		return leaveService.getLeaveById(leaveId);
	}

	@PostMapping
	public ResponseEntity<LeaveTable> createLeave(@RequestBody LeaveTable empleave) {
		ResponseEntity<LeaveTable> savedLeave = leaveService.saveLeave(empleave);
		return savedLeave;
	}

	@PutMapping("/{leaveId}")
	public ResponseEntity<ResponseEntity<LeaveTable>> updateLeave(@RequestBody LeaveTable updateLeave) {
		Optional<LeaveTable> updLeav = leaveService.getLeaveById(updateLeave.getLeaveId());
		if (updLeav.isPresent()) {
			ResponseEntity<LeaveTable> saveLeav = leaveService.saveLeave(updateLeave);
			return ResponseEntity.ok(saveLeav);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{leaveId}")
	public Optional<LeaveTable> deleteLeave(@PathVariable Long leaveId) {
		Optional<LeaveTable> lev = leaveService.getLeaveById(leaveId);
		if (lev.isPresent()) {
			leaveService.deleteLeave(leaveId);
			return lev;
		} else {
			return lev;
		}
	}
}
