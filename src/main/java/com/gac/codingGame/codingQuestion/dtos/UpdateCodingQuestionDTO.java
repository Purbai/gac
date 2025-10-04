package com.gac.codingGame.codingQuestion.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


public class UpdateCodingQuestionDTO {
    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionDesc;

    @NotBlank
    private String functionName;

    @NotBlank
    private String starterCode;

    @NotBlank
    private String hints;

    @NotEmpty(message = "Examples should not be empty")
    private List<String> examples;

    private String helperFunction;

    @NotBlank
    private String constraints;

    @NotBlank
    private String solution;

    @NotBlank
    private String difficulty;

    @NotEmpty(message = "testCases should not be empty")
    private List<String> testCases;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getStarterCode() {
        return starterCode;
    }

    public String getHints() {
        return hints;
    }

    public List<String> getExamples() {
        return examples;
    }

    public String getHelperFunction() {
        return helperFunction;
    }

    public String getConstraints() {
        return constraints;
    }

    public String getSolution() {
        return solution;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public List<String> getTestCases() {
        return testCases;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setStarterCode(String starterCode) {
        this.starterCode = starterCode;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public void setHelperFunction(String helperFunction) {
        this.helperFunction = helperFunction;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTestCases(List<String> testCases) {
        this.testCases = testCases;
    }

    @Override
    public String toString() {
        return "UpdateCodingQuestionDTO{" +
                "questionTitle='" + questionTitle + '\'' +
                ", questionDesc='" + questionDesc + '\'' +
                ", functionName='" + functionName + '\'' +
                ", hints='" + hints + '\'' +
                ", examples='" + examples + '\'' +
                ", helperFunction='" + helperFunction + '\'' +
                ", constraints='" + constraints + '\'' +
                ", solution='" + solution + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", testCases='" + testCases + '\'' +
                '}';
    }
}
