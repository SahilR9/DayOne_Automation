package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.DashboardPage;
import com.qa.DayOne.Seeker.Pages.LoginPage;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardpage;
    SoftAssert softAssert;



    public LoginPageTest(){

    }



    @BeforeMethod
    public void setUp() throws IOException {
        initialisation();

        loginPage = new LoginPage();
        softAssert = new SoftAssert();

    }

    @Test(priority = 1)
    public void loginPageTitle(){
        String title = loginPage.validateLoginPageTitle();
        softAssert.assertEquals(title, "Day One", "Login page title matches!");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException, IOException {
        dashboardpage = loginPage.login(pr.getProperty("email"), pr.getProperty("password"));
        String title = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(title, "Day One", "Login page title matches!");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
