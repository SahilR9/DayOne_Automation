package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.BackgroundPage;
import com.qa.DayOne.Seeker.Pages.DashboardPage;
import com.qa.DayOne.Seeker.Pages.LoginPage;
import com.qa.DayOne.Seeker.Pages.ValuesPage;
import com.qa.DayOne.Seeker.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValuesPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardpage;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;
    SoftAssert softAssert;

    Map<String, String> testData;


    public  ValuesPageTest(){

    }

    private Map<String, String> loadTestData() {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("value1", pr.getProperty("value1"));
        data.put("value2", pr.getProperty("value2"));
        data.put("thriveValue", pr.getProperty("thriveValue"));
        data.put("diversifyValue", pr.getProperty("diversifyValue"));
        data.put("supportValue", pr.getProperty("supportValue"));
        data.put("futureValue", pr.getProperty("futureValue"));
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
        dashboardpage = new DashboardPage();


        // Load test data into HashMap
        testData = loadTestData();

    }

    @Test(priority = 1)
    public void verifyFillValuesPageAndClickFinishTest(){

        valuesPage = dashboardpage.clickOnValuesPage();
        String titleBackground = valuesPage.verifyValuesPageTitle();
        softAssert.assertEquals(titleBackground, "Day One - Values", "Values page title didn't match!");


        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "value1":
                    valuesPage.selectCoreValues(expectedValue, testData.get("value2"));
                    softAssert.assertEquals(valuesPage.getValue1(expectedValue), expectedValue, "Core Value 1 mismatch!");
                    break;
                case "value2":
                    // Handled together with value1 in `selectCoreValues`, no need for a separate action here.
                    softAssert.assertEquals(valuesPage.getValue2(expectedValue), expectedValue, "Core Value 2 mismatch!");
                    break;
                case "thriveValue":
                    valuesPage.fillThrive(expectedValue);
                    softAssert.assertEquals(valuesPage.getThriveValue(), expectedValue, "Thrive value mismatch!");
                    break;
                case "diversifyValue":
                    valuesPage.fillDiversify(expectedValue);
                    softAssert.assertEquals(valuesPage.getDiversifyValue(), expectedValue, "Diversify value mismatch!");
                    break;
                case "supportValue":
                    valuesPage.fillSupport(expectedValue);
                    softAssert.assertEquals(valuesPage.getSupportValue(), expectedValue, "Support value mismatch!");
                    break;
                case "futureValue":
                    valuesPage.fillFuture(expectedValue);
                    softAssert.assertEquals(valuesPage.getFutureValue(), expectedValue, "Future value mismatch!");
                    break;
                default:
                    System.out.println("No action defined for key: " + fieldKey);
            }
        }

        valuesPage.clickFinishSetup();

        dashboardpage = valuesPage.clickGoToDashboard();


        String titleDashboard = dashboardpage.verifyDashboardPageTitle();

        softAssert.assertEquals(titleDashboard, "Day One - Dashboard", "Dashboard Page title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        softAssert.assertAll();






    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
