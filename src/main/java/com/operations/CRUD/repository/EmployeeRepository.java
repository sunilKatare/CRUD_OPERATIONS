package com.operations.CRUD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operations.CRUD.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
