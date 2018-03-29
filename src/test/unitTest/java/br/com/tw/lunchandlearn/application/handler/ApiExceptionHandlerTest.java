package br.com.tw.lunchandlearn.application.handler;

import br.com.tw.lunchandlearn.domain.exception.ApiException;
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
            public HttpStatus getHttpStatusCode() {
                return HttpStatus.CONFLICT;
            }

            @Override
            public int getApiExceptionCode() {
                return 123;
            }

            @Override
            public String getMessage() {
                return "Exception Custom Message";
            }
        };

        ResponseEntity<ApiExceptionResponse> response = apiExceptionHandler.handleExceptions(apiException);

        assertThat(response.getStatusCode(), is(HttpStatus.CONFLICT));
        assertThat(response.getBody().code, is(123));
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
        assertThat(response.getBody().code, is(1));
        assertThat(response.getBody().message, is("Error"));
    }
}