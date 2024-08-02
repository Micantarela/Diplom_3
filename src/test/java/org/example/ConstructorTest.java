package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.page.object.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseAutoTest {

    @Test
    @DisplayName("Transition to sauce section in constructor")
    @Description("Переход в раздел 'Соусы' в конструкторе")
    public void transitionToSauceSectionTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        boolean isBunsSectionSelected = mainPage.isSectionSelected(MainPage.BUNS_SECTION);
        Assert.assertTrue("Раздел 'Булки' не выбран", isBunsSectionSelected);

        mainPage.clickSauceSection();
        boolean isSauceSectionSelected = mainPage.isSectionSelected(MainPage.SAUCE_SECTION);
        Assert.assertTrue("Раздел 'Соусы' не выбран", isSauceSectionSelected);

        mainPage.assertSauceSectionTitleIsVisibile();
    }

    @Test
    @DisplayName("Transition to fillings section in constructor")
    @Description("Переход в раздел 'Начинки' в конструкторе")
    public void transitionToFillingsSectionTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        boolean isBunsSectionSelected = mainPage.isSectionSelected(MainPage.BUNS_SECTION);
        Assert.assertTrue("Раздел 'Булки' не выбран", isBunsSectionSelected);

        mainPage.clickFillingSection();
        boolean isFillingsSectionSelected = mainPage.isSectionSelected(MainPage.FILLINGS_SECTION);
        Assert.assertTrue("Раздел 'Начинки' не выбран", isFillingsSectionSelected);

        mainPage.assertFillingsSectionTitleIsVisibile();
    }

    @Test
    @DisplayName("Transition to buns section in constructor")
    @Description("Переход в раздел 'Булки' в конструкторе")
    public void transitionToBunsSectionTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        boolean isBunsSectionSelected = mainPage.isSectionSelected(MainPage.BUNS_SECTION);
        Assert.assertTrue("Раздел 'Булки' не выбран", isBunsSectionSelected);

        mainPage.clickFillingSection();
        boolean isFillingsSectionSelected = mainPage.isSectionSelected(MainPage.FILLINGS_SECTION);
        Assert.assertTrue("Раздел 'Начинки' не выбран", isFillingsSectionSelected);

        mainPage.clickBunsSection();
        isBunsSectionSelected = mainPage.isSectionSelected(MainPage.BUNS_SECTION);
        Assert.assertTrue("Раздел 'Булки' не выбран", isBunsSectionSelected);

        mainPage.assertBunsSectionTitleIsVisibile();
    }


}
