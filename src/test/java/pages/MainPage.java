package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Переход во вкладку Булки")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Переход во вкладку Соусы")
    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Переход во вкладку Начинки")
    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }
}