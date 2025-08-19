package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

import java.time.Duration;

public class completedAuditsPage extends BasePage {

    public completedAuditsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/button")
    WebElement ExportButton;

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickExport() {
        getWait().until(ExpectedConditions.elementToBeClickable(ExportButton));
        ExportButton.click();
        System.out.println("✅ Export button clicked.");
    }
}
