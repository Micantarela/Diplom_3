package org.example.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    public static final String TITLE = ".//h2[text()='Регистрация']";
    public static final String NAME_INPUT = ".//div[./label[text()='Имя']]/input";
    public static final String EMAIL_INPUT = ".//div[./label[text()='Email']]/input";
    public static final String PASSWORD_INPUT = ".//div[./label[text()='Пароль']]/input";
    public static final String REGISTRATION_BUTTON = ".//button[text()='Зарегистрироваться']";
    public static final String LOGIN_BUTTON = ".//a[text()='Войти']";
    public static final String INVALID_PASSWORD_MSG = ".//p[text()='Некорректный пароль']";

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что отображается заголовок 'Регистрация'")
    public void assertTitleIsVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE)));
    }

    @Step("Проверка, что отображается сообщение 'Некорректный пароль'")
    public void assertInvalidPasswordMsgIsVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INVALID_PASSWORD_MSG)));
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(By.xpath(REGISTRATION_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Step("Заполнение поля 'Имя'")
    public void fillNameInput(String value) {
        driver.findElement(By.xpath(NAME_INPUT)).sendKeys(value);
    }

    @Step("Заполнение поля 'Email'")
    public void fillEmailInput(String value) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(value);
    }

    @Step("Заполнение поля 'Пароль'")
    public void fillPasswordInput(String value) {
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(value);
    }

}
