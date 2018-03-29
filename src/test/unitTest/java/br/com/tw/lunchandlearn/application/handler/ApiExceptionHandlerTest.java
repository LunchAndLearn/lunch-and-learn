package br.com.tw.lunchandlearn.application.handler;

import br.com.tw.lunchandlearn.domain.base.exception.ApiException;
import br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ApiExceptionHandlerTest {

    @Test
    public void respondAnApiExceptionResponseUsingApiExceptionInformation() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();

        ApiException apiException = new ApiException() {
            @Override
            public ApiExceptionCode getApiExceptionCode() {
                return ApiExceptionCode.INVALID_CREDENTIALS;
            }

            @Override
            public String getMessage() {
                return "Exception Custom Message";
            }
        };

        ResponseEntity<ApiExceptionResponse> response = apiExceptionHandler.handleExceptions(apiException);

        assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(response.getBody().code, is(ApiExceptionCode.INVALID_CREDENTIALS.getCode()));
        assertThat(response.getBody().message, is("Exception Custom Message"));
    }

    @Test
    public void respondAnApiExceptionResponseEvenWhenAnErrorOccur() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();

        Exception exception = new Exception() {
            @Override
            public String getMessage() {
                return "Error";
            }
        };

        ResponseEntity<ApiExceptionResponse> response = apiExceptionHandler.handleErrors(exception);

        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getBody().code, is(ApiExceptionCode.UNDEFINED_ERROR.getCode()));
        assertThat(response.getBody().message, is("Error"));
    }
}