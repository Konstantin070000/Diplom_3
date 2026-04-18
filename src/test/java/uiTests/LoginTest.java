package uiTests;

import client.UserClient;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.UserGenerator;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUiTest {

    private final UserClient userClient = new UserClient();
    private User user;
    private String accessToken;

    @Before
    public void setUpUser() {
        user = UserGenerator.getRandomUser();
        Response response = userClient.createUser(user);
        accessToken = response.jsonPath().getString("accessToken");
    }

    @Test
    public void loginFromMainPageButtonShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    public void loginFromPersonalAccountShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    public void loginFromRegisterPageShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @Test
    public void loginFromForgotPasswordPageShouldBeSuccessful() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(driver.getPageSource().contains("Конструктор"));
    }

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}