package com.gac.codingGame.codingQuestion.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


public class CreateCodingQuestionDTO {
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

    @NotEmpty
    private List<String> examples;

    private String helperFunction;

    @NotBlank
    private String constraints;

    @NotBlank
    private String solution;

    @NotBlank
    private String difficulty;

    @NotEmpty
    private List<String> testCases;

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

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
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

    public List<String> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<String> testCases) {
        this.testCases = testCases;
    }
}
