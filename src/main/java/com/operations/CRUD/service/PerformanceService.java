package com.operations.CRUD.service;
// PerformanceService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operations.CRUD.entity.Performance;
import com.operations.CRUD.repository.PerformanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    public Optional<Performance> getPerformanceById(Long performanceId) {
        return performanceRepository.findById(performanceId);
    }

    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public void deletePerformance(Long performanceId) {
        performanceRepository.deleteById(performanceId);
    }
}
