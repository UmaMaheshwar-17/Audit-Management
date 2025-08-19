package pageObjects1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class DashboardPage1 extends BasePage {

    public DashboardPage1(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Schedule']")
    WebElement scheduleButton;

    public void clickSchedule() {
        scheduleButton.click();
    }
}