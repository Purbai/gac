package com.gac.codingGame.codingQuestion.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

public class UpdateCodingQuestionDTO {
    @Pattern(regexp = "^(?=.*\\S).*", message = "Coding question title should not be blank")
    private String questionTitle;

    @Pattern(regexp = ".*\\S.*", message = "Coding Question description should not be blank")
    private String questionDesc;

    @Pattern(regexp = ".*\\S.*", message = "Function name should not be blank")
    private String functionName;

    @Pattern(regexp = ".*\\S.*", message = "Hints should not be blank")
    @Column(columnDefinition = "TEXT")
    private String hints;

    @Pattern(regexp = ".*\\S.*", message = "Examples should not be blank")
    @Column(columnDefinition = "TEXT[]")
    private String examples;

    @Pattern(regexp = ".*\\S.*", message = "Constraints should not be blank")
    @Column(columnDefinition = "TEXT")
    private String constraints;

    @Pattern(regexp = ".*\\S.*", message = "Solution should not be blank")
    @Column(columnDefinition = "TEXT")
    private String solution;

    @Pattern(regexp = ".*\\S.*", message = "Difficulty should not be blank")
    private String difficulty;

    @Pattern(regexp = ".*\\S.*", message = "Testcases should not be blank")
    @Column(columnDefinition = "TEXT[]")
    private String testCases;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getHints() {
        return hints;
    }

    public String getExamples() {
        return examples;
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

    public String getTestCases() {
        return testCases;
    }

    @Override
    public String toString() {
        return "UpdateCodingQuestionDTO{" +
                "questionTitle='" + questionTitle + '\'' +
                ", questionDesc='" + questionDesc + '\'' +
                ", functionName='" + functionName + '\'' +
                ", hints='" + hints + '\'' +
                ", examples='" + examples + '\'' +
                ", constraints='" + constraints + '\'' +
                ", solution='" + solution + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", testCases='" + testCases + '\'' +
                '}';
    }
}
