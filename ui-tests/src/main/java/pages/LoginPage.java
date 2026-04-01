package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By loginLink = By.linkText("Signup / Login");
    By loginHeader = By.xpath("//h2[text()='Login to your account']");

    // Actions
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public String getLoginHeaderText() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginHeader)
        ).getText();
    }
}