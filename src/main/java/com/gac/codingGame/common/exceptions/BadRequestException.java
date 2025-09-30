package com.gac.codingGame.common.exceptions;

import com.gac.codingGame.common.ValidationErrors;
import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException{
    private ValidationErrors errors;

    public BadRequestException (String message, HttpStatus statusCode, ValidationErrors errors) {
        super(message, statusCode);
        this.errors = errors;
    }

    public BadRequestException(String message, ValidationErrors errors) {
        this(message,HttpStatus.BAD_REQUEST, errors);
    }

    public ValidationErrors getErrors() {
        return errors;
    }
}
