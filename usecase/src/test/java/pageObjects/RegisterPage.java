package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BasePage;

import java.time.Duration;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By emailLocator = By.xpath("//input[@id='«r0»']");
    private By passwordLocator = By.xpath("//input[@id='«r1»']");
    private By registerButtonLocator = By.xpath("//button[normalize-space()='Register']");
    private By loginButtonLocator = By.xpath("//button[normalize-space()='Login']");  // login button to wait for after registration

    public void register(String email, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
            emailField.clear();
            emailField.sendKeys(email);

            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
            passwordField.clear();
            passwordField.sendKeys(password);

            Thread.sleep(500);  // slight pause for UI stability
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonLocator));
            registerButton.click();

        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            System.out.println("Retrying RegisterPage due to: " + e.getMessage());
            Thread.sleep(1000);  // allow DOM to stabilize

            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
            emailField.clear();
            emailField.sendKeys(email);

            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
            passwordField.clear();
            passwordField.sendKeys(password);

            Thread.sleep(500);
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonLocator));
            registerButton.click();
        }

        // ✅ Wait for login page to load (important)
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        System.out.println("Login button detected");
    }
}
