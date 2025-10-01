package com.gac.codingGame.codingQuestion.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class CreateCodingQuestionDTO {
    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionDesc;

    @NotBlank
    private String functionName;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String starterCode;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String hints;

    @NotBlank
    @Column(columnDefinition = "TEXT[]")
    private String[] examples;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String constraints;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String solution;

    @NotBlank
    private String difficulty;

    @NotBlank
    @Column(columnDefinition = "TEXT[]")
    private String[] testCases;

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

    public void setTestCases(String[] testCases) {
        this.testCases = testCases;
    }
}
