package pageObjects1;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BasePage;

public class LoginPage1 extends BasePage {

    public LoginPage1(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/form/div/div/div[1]/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/form/div/div/div[2]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Email
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);

        // Password
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        // Login Button
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
