package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AuthenticationExceptionTest {

    @Test
    public void returnsInvalidCredentialsCode() {
        AuthenticationException authenticationException = new AuthenticationException();

        ApiExceptionCode apiExceptionCode = authenticationException.getApiExceptionCode();

        assertThat(apiExceptionCode, is(ApiExceptionCode.INVALID_CREDENTIALS));
    }

    @Test
    public void returnsAppropriatedMessageForAuthenticationException() {
        AuthenticationException authenticationException = new AuthenticationException();

        String message = authenticationException.getMessage();

        assertThat(message, is("Your credentials are invalid."));
    }
}