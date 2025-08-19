package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAuditPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class TC_AuditCreate {
	 public static WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("http://localhost:5173/register");
	        driver.manage().window().maximize();
	        System.out.println("Browser launched");
	    }
	    
	    @Test
	    public void testAuditEndToEndFlow() throws InterruptedException {
	        // 1. Register
	        RegisterPage registerPage = new RegisterPage(driver);
	        registerPage.register("umaMaheshwar1@gmail.com", "umaM@123");

	        // 2. Login
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("umaMaheshwar1@gmail.com", "umaM@123");

	        // 3. Dashboard
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.clickSchedule();

	        // 4. Create Audit
	        CreateAuditPage auditPage = new CreateAuditPage(driver);
	        auditPage.enterAuditName("Internal Audit 20");
	        auditPage.selectStartDate("08", "05", "2025");
	        auditPage.selectEndDate("08", "10", "2025");
	        auditPage.selectAuditor("/html/body/div/div/div/div[2]/form/div/div[2]/div/div[3]/div[2]/div/ul/li[1]");
	        auditPage.selectStakeholder("/html/body/div/div/div/div[2]/form/div/div[2]/div/div[6]/div[2]/div/ul/li[1]");
	        auditPage.selectOrganisation("/html/body/div/div/div/div[2]/form/div/div[2]/div/div[7]/div[2]/div/ul/li");
	        // 5. Click Create
	        auditPage.clickCreate();
	        Thread.sleep(7000);      
	        
	        auditPage.clickOk();

	        System.out.println(" Audit created successfully .");
	    }
	    
	    

	  //  @AfterSuite
	   // public void tearDown() {
	   //     driver.quit();
	   //     System.out.println("Browser closed");
	  //  }

}
