package org.example.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCabinetPage {

    public static final String PROFILE_TITLE = ".//a[text()='Профиль']";
    public static final String LOGOUT_BUTTON = ".//button[text()='Выход']";

    private WebDriver driver;

    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что отображается раздел 'Профиль'")
    public void assertProfileTitleIsVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROFILE_TITLE)));
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(By.xpath(LOGOUT_BUTTON)).click();
    }

}
