package com.operations.CRUD.repository;
// PayrollRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operations.CRUD.entity.Payroll;
@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
