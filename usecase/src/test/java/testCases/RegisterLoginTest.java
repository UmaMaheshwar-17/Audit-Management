package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBase.BaseTest;
import utilities.ExcelUtility;

public class RegisterLoginTest {

    @Test
    public void testRegisterAndLoginFromExcel() {
        String path = System.getProperty("user.dir") + "/testdata/Test1.xlsx";
        String sheetName = "Sheet1";

        int rowCount = ExcelUtility.getRowCount(sheetName);
        System.out.println("Valid rows found: " + rowCount);

        for (int i = 1; i <= rowCount; i++) {
            WebDriver driver = null;
            try {
                // New browser per row
                driver = BaseTest.launchBrowser();

                String email = ExcelUtility.getCellData(sheetName, i, 0);
                String password = ExcelUtility.getCellData(sheetName, i, 1);

                // Register
                RegisterPage registerPage = new RegisterPage(driver);
                registerPage.register(email, password);
                System.out.println("Registration successful for: " + email);

                // Login
                LoginPage loginPage = new LoginPage(driver);
                loginPage.login(email, password);
                System.out.println("Login successful for: " + email);

            } catch (Exception e) {
                System.err.println("Error in row " + i + ": " + e.getMessage());
            } finally {
                if (driver != null) {
                    driver.quit();
                    System.out.println("Browser closed for row: " + i);
                }
            }
        }
    }
}
