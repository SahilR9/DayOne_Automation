package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.*;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;



public class DashboardPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardpage;
    PastOppPage pastOpp;
    DraftOppPage draftOpp;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;
    OppPage oppPage;
    SoftAssert softAssert;



    public DashboardPageTest(){

    }




    @BeforeMethod
    public void setUp() throws IOException {
        initialisation();

        loginPage = new LoginPage();
        dashboardpage = loginPage.login(pr.getProperty("email"), pr.getProperty("password"));
        pastOpp = new PastOppPage();
        draftOpp = new DraftOppPage();
        backgroundPage = new BackgroundPage();
        valuesPage = new ValuesPage();
        oppPage = new OppPage();

        softAssert = new SoftAssert();

    }

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest(){
        String title = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(title, "Day One - Dashboard", "Dashboard page title didn't match!");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        String labelToCheck =pr.getProperty("labelName"); // Dynamic label value
        softAssert.assertTrue(dashboardpage.verifyLabelName(labelToCheck),
                "Label with name '" + labelToCheck + "' is not displayed.");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyPastOppClickTest(){

        pastOpp = dashboardpage.clickOnPastOpportunity();

        String pageTitle = pastOpp.verifyPastOppPageTitle();
        softAssert.assertEquals(pageTitle, "Day One - Dashboard", "Dashboard page title didn't match!");




    }

    @Test(priority = 3)
    public void verifyDraftOppClickTest(){
        draftOpp = dashboardpage.clickOnDraftOpportunity();
        String pageTitle = draftOpp.verifyDraftPageTitle();
        softAssert.assertEquals(pageTitle, "Day One - Dashboard", "Dashboard page title didn't match!");

    }

    @Test(priority = 4)
    public void verifyOppPageClickTest(){
        oppPage = dashboardpage.clickOnCreateNewOpp();
        String pageTitle = oppPage.verifyOppPageTitle();
        softAssert.assertEquals(pageTitle, "Day One - Create Opportunity", "Dashboard page title didn't match!");
    }

    @Test(priority = 6)
    public void verifyBackgroundPageClickTest(){
        backgroundPage = dashboardpage.clickOnBackgroundPage();
        String pageTitle = backgroundPage.verifyBackgroundPageTitle();
        softAssert.assertEquals(pageTitle, "Day One - Background", "Dashboard page title didn't match!");
    }

    @Test(priority = 7)
    public void verifyValuesPageClickTest(){
         valuesPage = dashboardpage.clickOnValuesPage();
        String pageTitle = valuesPage.verifyValuesPageTitle();
        softAssert.assertEquals(pageTitle, "Day One - Values", "Dashboard page title didn't match!");
    }






    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
