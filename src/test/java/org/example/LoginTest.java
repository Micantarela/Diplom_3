package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.object.LoginPage;
import org.example.page.object.MainPage;
import org.example.page.object.RegistrationPage;
import org.example.page.object.RestorePasswordPage;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest extends BaseAutoTest {

    @BeforeClass
    public static void before() {
        TestUtils.registerUser(USERNAME, PASSWORD, EMAIL);
    }

    @Test
    @DisplayName("Login by 'Login to account' button from main page")
    @Description("Вход по кнопке 'Войти в аккаунт' на главной странице")
    public void loginByLoginToAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.assertLoginToAccountButtonIsVisible();
        mainPage.clickLoginToAccountButton();

        login(loginPage);

        mainPage.assertMakeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Login by 'Personal cabinet' button from main page")
    @Description("Вход через кнопку 'Личный кабинет'")
    public void loginByPersonalCabinetButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        login(loginPage);

        mainPage.assertMakeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Login by 'Login' button from registration page")
    @Description("Вход вход через кнопку 'Войти' на форме регистрации")
    public void loginByLoginButtonFromRegistrationPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openMainPage();
        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();
        loginPage.clickRegistrationButton();

        registrationPage.assertTitleIsVisible();
        registrationPage.clickLoginButton();

        login(loginPage);

        mainPage.assertMakeOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Login by 'Login' button from restore password page")
    @Description("Вход вход через кнопку 'Войти' на форме восстановления пароля")
    public void loginByLoginButtonFromRestorePasswordTestTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);

        mainPage.openMainPage();
        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();
        loginPage.clickRestorePasswordButton();

        restorePasswordPage.assertTitleIsVisible();
        restorePasswordPage.clickLoginButton();

        login(loginPage);

        mainPage.assertMakeOrderButtonIsVisible();
    }

}
