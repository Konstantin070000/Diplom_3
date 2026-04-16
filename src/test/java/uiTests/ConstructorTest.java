package uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseUiTest {

    @Test
    @DisplayName("Переход во вкладку Соусы")
    @Description("Проверяем, что при клике на вкладку Соусы отображается раздел Соусы")
    public void clickSaucesTabShouldSwitchToSaucesSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesTab();

        assertTrue(driver.getPageSource().contains("Соусы"));
    }

    @Test
    @DisplayName("Переход во вкладку Начинки")
    @Description("Проверяем, что при клике на вкладку Начинки отображается раздел Начинки")
    public void clickFillingsTabShouldSwitchToFillingsSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab();

        assertTrue(driver.getPageSource().contains("Начинки"));
    }

    @Test
    @DisplayName("Переход во вкладку Булки")
    @Description("Проверяем, что при клике на вкладку Булки отображается раздел Булки")
    public void clickBunsTabShouldSwitchToBunsSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        assertTrue(driver.getPageSource().contains("Булки"));
    }
}