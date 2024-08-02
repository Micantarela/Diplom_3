package org.example.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static final String TITLE = ".//h2[text()='Вход']";
    public static final String EMAIL_INPUT = ".//div[./label[text()='Email']]/input";
    public static final String PASSWORD_INPUT = ".//div[./label[text()='Пароль']]/input";
    public static final String LOGIN_BUTTON = ".//button[text()='Войти']";
    public static final String REGISTRATION_BUTTON = ".//a[text()='Зарегистрироваться']";
    public static final String RESTORE_PASSWORD_BUTTON = ".//a[text()='Восстановить пароль']";

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что отображается заголовок 'Вход'")
    public void assertTitleisVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE)));
    }

    @Step("Заполнение поля 'Email'")
    public void fillEmailInput(String value) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(value);
    }

    @Step("Заполнение поля 'Пароль'")
    public void fillPasswordInput(String value) {
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(value);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(By.xpath(REGISTRATION_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public void clickRestorePasswordButton() {
        driver.findElement(By.xpath(RESTORE_PASSWORD_BUTTON)).click();
    }

}
