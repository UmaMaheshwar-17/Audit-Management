package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BasePage;
import java.time.Duration;

public class upComingAudits extends BasePage {

    public upComingAudits(WebDriver driver) {
        super(driver);
    }

    // Method to get the Audit button WebElement for a given audit name
    public WebElement getAuditButtonByAuditName(String auditName) {
        String xpath = "//div[@role='row'][div[contains(text(),'" + auditName + "')]]//a[normalize-space()='Audit']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    // Method to click the Audit button for a given audit name
    public void clickAuditButtonByAuditName(String auditName) {
        getAuditButtonByAuditName(auditName).click();
    }
}
