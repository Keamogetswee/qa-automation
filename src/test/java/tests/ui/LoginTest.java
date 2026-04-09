package tests.ui;

import pages.LoginPage;
import utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String actualText = loginPage.getLoginHeaderText();

        Assert.assertEquals(actualText, "Login to your account");

    }

    @Test
    public void invalidLoginTest() {

        ConfigReader config = new ConfigReader();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("invalidEmail"));
        loginPage.enterPassword(config.getProperty("invalidPassword"));

        loginPage.clickLoginButton();

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains("incorrect"));
    }
}