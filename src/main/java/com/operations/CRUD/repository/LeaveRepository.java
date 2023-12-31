package com.operations.CRUD.repository;
// LeaveRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operations.CRUD.entity.LeaveTable;
@Repository
public interface LeaveRepository extends JpaRepository<LeaveTable, Long> {
}
