package com.operations.CRUD.service;
// PayrollService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operations.CRUD.entity.Payroll;
import com.operations.CRUD.repository.PayrollRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Optional<Payroll> getPayrollById(Long payrollId) {
        return  payrollRepository.findById(payrollId);
    }

    public Payroll savePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public void deletePayroll(Long payrollId) {
        payrollRepository.deleteById(payrollId);
    }
}
