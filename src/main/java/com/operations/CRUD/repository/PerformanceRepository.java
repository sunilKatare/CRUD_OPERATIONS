package com.operations.CRUD.repository;

// PerformanceRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operations.CRUD.entity.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
