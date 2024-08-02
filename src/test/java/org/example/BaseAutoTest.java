package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.object.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseAutoTest {
    public static final BrowserType browser = BrowserType.CHROME;
    public static final String USERNAME = "someUsername1235436";
    public static final String EMAIL = "someUsername1235436@ya.ru";
    public static final String PASSWORD = "somePassword234432";

    protected WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        TestUtils.deleteUser(USERNAME, PASSWORD, EMAIL);
    }

    @AfterClass
    public static void afterClass() {
        TestUtils.deleteUser(USERNAME, PASSWORD, EMAIL);
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        if (BrowserType.YANDEX.equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/resources/yandexdriver.exe");
        }

        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    protected void login(LoginPage loginPage) {
        loginPage.assertTitleisVisible();
        loginPage.fillEmailInput(EMAIL);
        loginPage.fillPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
    }

}
