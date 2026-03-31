package test.java.tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void openLoginPage() {

        // 1. Launch browser
        WebDriver driver = new ChromeDriver();

        // 2. Open website
        driver.get("https://automationexercise.com/");

        // 3. Click Signup/Login
        driver.findElement(By.linkText("Signup / Login")).click();

        // 4. Close browser
        driver.quit();
    }
}