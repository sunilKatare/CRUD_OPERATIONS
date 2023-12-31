package com.operations.CRUD.controller;
// PayrollController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.operations.CRUD.entity.Employee;
import com.operations.CRUD.entity.Payroll;
import com.operations.CRUD.service.PayrollService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payrolls")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @GetMapping("/get")
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }
    

    @GetMapping("/{payrollId}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long payrollId) {
        Optional<Payroll> payroll = payrollService.getPayrollById(payrollId);
        return payroll.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll savedPayroll = payrollService.savePayroll(payroll);
        return ResponseEntity.ok(savedPayroll);
    }

    @PutMapping("/{payrollId}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable Long payrollId, @RequestBody Payroll updatedPayroll) {
        if (payrollService.getPayrollById(payrollId).isPresent()) {
            updatedPayroll.setPayrollId(payrollId);
            Payroll savedPayroll = payrollService.savePayroll(updatedPayroll);
            return ResponseEntity.ok(savedPayroll);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{payrollId}")
    public Optional<Payroll> deletePayroll(@PathVariable Long payrollId) {
        Optional<Payroll> pay=payrollService.getPayrollById(payrollId);
    	if (pay.isPresent()) {
            payrollService.deletePayroll(payrollId);
            return pay;
        } else {
            return pay;
        }
    }
}
