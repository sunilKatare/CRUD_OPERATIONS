package com.operations.CRUD.controller;
// PerformanceController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.operations.CRUD.entity.Performance;
import com.operations.CRUD.service.PerformanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/get")
    public List<Performance> getAllPerformances() {
        return performanceService.getAllPerformances();
    }

    @GetMapping("/{performanceId}")
    public ResponseEntity<Performance> getPerformanceById(@PathVariable Long performanceId) {
        Optional<Performance> performance = performanceService.getPerformanceById(performanceId);
        return performance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Performance> createPerformance(@RequestBody Performance performance) {
        Performance savedPerformance = performanceService.savePerformance(performance);
        return ResponseEntity.ok(savedPerformance);
    }

    @PutMapping("/{performanceId}")
    public ResponseEntity<Performance> updatePerformance(@PathVariable Long performanceId, @RequestBody Performance updatedPerformance) {
        if (performanceService.getPerformanceById(performanceId).isPresent()) {
            updatedPerformance.setPerformanceId(performanceId);
            Performance savedPerformance = performanceService.savePerformance(updatedPerformance);
            return ResponseEntity.ok(savedPerformance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{performanceId}")
    public Optional<Performance> deletePerformance(@PathVariable Long performanceId) {
    	Optional<Performance> per=performanceService.getPerformanceById(performanceId);
    	if (per.isPresent()) {
            performanceService.deletePerformance(performanceId);
            return per;
        } else {
            return per;
        }
    }
}

