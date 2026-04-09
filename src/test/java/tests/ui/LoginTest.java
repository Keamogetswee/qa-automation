package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        List<Map<String, String>> data = JsonReader.getTestData("testdata.json");

        Object[][] result = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i).get("email");
            result[i][1] = data.get(i).get("password");
        }

        return result;
    }

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String actualText = loginPage.getLoginHeaderText();

        Assert.assertEquals(actualText, "Login to your account");

    }

    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String email, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        loginPage.clickLoginButton();

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains("incorrect"));
    }
}