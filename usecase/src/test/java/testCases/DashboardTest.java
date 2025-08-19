package testCases;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import testBase.BaseTest;

public class DashboardTest extends BaseTest {

    @Test
    public void testNavigateToAuditPage() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickSchedule();
        System.out.println("Navigated to Audit Schedule Page");
    }
}
