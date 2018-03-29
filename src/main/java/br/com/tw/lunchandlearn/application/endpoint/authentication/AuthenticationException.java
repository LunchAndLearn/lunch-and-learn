package br.com.tw.lunchandlearn.application.endpoint.authentication;

import br.com.tw.lunchandlearn.domain.exception.ApiException;
import br.com.tw.lunchandlearn.domain.exception.ApiExceptionCode;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends ApiException {

    @Override
    public HttpStatus getHttpStatusCode() {
        return HttpStatus.UNAUTHORIZED;
    }

    @Override
    public int getApiExceptionCode() {
        return ApiExceptionCode.INVALID_CREDENTIALS.getCode();
    }

    @Override
    public String getMessage() {
        return "Your credentials are invalid.";
    }
}
