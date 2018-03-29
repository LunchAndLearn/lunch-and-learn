package br.com.tw.lunchandlearn.domain.exception;

public enum ApiExceptionCode {
    UNDEFINED_ERROR(1),
    INVALID_CREDENTIALS(2);

    private int code;

    ApiExceptionCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
