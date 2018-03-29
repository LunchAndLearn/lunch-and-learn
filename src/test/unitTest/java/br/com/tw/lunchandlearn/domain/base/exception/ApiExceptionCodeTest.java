package br.com.tw.lunchandlearn.domain.base.exception;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ApiExceptionCodeTest {

    @Test
    public void undefinedErrorCodeIsPresent() {
        assertThat(ApiExceptionCode.UNDEFINED_ERROR.getCode(), is(1));
    }

    @Test
    public void invalidCredentialsCodeIsPresent() {
        assertThat(ApiExceptionCode.INVALID_CREDENTIALS.getCode(), is(2));
    }
}