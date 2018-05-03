package br.com.tw.lunchandlearn.domain.base.exception;

public abstract class ApiException extends RuntimeException {
    public abstract ApiExceptionCode getApiExceptionCode();
}
