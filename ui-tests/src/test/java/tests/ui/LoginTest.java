package test.java.tests.ui;

import main.java.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String actualText = loginPage.getLoginHeaderText();

        Assert.assertEquals(actualText, "Login to your account");

    }
}