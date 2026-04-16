package uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUiTest {

    private final String email = "testlogin@example.com";
    private final String password = "password123";

    @Test
    @DisplayName("Авторизация с главной страницы")
    @Description("Проверяем успешную авторизацию пользователя через кнопку входа на главной странице")
    public void loginFromMainPageButtonShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickLoginButton();
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    @DisplayName("Авторизация через Личный кабинет")
    @Description("Проверяем успешную авторизацию пользователя через кнопку Личный кабинет")
    public void loginFromPersonalAccountShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccountButton();
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    @DisplayName("Авторизация через страницу регистрации")
    @Description("Проверяем успешную авторизацию пользователя через переход со страницы регистрации")
    public void loginFromRegisterPageShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    @DisplayName("Авторизация через страницу восстановления пароля")
    @Description("Проверяем успешную авторизацию пользователя через переход со страницы восстановления пароля")
    public void loginFromForgotPasswordPageShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }
}