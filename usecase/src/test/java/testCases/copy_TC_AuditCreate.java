package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.CreateAuditPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utilities.dataProviders;

public class copy_TC_AuditCreate {

    public static WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateAuditPage auditPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:5173/register");
        driver.manage().window().maximize();
        System.out.println("Browser launched");

        // Initialize all page objects once
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        auditPage = new CreateAuditPage(driver);
    }

    @Test(priority = 1)
    public void testRegister() throws InterruptedException {
        registerPage.register("umaMaheshwar94@gmail.com", "umaM@123");
        System.out.println("Registration Successful");
    }

    @Test(priority = 2, dataProvider="LoginData",dataProviderClass=dataProviders.class)
    public void testLogin(String email,String pwd) throws InterruptedException {
        loginPage.login(email, pwd);
        System.out.println("Login Successful");
    }

    @Test(priority = 3)
    public void testGoToDashboard() {
        dashboardPage.clickSchedule();
        System.out.println("Navigated to Schedule/Audit Page");
    }

    @Test(priority = 4)
    public void testFillCreateAuditForm() throws InterruptedException {
        auditPage.enterAuditName("Internal Audit 87");
        auditPage.selectStartDate("08", "05", "2025");
        auditPage.selectEndDate("08", "10", "2025");
        auditPage.selectAuditor("Uma");         // Use visible text from the dropdown
        auditPage.selectStakeholder("Krishnaraj");   // Replace with actual dropdown text
        auditPage.selectOrganisation("Infosys Technology solution");   // Replace with actual dropdown text
        System.out.println("Audit form filled");
    }

    @Test(priority = 5)
    public void testClickCreateAndConfirm() throws InterruptedException {
        auditPage.clickCreate();
        Thread.sleep(7000);
        auditPage.clickOk();
        System.out.println("Audit Created and Confirmed");
    }

 //   @AfterClass
   // public void tearDown() {
    //    driver.quit();
    //    System.out.println("Browser closed");
   // }
}

