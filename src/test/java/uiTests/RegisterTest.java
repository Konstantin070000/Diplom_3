package uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseUiTest {

    @Test
    @DisplayName("Успешная регистрация с валидным паролем")
    @Description("Проверяем, что пользователь может успешно зарегистрироваться с корректным паролем")
    public void registerWithValidPasswordShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        String email = "test" + System.currentTimeMillis() + "@mail.com";

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.register("TestUser", email, "password123");

        assertTrue(driver.getPageSource().contains("Войти"));
    }

    @Test
    @DisplayName("Ошибка при регистрации с коротким паролем")
    @Description("Проверяем, что при вводе короткого пароля отображается сообщение об ошибке")
    public void registerWithShortPasswordShouldShowError() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        String email = "test" + System.currentTimeMillis() + "@mail.com";

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.register("TestUser", email, "12345");

        assertTrue(registerPage.isPasswordErrorDisplayed());
    }
}