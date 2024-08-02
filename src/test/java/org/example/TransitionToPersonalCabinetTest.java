package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.object.LoginPage;
import org.example.page.object.MainPage;
import org.example.page.object.PersonalCabinetPage;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransitionToPersonalCabinetTest extends BaseAutoTest {

    @BeforeClass
    public static void before() {
        TestUtils.registerUser(USERNAME, PASSWORD, EMAIL);
    }

    @Test
    @DisplayName("Transition to personal cabinet by authorized user")
    @Description("Переход в 'Личный кабинет' авторизованным пользователем")
    public void transitionToPersonalCabinetTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);

        mainPage.openMainPage();
        mainPage.clickPersonalCabinetButton();

        login(loginPage);

        mainPage.assertPersonalCabinetButtonIsVisible();
        mainPage.clickPersonalCabinetButton();

        personalCabinetPage.assertProfileTitleIsVisible();
    }

}
