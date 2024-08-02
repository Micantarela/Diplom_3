package org.example;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.dto.UserInfoDto;
import org.example.dto.UserLoginResponseDto;

import static io.restassured.RestAssured.given;

public class TestUtils {

    public static final String CONTENT_TYPE_HEADER = "Content-type";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String APPLICATION_JSON_VALUE = "application/json";

    public static final String STAND_URL = " https://stellarburgers.nomoreparties.site/api";
    public static final String REGISTRATION_URL = String.join("/", STAND_URL, "auth/register");
    public static final String USER_URL = String.join("/", STAND_URL, "auth/user");
    public static final String LOGIN_URL = String.join("/", STAND_URL, "auth/login");


    @Step("Удаление пользователя")
    public static void deleteUser(String username, String password, String email) {
        Response response = loginUser(username, password, email);
        if (response.getStatusCode() == 200) {
            String accessToken = response.as(UserLoginResponseDto.class).getAccessToken();
            deleteUser(accessToken);
        }
    }

    @Step("Вызов запроса для авторизации пользователя")
    public static Response loginUser(String name, String password, String email) {
        UserInfoDto loginDto = new UserInfoDto(name, password, email);
        return given()
            .header(CONTENT_TYPE_HEADER, APPLICATION_JSON_VALUE)
            .auth().none()
            .and()
            .body(loginDto)
            .when()
            .post(LOGIN_URL);
    }

    @Step("Вызов запроса для удаления пользователя")
    public static void deleteUser(String accessToken) {
        given()
            .header(AUTHORIZATION_HEADER, accessToken)
            .when()
            .delete(USER_URL);
    }

    @Step("Вызов запроса для регистрации пользователя")
    public static Response registerUser(String name, String password, String email) {
        UserInfoDto createDto = new UserInfoDto(name, password, email);
        return given()
            .header(CONTENT_TYPE_HEADER, APPLICATION_JSON_VALUE)
            .auth().none()
            .and()
            .body(createDto)
            .when()
            .post(REGISTRATION_URL);
    }

}
