package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class CreateAuditPage extends BasePage {

    public CreateAuditPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[2]/div/div/input")
    WebElement auditNameInput;

    @FindBy(xpath = "//div[5]//div[1]//div[1]//div[1]")
    WebElement startDateBox;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[4]/div/div/div[1]/span[1]/span[2]")
    WebElement monthField;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[4]/div/div/div[1]/span[2]/span[2]")
    WebElement dayField;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[4]/div/div/div[1]/span[3]/span[2]")
    WebElement yearField;

    @FindBy(xpath = "//div[6]//div[1]//div[1]//div[1]")
    WebElement endDateBox;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[5]/div/div/div[1]/span[1]/span[2]")
    WebElement endMonthField;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[5]/div/div/div[1]/span[2]/span[2]")
    WebElement endDayField;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[5]/div/div/div[1]/span[3]/span[2]")
    WebElement endYearField;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[3]/div/div/div/input")
    WebElement auditorDropdownButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[6]/div/div/div/input")
    WebElement stakeholderDropdownButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[7]/div/div/div/input")
    WebElement organisationDropdownButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/div/div[2]/div/div[8]/div/button[2]")
    WebElement createButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/button[2]")
    WebElement okBtn;

    // Actions

    public void enterAuditName(String name) {
        auditNameInput.sendKeys(name);
    }

    public void selectStartDate(String mm, String dd, String yyyy) {
        selectDate(startDateBox, monthField, dayField, yearField, mm, dd, yyyy);
    }

    public void selectEndDate(String mm, String dd, String yyyy) {
        selectDate(endDateBox, endMonthField, endDayField, endYearField, mm, dd, yyyy);
    }

    public void selectAuditor(String optionText) throws InterruptedException {
        selectDropdownOptionByText(auditorDropdownButton, "//ul[@role='listbox']/li", optionText);
    }

    public void selectStakeholder(String optionText) throws InterruptedException {
        selectDropdownOptionByText(stakeholderDropdownButton, "//ul[@role='listbox']/li", optionText);
    }

    public void selectOrganisation(String optionText) throws InterruptedException {
        selectDropdownOptionByText(organisationDropdownButton, "//ul[@role='listbox']/li", optionText);
    }

    public void clickCreate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void clickOk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
    }

    // Helpers

    private void selectDate(WebElement dateBox, WebElement month, WebElement day, WebElement year,
                            String mm, String dd, String yyyy) {
        dateBox.click();
        clearAndType(month, mm);
        clearAndType(day, dd);
        clearAndType(year, yyyy);
    }

    private void clearAndType(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void selectDropdownOptionByText(WebElement dropdown, String optionsXPath, String textToSelect) throws InterruptedException {
        dropdown.click();
        Thread.sleep(3000); // You can replace this with wait for dropdown to load if needed

        List<WebElement> options = driver.findElements(By.xpath(optionsXPath));
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(textToSelect.trim())) {
                option.click();
                break;
            }
        }
    }
}
