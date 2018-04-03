package br.com.tw.lunchandlearn.presentation.handler;

import br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static br.com.tw.lunchandlearn.domain.base.exception.ApiExceptionCode.*;

class HttpStatusCodeFactory {

    private static final ApiExceptionCode[] unauthorizedList = {INVALID_CREDENTIALS};

    static HttpStatus fromApiExceptionCode(ApiExceptionCode code) {
        if (checkIfCodeIsPresentInList(code, unauthorizedList)) {
            return HttpStatus.UNAUTHORIZED;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private static boolean checkIfCodeIsPresentInList(ApiExceptionCode code, ApiExceptionCode[] list) {
        return Arrays.asList(list).contains(code);

    }
}
