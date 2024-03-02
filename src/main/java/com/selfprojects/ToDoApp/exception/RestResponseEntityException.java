package com.selfprojects.ToDoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.selfprojects.ToDoApp.model.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleToDoServiceException(CustomException ex) {
        return new ResponseEntity <>(new ErrorResponse().builder()
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}
