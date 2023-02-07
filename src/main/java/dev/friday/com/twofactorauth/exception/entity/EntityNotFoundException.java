package dev.friday.com.twofactorauth.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
