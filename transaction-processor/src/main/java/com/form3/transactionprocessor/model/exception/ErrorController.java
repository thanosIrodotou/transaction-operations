package com.form3.transactionprocessor.model.exception;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.ImmutableMap;

@ControllerAdvice
public class ErrorController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(TransactionAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Object processValidationError(TransactionAlreadyExistsException ex) {
        logger.error("Error: {}", ex.getReason());
        return constructUserError(ex);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Object processValidationError(TransactionNotFoundException ex) {
        logger.error("Error: {}", ex.getReason());
        return constructUserError(ex);
    }

    private ImmutableMap<String, ? extends Serializable> constructUserError(
            MonitoredException ex) {
        return ImmutableMap.of("errorCode", ex.getStatusCode(),
                "message", ex.getReason());
    }
}
