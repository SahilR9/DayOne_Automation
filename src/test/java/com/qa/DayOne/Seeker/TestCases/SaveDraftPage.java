package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.*;
import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaveDraftPage extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardpage;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;

    OppPage oppPage;
    DraftOppPage draftOppPage;
    SoftAssert softAssert;

    Map<String, String> testData;


    public  SaveDraftPage(){

    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialisation();

        loginPage = new LoginPage();
        dashboardpage = loginPage.login(pr.getProperty("email"), pr.getProperty("password"));
        backgroundPage = new BackgroundPage();
        valuesPage = new ValuesPage();
        oppPage = new OppPage();
        draftOppPage = new DraftOppPage();
        softAssert = new SoftAssert();

        // Load test data from config.properties using pr.getProperty()
        testData = new LinkedHashMap<>();
        String currentDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dynamicTitle = pr.getProperty("opptitle").replace("${currentDateTime}", currentDateTime);
        testData.put("title", dynamicTitle);
        testData.put("locationEdit", pr.getProperty("locationEdit"));
        testData.put("opportunityTypeEdit", pr.getProperty("opportunityTypeEdit"));
        testData.put("workShiftEdit", pr.getProperty("workShiftEdit"));
        testData.put("workArrangementEdit", pr.getProperty("workArrangementEdit"));
        testData.put("workHoursEdit", pr.getProperty("workHoursEdit"));
        testData.put("skill1Edit", pr.getProperty("skill1"));
        testData.put("skill2Edit", pr.getProperty("skill2"));
        testData.put("contactNameEdit", pr.getProperty("contactNameEdit"));
        testData.put("contactEmailEdit", pr.getProperty("contactEmailEdit"));
        testData.put("opportunityDurationEdit", pr.getProperty("opportunityDurationEdit"));
        testData.put("totalPositionsEdit", pr.getProperty("totalPositionsEdit"));
        testData.put("jobDescriptionEdit", pr.getProperty("jobDescriptionEdit"));
        testData.put("listOfResponsibilitiesEdit", pr.getProperty("listOfResponsibilitiesEdit"));
        testData.put("salaryFromEdit", pr.getProperty("salaryFromEdit"));
        testData.put("salaryToEdit", pr.getProperty("salaryToEdit"));
        testData.put("numberOfHolidaysEdit", pr.getProperty("numberOfHolidaysEdit"));
        testData.put("benefit1Edit", pr.getProperty("benefit1"));
        testData.put("benefit2Edit", pr.getProperty("benefit2"));
        testData.put("qualification1Edit", pr.getProperty("qualification1Edit"));
        testData.put("qualification2Edit", pr.getProperty("qualification2Edit"));
        testData.put("qualificationStage1Edit", pr.getProperty("qualificationStage1Edit"));
        testData.put("additionalCommentsEdit", pr.getProperty("additionalCommentsEdit"));



    }

    @Test(priority = 1)
    public void verifyEditDraftPageTest(){
        draftOppPage = dashboardpage.clickOnDraftOpportunity();
        String titleBackground = draftOppPage.verifyDraftPageTitle();
        softAssert.assertEquals(titleBackground, "Day One", "Login page title matches!");

        draftOppPage.clickOnDraftOpp(TestUtils.opportunityName);
        draftOppPage.clickOnEditDraft();
        boolean saveDraftButtonDisplay = oppPage.verifySaveasDraftButton();
        softAssert.assertTrue(saveDraftButtonDisplay, "Save as Draft button is not visible");

        draftOppPage.clickeditTitle();

        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "title":
                    oppPage.enterTitle(expectedValue);
                    softAssert.assertEquals(oppPage.getTitle(), expectedValue, "Title input field did not match!");
                    oppPage.titleClick();
                    break;

                case "opportunityTypeEdit":
                    oppPage.selectOpportunityType(expectedValue);
                    softAssert.assertTrue(oppPage.getOppTypeRadio().isSelected(), "Opportunity Type Radio button not selected");
                    break;
                case "workShiftEdit":
                    oppPage.selectWorkShift(expectedValue);
                    softAssert.assertTrue(oppPage.getWorkShiftRadio().isSelected(), "Work Shift Radio button not selected");
                    break;
                case "workArrangementEdit":
                    oppPage.selectWorkArrangement(expectedValue);
                    softAssert.assertTrue(oppPage.getWorkArrangementRadio().isSelected(), "Work Arrangement Radio button not selected");
                    break;
                case "workHoursEdit":
                    oppPage.selectWorkHours(expectedValue);
                    softAssert.assertTrue(oppPage.getWorkHoursRadio().isSelected(), "Work Hours Radio button not selected");
                    break;

                case "contactNameEdit":
                    oppPage.enterContactName(expectedValue);
                    softAssert.assertEquals(oppPage.getContactName(), expectedValue, "Contact name input field did not match!");
                    break;
                case "contactEmailEdit":
                    oppPage.enterContactEmail(expectedValue);
                    softAssert.assertEquals(oppPage.getContactEmail(), expectedValue, "Contact email input field did not match!");
                    break;
                case "opportunityDurationEdit":
                    oppPage.enterOpportunityDuration(expectedValue);
                    softAssert.assertEquals(oppPage.getOpportunityDuration(), expectedValue, "Opportunity duration did not match!");
                    break;
                case "totalPositionsEdit":
                    oppPage.enterTotalPositions(expectedValue);
                    softAssert.assertEquals(oppPage.getTotalPositions(), expectedValue, "Total positions did not match!");
                    break;
                case "jobDescriptionEdit":
                    oppPage.enterJobDescription(expectedValue);
                    softAssert.assertEquals(oppPage.getJobDescription(), expectedValue, "Job description did not match!");
                    break;
                case "listOfResponsibilitiesEdit":
                    oppPage.enterListOfResponsibilities(expectedValue);
                    softAssert.assertEquals(oppPage.getListOfResponsibilities(), expectedValue, "Responsibilities list did not match!");
                    break;
                case "salaryFromEdit":
                    oppPage.enterSalaryFrom(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryFrom(), expectedValue, "Salary from input did not match!");
                    break;
                case "salaryToEdit":
                    oppPage.enterSalaryTo(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryTo(), expectedValue, "Salary to input did not match!");
                    oppPage.checkBonus();
                    softAssert.assertTrue(oppPage.getBonusCheckDisplay(), "Bonus is checked!");
                    break;
                case "numberOfHolidaysEdit":
                    oppPage.enterNumberOfHolidays(expectedValue);
                    softAssert.assertEquals(oppPage.getNumberOfHolidays(), expectedValue, "No of holidays did not match!");
                    oppPage.checkExpense();
                    softAssert.assertTrue(oppPage.getExpensesCheck(), "Expense is checked!");
                    break;

                case "qualification1Edit":
                    oppPage.enterFirstQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getFirstQualification(), expectedValue, "First qualification did not match!");
                    break;
                case "qualification2Edit":
                    oppPage.enterSecondQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getSecondQualification(), expectedValue, "Second qualification did not match!");
                    break;
                case "qualificationStage1Edit":
                    oppPage.enterStage1Qualification(expectedValue);
                    softAssert.assertEquals(oppPage.getStage1Qualification(), expectedValue, "Stage 1 qualification did not match!");
                    break;
                case "additionalCommentsEdit":
                    oppPage.enterAdditionalComments(expectedValue);
                    softAssert.assertEquals(oppPage.getAdditionalComments(), expectedValue, "Additional comments did not match!");
                    break;
                default:
                    System.out.println("No action defined for field: " + fieldKey);
                    break;
            }
        }



        // Step 9: Publish Opportunity
        oppPage.clickPublish();

        String dashboartitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboartitle, "Day One", "DashboardPage title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        boolean oppcreatetoast = dashboardpage.verifyOppCreatedToast();
        softAssert.assertTrue(oppcreatetoast, "Opp Create Toast is not visible");

        boolean darftButtonVisible = dashboardpage.verifyDraftButtonVisible();
        softAssert.assertTrue(darftButtonVisible, "Draft Button is not visible");




        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
