package com.zuzex.education.autkincityservice.exception.handler;

import com.zuzex.education.autkincityservice.dto.error.ErrorRs;
import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.exception.RelationForUserAlreadyExistException;
import com.zuzex.education.autkincityservice.exception.RelationForUserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorRs handleEntityNotFoundException(EntityNotFoundException e) {
        return ErrorRs.builder().message(e.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RelationForUserAlreadyExistException.class)
    public ErrorRs handleRelationForUserAlreadyExistException(RelationForUserAlreadyExistException e) {
        return ErrorRs.builder().message(e.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RelationForUserNotExistException.class)
    public ErrorRs handleRelationForUserNotExistException(RelationForUserNotExistException e) {
        return ErrorRs.builder().message(e.getMessage()).build();
    }
}
