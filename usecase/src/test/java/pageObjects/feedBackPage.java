package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class feedBackPage extends BasePage {

    public feedBackPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//form/div[5]//button[text()='Complete']")
    WebElement completeButton;
    
    @FindBy(xpath="//form/div[4]/div/textarea[1]")
    WebElement summaryButton;
 
    @FindBy(xpath="//form/div[5]/div[2]/div/button")
    WebElement saveDraftButton;
  
    public void clickAllCheckboxes1() {
        List<WebElement> check1 = driver.findElements(By.xpath("//form/div[1]/div/div/label"));
        for (WebElement ch : check1) {
            System.out.println("Information Security Management System (ISMS)");
            ch.click();
        }
    }
    public void clickAllCheckboxes2() {
    	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/form/div[2]/div/div/label[3]/span[1]/input")).click();
    	List<WebElement> check1 = driver.findElements(By.xpath("//form/div[2]/div/div/label"));
    	for (WebElement ch : check1) {
    		System.out.println("Quality Management System (QMS)");
    		ch.click();
    	}
    }
    public void clickAllCheckboxes3() {
    	List<WebElement> check1 = driver.findElements(By.xpath("//form/div[3]/div/div/label"));
    	for (WebElement ch : check1) {
    		System.out.println("Quality Management System (QMS)");
    		ch.click();
    	}
    }
    
    public void writeSummary() {
    	summaryButton.sendKeys("Good Audit");
    }
    
    public void clickComplete() {
    	completeButton.click();
    	
    }
  
    public void saveDraft() {
    	saveDraftButton.click();
    	
    }
}
