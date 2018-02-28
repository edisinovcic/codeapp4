package com.eestec.codeapp.base;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ResourceBundle;

public abstract class BaseException extends Exception {

    @Getter
    private final String message;

    @Getter
    private final Throwable exception;

    @Getter
    private final String code;

    //TODO mozda maknuti jer bi svi trebali imati lokalizirane poruke?
    public BaseException(String message) {
        super(message);
        this.message = message;
        this.exception = null;
        this.code = null;
    }

    //TODO mozda maknuti jer bi svi trebali imati lokalizirane poruke?
    public BaseException(String message, Throwable ex) {
        super(message);
        this.message = message;
        this.exception = ex;
        this.code = null;
    }

    public BaseException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.exception = null;
        this.code = errorCode;
    }

    public BaseException(String message, String errorCode, Throwable ex) {
        super(message);
        this.message = message;
        this.exception = ex;
        this.code = errorCode;
    }

    @Override
    public String getLocalizedMessage() {
        if (code == null) {
            return this.message;
        } else {
            //find localized message from resource bundle by code
            return ResourceBundle.getBundle("ErrorBundle", LocaleContextHolder.getLocale()).getString(code);
        }
    }
}