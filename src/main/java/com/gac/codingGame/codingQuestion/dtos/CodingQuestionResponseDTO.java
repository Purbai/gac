package com.gac.codingGame.codingQuestion.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CodingQuestionResponseDTO {
    private Long id;
    private String questionTitle;
    @Column(columnDefinition = "TEXT")
    private String questionDesc;
    private String functionName;
    @Column(columnDefinition = "TEXT")
    private String starterCode;
    @Column(columnDefinition = "TEXT")
    private String hints;
    @Column(columnDefinition = "TEXT[]")
    private String[] examples;
    @Column(columnDefinition = "TEXT")
    private String helperFunction;
    @Column(columnDefinition = "TEXT")
    private String constraints;
    @Column(columnDefinition = "TEXT")
    private String solution;
    @Column(columnDefinition = "TEXT")
    private String difficulty;
    @Column(columnDefinition = "TEXT[]")
    private String[] testCases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getStarterCode() {
        return starterCode;
    }

    public void setStarterCode(String starterCode) {
        this.starterCode = starterCode;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public String[] getExamples() {
        return examples;
    }

    public void setExamples(String[] examples) {
        this.examples = examples;
    }

    public String getHelperFunction() {
        return helperFunction;
    }

    public void setHelperFunction(String helperFunction) {
        this.helperFunction = helperFunction;
    }

    public String getConstraints() {
        return constraints;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getTestCases() {
        return testCases;
    }

    public void setTestCases(String[]testCases) {
        this.testCases = testCases;
    }
}
