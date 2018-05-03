package br.com.tw.lunchandlearn.presentation.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserRequest {

    private static final String MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE = "may not be empty or null";
    private static final String MAY_NOT_BE_NULL_MESSAGE = "may not be null";

    @NotBlank(message = MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE)
    public String firstName;

    @NotBlank(message = MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE)
    public String lastName;

    @NotBlank(message = MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE)
    public String thoughtWorksUser;

    @NotBlank(message = MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE)
    public String password;

    @Valid
    @NotNull(message = MAY_NOT_BE_NULL_MESSAGE)
    public Office office;

    public static class Office {

        @NotBlank(message = MAY_NOT_BE_EMPTY_OR_NULL_MESSAGE)
        public String name;
    }

}
