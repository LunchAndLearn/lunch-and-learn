package br.com.tw.lunchandlearn.application.handler;

import br.com.tw.lunchandlearn.domain.exception.ApiException;
import br.com.tw.lunchandlearn.domain.exception.ApiExceptionCode;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ApiException.class })
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected ResponseEntity<ApiExceptionResponse> handleExceptions(ApiException apiException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.code = apiException.getApiExceptionCode();
        apiExceptionResponse.message = apiException.getMessage();

        return ResponseEntity.status(apiException.getHttpStatusCode()).body(apiExceptionResponse);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ApiExceptionResponse> handleErrors(Exception exception) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.code = ApiExceptionCode.UNDEFINED_ERROR.getCode();
        apiExceptionResponse.message = exception.getMessage();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiExceptionResponse);
    }
}
