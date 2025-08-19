package testCases;

import org.testng.annotations.Test;
import pageObjects.CreateAuditPage;
import testBase.BaseTest;

public class CreateAuditTest extends BaseTest {

    @Test
    public void testCreateAudit() throws InterruptedException {
        CreateAuditPage auditPage = new CreateAuditPage(driver);
        auditPage.enterAuditName("Internal Audit 897");
        auditPage.selectStartDate("08", "05", "2025");
        auditPage.selectEndDate("08", "10", "2025");
        auditPage.selectAuditor("Uma");
        auditPage.selectStakeholder("Krishnaraj");
        auditPage.selectOrganisation("Infosys Technology solution");
        System.out.println("Audit form filled");

        auditPage.clickCreate();
        Thread.sleep(3000);
        auditPage.clickOk();
        System.out.println("Audit Created and Confirmed");
    }
}
