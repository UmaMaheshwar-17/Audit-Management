package testCases;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.dataProviders;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class)
    public void testLogin(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        System.out.println("Login Successful with email: " + email);
    }
}
