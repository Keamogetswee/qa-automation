package test.java.tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.pages.LoginPage;

public class LoginTest {

    @Test
    public void openLoginPage() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String actualText = loginPage.getLoginHeaderText();

        Assert.assertEquals(actualText, "Login to your account");

        driver.quit();
    }
}