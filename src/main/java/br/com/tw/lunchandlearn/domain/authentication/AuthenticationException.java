package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.domain.base.exception.ApiException;
import br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode;

public class AuthenticationException extends ApiException {

    @Override
    public ApiExceptionCode getApiExceptionCode() {
        return ApiExceptionCode.INVALID_CREDENTIALS;
    }

    @Override
    public String getMessage() {
        return "Your credentials are invalid.";
    }
}
