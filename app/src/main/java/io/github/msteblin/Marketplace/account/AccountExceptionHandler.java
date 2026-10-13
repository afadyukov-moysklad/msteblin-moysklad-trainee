package io.github.msteblin.Marketplace.account;

import io.github.msteblin.Marketplace.exception.ErrorResponse;
import io.github.msteblin.Marketplace.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// TODO: decide if this should be made global
@RestControllerAdvice
@RequestMapping("/accounts")
public class AccountExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse("account not found", exception.getMessage());
    }
}
