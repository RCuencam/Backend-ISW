package com.example.jobagapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class ResourceIncorrectData  extends RuntimeException {

    public ResourceIncorrectData() {
        super();
    }

    public ResourceIncorrectData(String message) {
        super(message);
    }

    public ResourceIncorrectData(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceIncorrectData(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Resource %s incorrect for %s with value %s", resourceName, fieldName, fieldValue));


    }
}