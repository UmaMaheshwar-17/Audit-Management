package AuditCreate2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects1.CreateAuditPage1;
import pageObjects1.DashboardPage1;
import pageObjects1.LoginPage1;
import pageObjects1.RegisterPage1;
import testBase.BaseTest;

public class FullAuditFlowSplit1 {

    WebDriver driver;
    String auditorName,email, password, auditName;
    String startMM, startDD, startYYYY;
    String endMM, endDD, endYYYY;
    String auditor, stakeholder, organisation;

    public FullAuditFlowSplit1(String email, String password, String auditName, String startMM,
                              String startDD, String startYYYY, String endMM, String endDD, String endYYYY,
                              String auditor, String stakeholder, String organisation) {
    	
        this.email = email;
        this.password = password;
        this.auditName = auditName;
        this.startMM = startMM;
        this.startDD = startDD;
        this.startYYYY = startYYYY;
        this.endMM = endMM;
        this.endDD = endDD;
        this.endYYYY = endYYYY;
        this.auditor = auditor;
        this.stakeholder = stakeholder;
        this.organisation = organisation;
    }

    @BeforeClass
    public void setup() {
        driver = BaseTest.launchBrowser();
    }

  //  @Test
   // public void registerUser() throws InterruptedException {
  //      new RegisterPage1(driver).register(auditorName,email, password);
  //  }


    @Test(priority=1)
    public void loginUser() {
        new LoginPage1(driver).login(email, password);
    }

    @Test(dependsOnMethods = "loginUser")
    public void goToDashboard() {
        new DashboardPage1(driver).clickSchedule();
    }

    @Test(dependsOnMethods = "goToDashboard")
    public void createAudit() throws InterruptedException {
        CreateAuditPage1 auditPage = new CreateAuditPage1(driver);
        auditPage.enterAuditName(auditName);
        auditPage.selectStartDate(startMM, startDD, startYYYY);
        auditPage.selectEndDate(endMM, endDD, endYYYY);
        auditPage.selectAuditor(auditor);
        auditPage.selectStakeholder(stakeholder);
        auditPage.selectOrganisation(organisation);
        auditPage.clickCreate();
        Thread.sleep(2000);
        auditPage.clickOk();
        String expectedUrl = "http://localhost:5173/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Audit creation failed or incorrect redirection.");
        
    }

  //  @AfterClass
   // public void tearDown() throws InterruptedException {
    //    if (driver != null) {
    //        Thread.sleep(3000);
    //        driver.quit();
    //    }
   // }
}
