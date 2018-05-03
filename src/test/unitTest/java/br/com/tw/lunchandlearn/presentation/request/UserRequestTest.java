package br.com.tw.lunchandlearn.presentation.request;

import br.com.tw.lunchandlearn.presentation.request.UserRequest.Office;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRequestTest {

    private UserRequest userRequest;

    private RequestValidator<UserRequest> requestValidator;

    @Before
    public void setUp() {
        userRequest = createAValidUserRequest();
        requestValidator = new RequestValidator<>();
    }

    @Test
    public void validatesFirstWhenNameIsEmpty() {
        userRequest.firstName = "";
        String expectedMessage = "firstName may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenFirstNameIsNull() {
        userRequest.firstName = null;
        String expectedMessage = "firstName may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenLastNameIsEmpty() {
        userRequest.lastName = "";
        String expectedMessage = "lastName may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenLastNameIsNull() {
        userRequest.lastName = null;
        String expectedMessage = "lastName may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenThoughtWorksUserIsEmpty() {
        userRequest.thoughtWorksUser = "";
        String expectedMessage = "thoughtWorksUser may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenThoughtWorksUserIsNull() {
        userRequest.thoughtWorksUser = null;
        String expectedMessage = "thoughtWorksUser may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenPasswordIsEmpty() {
        userRequest.password = "";
        String expectedMessage = "password may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenPasswordIsNull() {
        userRequest.password = null;
        String expectedMessage = "password may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenOfficeNameIsEmpty() {
        userRequest.office.name = "";
        String expectedMessage = "office.name may not be empty or null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validatesWhenOfficeIsNull() {
        userRequest.office = null;
        String expectedMessage = "office may not be null; ";

        String actualMessage = requestValidator.validate(userRequest);

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    private UserRequest createAValidUserRequest() {
        Office office = new Office();
        office.name = "Belo Horizonte";

        UserRequest userRequest = new UserRequest();
        userRequest.firstName = "First";
        userRequest.lastName = "Last";
        userRequest.thoughtWorksUser = "filast";
        userRequest.password = "123123";
        userRequest.office = office;

        return userRequest;
    }

}