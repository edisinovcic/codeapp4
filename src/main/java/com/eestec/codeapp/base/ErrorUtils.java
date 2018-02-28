package com.eestec.codeapp.base;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ErrorUtils {

    private ErrorUtils() {
        throw new IllegalStateException();
    }

    public static List<RestFieldError> mapErrors(List<FieldError> fieldErrors) {
        List<RestFieldError> restFieldErrors = new ArrayList<>();
        fieldErrors.forEach(fe -> restFieldErrors.add(new RestFieldError(fe.getField(), fe.getDefaultMessage())));
        return restFieldErrors;
    }
}