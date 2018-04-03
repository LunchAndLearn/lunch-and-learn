package br.com.tw.lunchandlearn.presentation.handler;

import br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HttpStatusCodeFactoryTest {

    @Test
    public void returnHttpStatusCodeUnauthorizedWhenApiExceptionCodeIsInvalidCredentials() {
        HttpStatus httpStatus = HttpStatusCodeFactory.fromApiExceptionCode(ApiExceptionCode.INVALID_CREDENTIALS);

        assertThat(httpStatus, is(HttpStatus.UNAUTHORIZED));
    }

    @Test
    public void returnHttpStatusCodeInternalServerErrorWhenApiExceptionCodeIsNotMapped() {
        HttpStatus httpStatus = HttpStatusCodeFactory.fromApiExceptionCode(ApiExceptionCode.UNDEFINED_ERROR);

        assertThat(httpStatus, is(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}