package com.eestec.codeapp.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("squid:S1948")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class RestError implements Serializable {

    private static final long serialVersionUID = 242385203498395L;

    @Getter
    private String message;

    @Getter
    private String type;

    @Getter
    private List<RestFieldError> fieldErrors;

    @Getter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    public RestError() {
        timestamp = new Date();
    }

    public RestError setMessage(String message) {
        this.message = message;
        return this;
    }

    public RestError setException(Throwable throwable) {
        this.type = throwable.getClass().getSimpleName();
        if (message == null) {
            this.message = throwable.getMessage();
        }
        if (throwable instanceof ValidationException) {
            ValidationException ex = (ValidationException) throwable;
            Optional.ofNullable(ex.getFieldErrors()).ifPresent(fe -> fieldErrors = ErrorUtils.mapErrors(fe));
        }
        return this;
    }
}

