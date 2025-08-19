package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseTest;
import utilities.ExcelUtility;

public class fullTest {

    @Test
    public void testFullAuditFlowFromExcel() throws InterruptedException {
        String path = System.getProperty("user.dir") + "/testdata/Test1.xlsx";
        ExcelUtility.setExcelPath(path);
        String sheetName = "Sheet1";

        int rowCount = ExcelUtility.getRowCount(sheetName);
        System.out.println("Valid rows found: " + rowCount);

        for (int i = 1; i <= rowCount; i++) {
            WebDriver driver = null;
            try {
                driver = BaseTest.launchBrowser();

                // Read Excel data
                String email = ExcelUtility.getCellData(sheetName, i, 0);
                String password = ExcelUtility.getCellData(sheetName, i, 1);
                String auditName = ExcelUtility.getCellData(sheetName, i, 2);
                String startMM = ExcelUtility.getCellData(sheetName, i, 3);
                String startDD = ExcelUtility.getCellData(sheetName, i, 4);
                String startYYYY = ExcelUtility.getCellData(sheetName, i, 5);
                String endMM = ExcelUtility.getCellData(sheetName, i, 6);
                String endDD = ExcelUtility.getCellData(sheetName, i, 7);
                String endYYYY = ExcelUtility.getCellData(sheetName, i, 8);
                String auditor = ExcelUtility.getCellData(sheetName, i, 9);
                String stakeholder = ExcelUtility.getCellData(sheetName, i, 10);
                String organisation = ExcelUtility.getCellData(sheetName, i, 11);

                // Register
                RegisterPage registerPage = new RegisterPage(driver);
                registerPage.register(email, password);
                System.out.println("Registered: " + email);

                // Login
                LoginPage loginPage = new LoginPage(driver);
                loginPage.login(email, password);
                System.out.println("Logged in: " + email);

                // Go to Dashboard
                DashboardPage dashboardPage = new DashboardPage(driver);
                dashboardPage.clickSchedule();

                // Create Audit
                CreateAuditPage auditPage = new CreateAuditPage(driver);
                auditPage.enterAuditName(auditName);
                auditPage.selectStartDate(startMM, startDD, startYYYY);
                auditPage.selectEndDate(endMM, endDD, endYYYY);
                auditPage.selectAuditor(auditor);
                auditPage.selectStakeholder(stakeholder);
                auditPage.selectOrganisation(organisation);
                auditPage.clickCreate();
                Thread.sleep(2000); // Small wait for modal
                auditPage.clickOk();
                Thread.sleep(5000);

                System.out.println(" Audit created for: " + email);

            } catch (Exception e) {
                System.err.println("❌ Error in row " + i + ": " + e.getMessage());
            } finally {
                if (driver != null) {
                	Thread.sleep(4000);
                    driver.quit();
                    System.out.println("Browser closed for row: " + i);
                }
            }
        }
    }
}
