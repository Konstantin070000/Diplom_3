package uiTests;

import client.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.LoginData;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseUiTest {

    private final UserClient userClient = new UserClient();
    private String registeredEmail;
    private String registeredPassword;
    private String accessToken;

    @Test
    @DisplayName("Успешная регистрация с валидным паролем")
    @Description("Проверяем, что пользователь может успешно зарегистрироваться с корректным паролем")
    public void registerWithValidPasswordShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        registeredEmail = "test" + System.currentTimeMillis() + "@mail.com";
        registeredPassword = "password123";

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.register("TestUser", registeredEmail, registeredPassword);

        assertTrue(driver.getPageSource().contains("Войти"));

        Response loginResponse = userClient.loginUser(new LoginData(registeredEmail, registeredPassword));
        accessToken = loginResponse.jsonPath().getString("accessToken");
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

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}