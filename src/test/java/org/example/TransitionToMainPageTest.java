package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.object.LoginPage;
import org.example.page.object.MainPage;
import org.junit.Test;

public class TransitionToMainPageTest extends BaseAutoTest {

    @Test
    @DisplayName("Transition to main page when clicking on the constructor button")
    @Description("Переход в на главную страницу при клике на кнопку 'Конструктор'")
    public void transitionToMainPageWhenClickingOnConstructorButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();

        mainPage.clickConstructorButton();

        mainPage.assertCreateBurgerTitleIsVisible();
    }

    @Test
    @DisplayName("Transition to main page when clicking on the logo")
    @Description("Переход в на главную страницу при клике на логотип Stellar Burgers")
    public void transitionToMainPageWhenClickingOnLogoTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.clickPersonalCabinetButton();

        loginPage.assertTitleisVisible();

        mainPage.clickLogo();

        mainPage.assertCreateBurgerTitleIsVisible();
    }

}
