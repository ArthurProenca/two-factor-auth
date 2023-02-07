package dev.friday.com.twofactorauth.exception.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{
    public ValidationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}
