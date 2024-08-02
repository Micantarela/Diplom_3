package org.example.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public static final String PERSONAL_CABINET_HEADER_BUTTON = ".//p[text()='Личный Кабинет']";
    public static final String LOGIN_TO_ACCOUNT_BUTTON = ".//button[text()='Войти в аккаунт']";
    public static final String MAKE_ORDER_BUTTON = ".//button[text()='Оформить заказ']";
    public static final String BUNS_SECTION = ".//div[span[text()='Булки']]";
    public static final String BUNS_SECTION_TITLE = ".//h2[text()='Булки']";
    public static final String FILLINGS_SECTION = ".//div[span[text()='Начинки']]";
    public static final String FILLINGS_SECTION_TITLE = ".//h2[text()='Начинки']";
    public static final String SAUCE_SECTION = ".//div[span[text()='Соусы']]";
    public static final String SAUCE_SECTION_TITLE = ".//h2[text()='Соусы']";
    public static final String CREATE_BURGER_TITLE = ".//h1[text()='Соберите бургер']";
    public static final String CONSTRUCTOR_HEADER_BUTTON = ".//p[text()='Конструктор']";
    public static final String LOGO = ".//div[@class='AppHeader_header__logo__2D0X2']";
    public static final String CHEESE = ".//p[text()='Сыр с астероидной плесенью']";

    public static final String ENABLED_SECTION_CLASS = "tab_tab_type_current__2BEPc";

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на главную страницу сайта")
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Проверка, что отображается кнопка 'Личный кабинет'")
    public void assertPersonalCabinetButtonIsVisible() {
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PERSONAL_CABINET_HEADER_BUTTON)));
    }

    @Step("Проверка, что отображается кнопка 'Оформить заказ'")
    public void assertMakeOrderButtonIsVisible() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAKE_ORDER_BUTTON)));
    }

    @Step("Проверка, что отображается кнопка 'Войти в аккаунт'")
    public void assertLoginToAccountButtonIsVisible() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_TO_ACCOUNT_BUTTON)));
    }

//    Проверка, что отображается раздел конструктора 'Булки'
    @Step("Проверка, что отображается заголовок 'Соберите бургер'")
    public void assertCreateBurgerTitleIsVisible() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_BURGER_TITLE)));
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalCabinetButton() {
        driver.findElement(By.xpath(PERSONAL_CABINET_HEADER_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginToAccountButton() {
        driver.findElement(By.xpath(LOGIN_TO_ACCOUNT_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(By.xpath(CONSTRUCTOR_HEADER_BUTTON)).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        driver.findElement(By.xpath(LOGO)).click();
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBunsSection() {
        driver.findElement(By.xpath(BUNS_SECTION)).click();
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSauceSection() {
        driver.findElement(By.xpath(SAUCE_SECTION)).click();
    }

    @Step("Клик по разделу 'Начинки'")
    public void clickFillingSection() {
        driver.findElement(By.xpath(FILLINGS_SECTION)).click();
    }

    @Step("Проверка, что отображается раздел конструктора 'Булки'")
    public void assertBunsSectionTitleIsVisibile() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUNS_SECTION_TITLE)));
    }

    @Step("Проверка, что отображается раздел конструктора 'Соусы'")
    public void assertSauceSectionTitleIsVisibile() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAUCE_SECTION_TITLE)));
    }

    @Step("Проверка, что отображается раздел конструктора 'Начинки'")
    public void assertFillingsSectionTitleIsVisibile() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILLINGS_SECTION_TITLE)));
    }

    @Step("Проверка того, что выбран раздел конструктора {section}")
    public boolean isSectionSelected(String section) {
        String classProp = driver.findElement(By.xpath(section)).getAttribute("class");
        return classProp != null && classProp.contains(ENABLED_SECTION_CLASS);
    }

}

