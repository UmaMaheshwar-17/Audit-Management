package testCases;

import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import testBase.BaseTest;
import utilities.dataProviders;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class)
    public void testRegister(String email, String password) throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(email, password);
        System.out.println("Registration Successful with email: " + email);
    }
}
