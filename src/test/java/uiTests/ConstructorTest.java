package uiTests;

import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseUiTest {

    @Test
    public void clickSaucesTabShouldSwitchToSaucesSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesTab();

        assertTrue(driver.getPageSource().contains("Соусы"));
    }

    @Test
    public void clickFillingsTabShouldSwitchToFillingsSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsTab();

        assertTrue(driver.getPageSource().contains("Начинки"));
    }

    @Test
    public void clickBunsTabShouldSwitchToBunsSection() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        assertTrue(driver.getPageSource().contains("Булки"));
    }
}