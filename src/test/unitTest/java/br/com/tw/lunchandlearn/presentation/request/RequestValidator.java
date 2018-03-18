package br.com.tw.lunchandlearn.presentation.request;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class RequestValidator<T> {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    protected String validate(T request) {
        Set<ConstraintViolation<T>> validationError = validator.validate(request);

        StringBuilder builder = new StringBuilder();
        validationError.iterator()
                .forEachRemaining(violation -> getConstraintViolationMessage(builder, violation));

        return builder.toString();
    }

    private void getConstraintViolationMessage(StringBuilder builder, ConstraintViolation<T> violation) {
        builder.append(violation.getPropertyPath().toString())
                .append(" ")
                .append(violation.getMessage())
                .append("; ");
    }

}
