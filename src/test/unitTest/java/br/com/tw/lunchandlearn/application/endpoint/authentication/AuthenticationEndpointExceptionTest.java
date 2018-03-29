package br.com.tw.lunchandlearn.application.endpoint.authentication;

import br.com.tw.lunchandlearn.application.endpoint.authentication.AuthenticationException;
import br.com.tw.lunchandlearn.domain.exception.ApiExceptionCode;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AuthenticationEndpointExceptionTest {

    @Test
    public void httpsStatusCodeShouldBeUnothorized() {
        AuthenticationException authenticationException = new AuthenticationException();

        HttpStatus httpStatus = authenticationException.getHttpStatusCode();

        assertThat(httpStatus, is(HttpStatus.UNAUTHORIZED));
    }

    @Test
    public void apiExceptionCodeShouldBeInvalidCredentials() {
        AuthenticationException authenticationException = new AuthenticationException();

        int code = authenticationException.getApiExceptionCode();

        assertThat(code, is(ApiExceptionCode.INVALID_CREDENTIALS.getCode()));
    }

    @Test
    public void messageShouldDescribeTheException() {
        AuthenticationException authenticationException = new AuthenticationException();

        String message = authenticationException.getMessage();

        assertThat(message, is("Your credentials are invalid."));
    }
}