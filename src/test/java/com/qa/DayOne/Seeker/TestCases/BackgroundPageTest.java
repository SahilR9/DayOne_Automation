package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.*;
import com.qa.DayOne.Seeker.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BackgroundPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardpage;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;
    SoftAssert softAssert;

    Map<String, String> testData;


    public  BackgroundPageTest(){

    }


    private Map<String, String> loadTestData() {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("companyStory", pr.getProperty("companyStory"));
        data.put("products", pr.getProperty("products"));
        data.put("customerHelp", pr.getProperty("customerHelp"));
        data.put("uniqueFeature", pr.getProperty("uniqueFeature"));
        data.put("awardTitle", pr.getProperty("awardTitle"));
        data.put("awardIssueDate", pr.getProperty("awardIssueDate"));
        data.put("awardDescription", pr.getProperty("awardDescription"));
        data.put("linkedInUrl", pr.getProperty("linkedInUrl"));
        data.put("xUrl", pr.getProperty("xUrl"));
        data.put("facebookUrl", pr.getProperty("facebookUrl"));
        data.put("instagramUrl", pr.getProperty("instagramUrl"));
        data.put("tiktokUrl", pr.getProperty("tiktokUrl"));
        return data;
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialisation();

        loginPage = new LoginPage();
        dashboardpage = loginPage.login(pr.getProperty("email"), pr.getProperty("password"));
        backgroundPage = new BackgroundPage();
        valuesPage = new ValuesPage();
        softAssert = new SoftAssert();


        // Load test data into HashMap
        testData = loadTestData();


    }

    @Test(priority = 1)
    public void verifyBackgroundPageFormFillupTest() {

        backgroundPage = dashboardpage.clickOnBackgroundPage();
        String title = backgroundPage.verifyBackgroundPageTitle();
        softAssert.assertEquals(title, "Day One - Background", "Login page title matches!");


        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "companyStory":
                    backgroundPage.fillCompanyStory(expectedValue);
                    softAssert.assertEquals(backgroundPage.getCompanyStory(), expectedValue, "Co smatch!");
                    break;
                case "products":
                    backgroundPage.fillProducts(expectedValue);
                    softAssert.assertEquals(backgroundPage.getProducts(), expectedValue, "Products mismatch!");
                    break;
                case "customerHelp":
                    backgroundPage.fillCustomerHelp(expectedValue);
                    softAssert.assertEquals(backgroundPage.getCustomerHelp(), expectedValue, "Customer Help mismatch!");
                    break;
                case "uniqueFeature":
                    backgroundPage.fillUniqueFeature(expectedValue);
                    softAssert.assertEquals(backgroundPage.getUniqueFeature(), expectedValue, "Unique Feature mismatch!");
                    break;
                case "awardTitle":
                    backgroundPage.fillAwardTitle(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardTitle(), expectedValue, "Award Title mismatch!");
                    break;
                case "awardIssueDate":
                    backgroundPage.fillAwardIssueDate(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardIssueDate(), expectedValue, "Award Issue Date mismatch!");
                    break;
                case "awardDescription":
                    backgroundPage.fillAwardDescription(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardDescription(), expectedValue, "Award Description mismatch!");
                    break;
                case "linkedInUrl":
                    backgroundPage.fillLinkedIn(expectedValue);
                    softAssert.assertEquals(backgroundPage.getLinkedInUrl(), expectedValue, "LinkedIn URL mismatch!");
                    break;
                case "xUrl":
                    backgroundPage.fillX(expectedValue);
                    softAssert.assertEquals(backgroundPage.getXUrl(), expectedValue, "X URL mismatch!");
                    break;
                case "facebookUrl":
                    backgroundPage.fillFacebook(expectedValue);
                    softAssert.assertEquals(backgroundPage.getFacebookUrl(), expectedValue, "Facebook URL mismatch!");
                    break;
                case "instagramUrl":
                    backgroundPage.fillInstagram(expectedValue);
                    softAssert.assertEquals(backgroundPage.getInstagramUrl(), expectedValue, "Instagram URL mismatch!");
                    break;
                case "tiktokUrl":
                    backgroundPage.fillTiktok(expectedValue);
                    softAssert.assertEquals(backgroundPage.getTiktokUrl(), expectedValue, "TikTok URL mismatch!");
                    break;
                default:
                    System.out.println("No action defined for key: " + fieldKey);
            }
            softAssert.assertAll();

        }
    }

    @Test(priority = 2)

        public void verifyBackgroundPageFormAndNaviagteValuesTest() {

        backgroundPage = dashboardpage.clickOnBackgroundPage();
        String title = backgroundPage.verifyBackgroundPageTitle();
        softAssert.assertEquals(title, "Day One - Background", "Login page title matches!");


        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "companyStory":
                    backgroundPage.fillCompanyStory(expectedValue);
                    softAssert.assertEquals(backgroundPage.getCompanyStory(), expectedValue, "Company Story mismatch!");
                    break;
                case "products":
                    backgroundPage.fillProducts(expectedValue);
                    softAssert.assertEquals(backgroundPage.getProducts(), expectedValue, "Products mismatch!");
                    break;
                case "customerHelp":
                    backgroundPage.fillCustomerHelp(expectedValue);
                    softAssert.assertEquals(backgroundPage.getCustomerHelp(), expectedValue, "Customer Help mismatch!");
                    break;
                case "uniqueFeature":
                    backgroundPage.fillUniqueFeature(expectedValue);
                    softAssert.assertEquals(backgroundPage.getUniqueFeature(), expectedValue, "Unique Feature mismatch!");
                    break;
                case "awardTitle":
                    backgroundPage.fillAwardTitle(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardTitle(), expectedValue, "Award Title mismatch!");
                    break;
                case "awardIssueDate":
                    backgroundPage.fillAwardIssueDate(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardIssueDate(), expectedValue, "Award Issue Date mismatch!");
                    break;
                case "awardDescription":
                    backgroundPage.fillAwardDescription(expectedValue);
                    softAssert.assertEquals(backgroundPage.getAwardDescription(), expectedValue, "Award Description mismatch!");
                    break;
                case "linkedInUrl":
                    backgroundPage.fillLinkedIn(expectedValue);
                    softAssert.assertEquals(backgroundPage.getLinkedInUrl(), expectedValue, "LinkedIn URL mismatch!");
                    break;
                case "xUrl":
                    backgroundPage.fillX(expectedValue);
                    softAssert.assertEquals(backgroundPage.getXUrl(), expectedValue, "X URL mismatch!");
                    break;
                case "facebookUrl":
                    backgroundPage.fillFacebook(expectedValue);
                    softAssert.assertEquals(backgroundPage.getFacebookUrl(), expectedValue, "Facebook URL mismatch!");
                    break;
                case "instagramUrl":
                    backgroundPage.fillInstagram(expectedValue);
                    softAssert.assertEquals(backgroundPage.getInstagramUrl(), expectedValue, "Instagram URL mismatch!");
                    break;
                case "tiktokUrl":
                    backgroundPage.fillTiktok(expectedValue);
                    softAssert.assertEquals(backgroundPage.getTiktokUrl(), expectedValue, "TikTok URL mismatch!");
                    break;
                default:
                    System.out.println("No action defined for key: " + fieldKey);
            }
        }

            valuesPage = backgroundPage.backgroundContinue();
            String title1 = valuesPage.verifyValuesPageTitle();
            softAssert.assertEquals(title1, "Day One - Values", "Values Page Title didn't match!");

            boolean valuesButton = valuesPage.verifyValuesButton();
            softAssert.assertTrue(valuesButton, "Dashboard button is not visible");



        softAssert.assertAll();



    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
