package uiTests;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseUiTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}