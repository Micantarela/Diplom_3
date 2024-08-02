package org.example.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePasswordPage {

    public static final String TITLE = ".//h2[text()='Восстановление пароля']";
    public static final String LOGIN_BUTTON = ".//a[text()='Войти']";

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что отображается заголовок 'Восстановление пароля'")
    public void assertTitleIsVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE)));
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

}
