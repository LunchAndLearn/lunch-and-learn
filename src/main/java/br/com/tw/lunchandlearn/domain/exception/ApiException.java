package br.com.tw.lunchandlearn.domain.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {
    public abstract HttpStatus getHttpStatusCode();
    public abstract int getApiExceptionCode();
}
