package test.java.tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void openLoginPage() {

        // 1. Launch browser
        WebDriver driver = new ChromeDriver();

        // 2. Open website
        driver.get("https://automationexercise.com/");

        // 3. Click Signup/Login
        driver.findElement(By.linkText("Signup / Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Get actual text
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"))).getText();

        // Expected text
        String expectedText = "Login to your account";
        Assert.assertEquals(actualText, expectedText, "Login page did not load correctly");

        // 4. Close browser
        driver.quit();
    }
}