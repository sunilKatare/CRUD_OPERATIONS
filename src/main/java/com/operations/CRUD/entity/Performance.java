package com.operations.CRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long performanceId;
    private Long employeeId;
    private String goalsAndObjectives;
    public Long getPerformanceId() {
		return performanceId;
	}
	public void setPerformanceId(Long performanceId) {
		this.performanceId = performanceId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getGoalsAndObjectives() {
		return goalsAndObjectives;
	}
	public void setGoalsAndObjectives(String goalsAndObjectives) {
		this.goalsAndObjectives = goalsAndObjectives;
	}
	public String getMetricsAndTargets() {
		return metricsAndTargets;
	}
	public void setMetricsAndTargets(String metricsAndTargets) {
		this.metricsAndTargets = metricsAndTargets;
	}
	public int getEvaluationScores() {
		return evaluationScores;
	}
	public void setEvaluationScores(int evaluationScores) {
		this.evaluationScores = evaluationScores;
	}
	public String getOverallPerformanceRating() {
		return overallPerformanceRating;
	}
	public void setOverallPerformanceRating(String overallPerformanceRating) {
		this.overallPerformanceRating = overallPerformanceRating;
	}
	public String getFeedbackAndComments() {
		return feedbackAndComments;
	}
	public void setFeedbackAndComments(String feedbackAndComments) {
		this.feedbackAndComments = feedbackAndComments;
	}
	private String metricsAndTargets;
    private int evaluationScores;
    private String overallPerformanceRating;
    private String feedbackAndComments;

    // getters and setters
}
