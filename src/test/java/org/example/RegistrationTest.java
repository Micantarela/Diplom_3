package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.object.LoginPage;
import org.example.page.object.MainPage;
import org.example.page.object.RegistrationPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class RegistrationTest extends BaseAutoTest {

    public static final String SHORT_PASSWORD = "12345";

    @BeforeClass
    public static void beforeClass() {
        TestUtils.deleteUser(USERNAME, PASSWORD, EMAIL);
    }

    @AfterClass
    public static void afterClass() {
        TestUtils.deleteUser(USERNAME, PASSWORD, EMAIL);
    }

    @Test
    @DisplayName("Successful user registration")
    @Description("Успешная регистрация пользователя")
    public void userRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openMainPage();
        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();
        loginPage.clickRegistrationButton();

        registrationPage.assertTitleIsVisible();
        registrationPage.fillNameInput(USERNAME);
        registrationPage.fillEmailInput(EMAIL);
        registrationPage.fillPasswordInput(PASSWORD);
        registrationPage.clickRegistrationButton();

        loginPage.assertTitleisVisible();
        loginPage.fillEmailInput(EMAIL);
        loginPage.fillPasswordInput(PASSWORD);
        loginPage.clickLoginButton();

        mainPage.assertMakeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("User registration with invalid password")
    @Description("Регистрация пользователя с некорректным паролем")
    public void userRegistrationWithInvalidPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openMainPage();
        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();
        loginPage.clickRegistrationButton();

        registrationPage.assertTitleIsVisible();
        registrationPage.fillNameInput(USERNAME);
        registrationPage.fillEmailInput(EMAIL);
        registrationPage.fillPasswordInput(SHORT_PASSWORD);
        registrationPage.clickRegistrationButton();

        registrationPage.assertInvalidPasswordMsgIsVisible();
    }

}
