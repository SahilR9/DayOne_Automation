package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.*;
import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OppPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardpage;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;

    OppPage oppPage;
    SoftAssert softAssert;

    Map<String, String> testData;


    public  OppPageTest(){

    }

    private Map<String, String> loadTestData() {
        Map<String, String> data = new LinkedHashMap<>();
        String currentDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dynamicTitle = pr.getProperty("opptitle").replace("${currentDateTime}", currentDateTime);
        data.put("title", dynamicTitle);
        data.put("location", pr.getProperty("location"));
        data.put("opportunityType", pr.getProperty("opportunityType"));
        data.put("workShift", pr.getProperty("workShift"));
        data.put("workArrangement", pr.getProperty("workArrangement"));
        data.put("workHours", pr.getProperty("workHours"));
        data.put("skill1", pr.getProperty("skill1"));
        data.put("skill2", pr.getProperty("skill2"));
        data.put("contactName", pr.getProperty("contactName"));
        data.put("contactEmail", pr.getProperty("contactEmail"));
        data.put("opportunityDuration", pr.getProperty("opportunityDuration"));
        data.put("totalPositions", pr.getProperty("totalPositions"));
        data.put("jobDescription", pr.getProperty("jobDescription"));
        data.put("listOfResponsibilities", pr.getProperty("listOfResponsibilities"));
        data.put("salaryFrom", pr.getProperty("salaryFrom"));
        data.put("salaryTo", pr.getProperty("salaryTo"));
        data.put("numberOfHolidays", pr.getProperty("numberOfHolidays"));
        data.put("benefit1", pr.getProperty("benefit1"));
        data.put("benefit2", pr.getProperty("benefit2"));
        data.put("qualification1", pr.getProperty("qualification1"));
        data.put("qualification2", pr.getProperty("qualification2"));
        data.put("qualificationStage1", pr.getProperty("qualificationStage1"));
        data.put("additionalComments", pr.getProperty("additionalComments"));
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
        oppPage = new OppPage();

        // Load test data
        testData = loadTestData();


        TestUtils.opportunityName = testData.get("title"); // Assign value to the global variable



    }

    @Test(priority = 1)
    public void verifyFillOppPageTest() throws InterruptedException {

        String dashboardtitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboardtitle, "Day One - Dashboard", "Dashboard title didn't match!");

        oppPage = dashboardpage.clickOnCreateNewOpp();
        String oppPageTitleBackground = oppPage.verifyOppPageTitle();
        softAssert.assertEquals(oppPageTitleBackground, "Day One - Create Opportunity", "Opp page title didn't match!");



        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "title":
                    oppPage.enterTitle(expectedValue);
                    softAssert.assertEquals(oppPage.getTitle(), expectedValue, "Title input field did not match!");
                    oppPage.titleClick();
                    break;
                case "location":
                    oppPage.enterLocation(expectedValue);
                    softAssert.assertEquals(oppPage.getLocation(), expectedValue, "Location input field did not match!");
                    break;
                case "opportunityType":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement oppTypeRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(oppTypeRadio.isSelected(), "Opportunity Type Radio button not selected");
                    break;
                case "workShift":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkShiftRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkShiftRadio.isSelected(), "Work Shift Radio button not selected");
                    break;
                case "workArrangement":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkArrangementRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkArrangementRadio.isSelected(), "Work Arrangement Radio button not selected");
                    break;
                case "workHours":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkHoursRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkHoursRadio.isSelected(), "Work Hours Radio button not selected");
                    break;
                case "skill1":
                    oppPage.selectSkills(expectedValue, testData.get("skill2"));
                    softAssert.assertEquals(oppPage.getskillvalue1(expectedValue), expectedValue, "Core Value 1 mismatch!");
                    break;
                case "skill2":
                    softAssert.assertEquals(oppPage.getskillvalue2(expectedValue), expectedValue, "Skill 2 mismatch!");
                    break;
                case "contactName":
                    oppPage.enterContactName(expectedValue);
                    softAssert.assertEquals(oppPage.getContactName(), expectedValue, "Contact name input field did not match!");
                    break;
                case "contactEmail":
                    oppPage.enterContactEmail(expectedValue);
                    softAssert.assertEquals(oppPage.getContactEmail(), expectedValue, "Contact email input field did not match!");
                    break;
                case "opportunityDuration":
                    oppPage.enterOpportunityDuration(expectedValue);
                    softAssert.assertEquals(oppPage.getOpportunityDuration(), expectedValue, "Opportunity duration did not match!");
                    break;
                case "totalPositions":
                    oppPage.enterTotalPositions(expectedValue);
                    softAssert.assertEquals(oppPage.getTotalPositions(), expectedValue, "Total positions did not match!");
                    break;
                case "jobDescription":
                    oppPage.enterJobDescription(expectedValue);
                    softAssert.assertEquals(oppPage.getJobDescription(), expectedValue, "Job description did not match!");
                    break;
                case "listOfResponsibilities":
                    oppPage.enterListOfResponsibilities(expectedValue);
                    softAssert.assertEquals(oppPage.getListOfResponsibilities(), expectedValue, "Responsibilities list did not match!");
                    break;
                case "salaryFrom":
                    oppPage.enterSalaryFrom(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryFrom(), expectedValue, "Salary from input did not match!");
                    break;
                case "salaryTo":
                    oppPage.enterSalaryTo(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryTo(), expectedValue, "Salary to input did not match!");
                    oppPage.checkBonus();
                    softAssert.assertTrue(oppPage.getBonusCheckDisplay(), "Bonus is checked!");
                    break;
                case "numberOfHolidays":
                    oppPage.enterNumberOfHolidays(expectedValue);
                    softAssert.assertEquals(oppPage.getNumberOfHolidays(), expectedValue, "No of holidays did not match!");
                    oppPage.checkExpense();
                    softAssert.assertTrue(oppPage.getExpensesCheck(), "Expense is checked!");
                    break;
                case "benefit1":
                    oppPage.enterBenefits(expectedValue, testData.get("benefit2"));
                    softAssert.assertEquals(oppPage.getbenefitvalue1(expectedValue), expectedValue, "Benefit 1 mismatch!");
                    break;
                case "benefit2":
                    softAssert.assertEquals(oppPage.getbenefitvalue2(expectedValue), expectedValue, "Benefit 2 mismatch!");
                    break;
                case "qualification1":
                    oppPage.enterFirstQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getFirstQualification(), expectedValue, "First qualification did not match!");
                    break;
                case "qualification2":
                    oppPage.enterSecondQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getSecondQualification(), expectedValue, "Second qualification did not match!");
                    break;
                case "qualificationStage1":
                    oppPage.enterStage1Qualification(expectedValue);
                    softAssert.assertEquals(oppPage.getStage1Qualification(), expectedValue, "Stage 1 qualification did not match!");
                    break;
                case "additionalComments":
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
        softAssert.assertEquals(dashboartitle, "Day One - Dashboard", "DashboardPage title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        boolean oppcreatetoast = dashboardpage.verifyOppCreatedToast();
        softAssert.assertTrue(oppcreatetoast, "Opp Create Toast is not visible");

        boolean oppNameTest = dashboardpage.verifyOppName(TestUtils.opportunityName);
        softAssert.assertTrue(oppNameTest, "Opp Name is not visible");



        softAssert.assertAll();
    }

    @Test(priority = 2, enabled = false)
    public void  verifyFillOppPageAfterCreateTest() throws InterruptedException {

        String dashboardtitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboardtitle, "Day One - Dashboard", "Dashboard title didn't match!");

        oppPage = dashboardpage.clickOnCreateNewOpp();
        String oppPageTitleBackground = oppPage.verifyOppPageTitle();
        softAssert.assertEquals(oppPageTitleBackground, "Day One - Create Opportunity", "Opp page title didn't match!");


        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "title":
                    oppPage.enterTitle(expectedValue);
                    softAssert.assertEquals(oppPage.getTitle(), expectedValue, "Title input field did not match!");
                    oppPage.titleClick();
                    break;
                case "location":
                    oppPage.enterLocation(expectedValue);
                    softAssert.assertEquals(oppPage.getLocation(), expectedValue, "Location input field did not match!");
                    break;
                case "opportunityType":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement oppTypeRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(oppTypeRadio.isSelected(), "Opportunity Type Radio button not selected");
                    break;
                case "workShift":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkShiftRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkShiftRadio.isSelected(), "Work Shift Radio button not selected");
                    break;
                case "workArrangement":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkArrangementRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkArrangementRadio.isSelected(), "Work Arrangement Radio button not selected");
                    break;
                case "workHours":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkHoursRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkHoursRadio.isSelected(), "Work Hours Radio button not selected");
                    break;
                case "skill1":
                    oppPage.selectSkills(expectedValue, testData.get("skill2"));
                    softAssert.assertEquals(oppPage.getskillvalue1(expectedValue), expectedValue, "Core Value 1 mismatch!");
                    break;
                case "skill2":
                    softAssert.assertEquals(oppPage.getskillvalue2(expectedValue), expectedValue, "Skill 2 mismatch!");
                    break;
                case "contactName":
                    oppPage.enterContactName(expectedValue);
                    softAssert.assertEquals(oppPage.getContactName(), expectedValue, "Contact name input field did not match!");
                    break;
                case "contactEmail":
                    oppPage.enterContactEmail(expectedValue);
                    softAssert.assertEquals(oppPage.getContactEmail(), expectedValue, "Contact email input field did not match!");
                    break;
                case "opportunityDuration":
                    oppPage.enterOpportunityDuration(expectedValue);
                    softAssert.assertEquals(oppPage.getOpportunityDuration(), expectedValue, "Opportunity duration did not match!");
                    break;
                case "totalPositions":
                    oppPage.enterTotalPositions(expectedValue);
                    softAssert.assertEquals(oppPage.getTotalPositions(), expectedValue, "Total positions did not match!");
                    break;
                case "jobDescription":
                    oppPage.enterJobDescription(expectedValue);
                    softAssert.assertEquals(oppPage.getJobDescription(), expectedValue, "Job description did not match!");
                    break;
                case "listOfResponsibilities":
                    oppPage.enterListOfResponsibilities(expectedValue);
                    softAssert.assertEquals(oppPage.getListOfResponsibilities(), expectedValue, "Responsibilities list did not match!");
                    break;
                case "salaryFrom":
                    oppPage.enterSalaryFrom(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryFrom(), expectedValue, "Salary from input did not match!");
                    break;
                case "salaryTo":
                    oppPage.enterSalaryTo(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryTo(), expectedValue, "Salary to input did not match!");
                    oppPage.checkBonus();
                    softAssert.assertTrue(oppPage.getBonusCheckDisplay(), "Bonus is checked!");
                    break;
                case "numberOfHolidays":
                    oppPage.enterNumberOfHolidays(expectedValue);
                    softAssert.assertEquals(oppPage.getNumberOfHolidays(), expectedValue, "No of holidays did not match!");
                    oppPage.checkExpense();
                    softAssert.assertTrue(oppPage.getExpensesCheck(), "Expense is checked!");
                    break;
                case "benefit1":
                    oppPage.enterBenefits(expectedValue, testData.get("benefit2"));
                    softAssert.assertEquals(oppPage.getbenefitvalue1(expectedValue), expectedValue, "Benefit 1 mismatch!");
                    break;
                case "benefit2":
                    softAssert.assertEquals(oppPage.getbenefitvalue2(expectedValue), expectedValue, "Benefit 2 mismatch!");
                    break;
                case "qualification1":
                    oppPage.enterFirstQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getFirstQualification(), expectedValue, "First qualification did not match!");
                    break;
                case "qualification2":
                    oppPage.enterSecondQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getSecondQualification(), expectedValue, "Second qualification did not match!");
                    break;
                case "qualificationStage1":
                    oppPage.enterStage1Qualification(expectedValue);
                    softAssert.assertEquals(oppPage.getStage1Qualification(), expectedValue, "Stage 1 qualification did not match!");
                    break;
                case "additionalComments":
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
        softAssert.assertEquals(dashboartitle, "Day One - Dashboard", "DashboardPage title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        boolean oppcreatetoast = dashboardpage.verifyOppCreatedToast();
        softAssert.assertTrue(oppcreatetoast, "Opp Create Toast is not visible");

        boolean oppNameTest = dashboardpage.verifyOppName(TestUtils.opportunityName);
        softAssert.assertTrue(oppNameTest, "Opp Name is not visible");



        softAssert.assertAll();
    }


    @Test(priority = 3, enabled = false)
    public void verifyFillOppPageMandatoryFieldsTest()  {

        String dashboardtitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboardtitle, "Day One - Dashboard", "Dashboard title didn't match!");

        oppPage = dashboardpage.clickOnCreateNewOpp();
        String oppPageTitleBackground = oppPage.verifyOppPageTitle();
        softAssert.assertEquals(oppPageTitleBackground, "Day One - Create Opportunity", "Opp page title didn't match!");

        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {

                case "title":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.titleToast(), "Opportunity title is required.", "Title toast mismatch!");
                    oppPage.enterTitle(expectedValue);
                    softAssert.assertEquals(oppPage.getTitle(), expectedValue, "Title input field did not match!");
                    oppPage.titleClick();
                    break;

                case "location":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.locationToast(), "Location is required.", "Location toast mismatch!");
                    oppPage.enterLocation(expectedValue);
                    softAssert.assertEquals(oppPage.getLocation(), expectedValue, "Location value mismatch!");
                    break;

                case "opportunityType":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.oppTypeToast(), "Opportunity type is required.", "Opportunity type toast mismatch!");
                    oppPage.selectRadioButton(expectedValue);
                    WebElement oppTypeRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(oppTypeRadio.isSelected(), "Opportunity Type Radio button not selected");
                    break;

                case "workShift":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.workShiftToast(), "Working shift is required.", "Work Shift toast mismatch!");
                    oppPage.selectRadioButton(expectedValue);
                    WebElement workShiftRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(workShiftRadio.isSelected(), "Work Shift radio button not selected.");
                    break;

                case "workArrangement":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.workArrangementToast(), "Working arrangement is required.", "Work Arrangement toast mismatch!");
                    oppPage.selectRadioButton(expectedValue);
                    WebElement workArrangementRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(workArrangementRadio.isSelected(), "Work Arrangement radio button not selected.");
                    break;

                case "workHours":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.workHoursToast(), "Working hours are required.", "Work Hours toast mismatch!");
                    oppPage.selectRadioButton(expectedValue);
                    WebElement workHoursRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(workHoursRadio.isSelected(), "Work Hours radio button not selected.");
                    break;

                case "skill1":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.skillsToast(), "At least one skill is required.", "Skills toast mismatch!");
                    oppPage.selectSkills(expectedValue, testData.get("skill2"));
                    softAssert.assertEquals(oppPage.getskillvalue1(expectedValue), expectedValue, "Core Value 1 mismatch!");
                    break;
                case "skill2":
                    softAssert.assertEquals(oppPage.getskillvalue2(expectedValue), expectedValue, "Skill 2 mismatch!");
                    break;


                case "contactName":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.contactNameToast(), "Contact Name is required.", "Contact Name toast mismatch!");
                    oppPage.enterContactName(expectedValue);
                    softAssert.assertEquals(oppPage.getContactName(), expectedValue, "Contact Name value mismatch!");
                    break;

                case "contactEmail":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.contactEmailToast(), "Contact email address is required.", "Contact Email toast mismatch!");
                    oppPage.enterContactEmail(expectedValue);
                    softAssert.assertEquals(oppPage.getContactEmail(), expectedValue, "Contact Email value mismatch!");
                    break;

                case "opportunityDuration":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.durationOfOppToast(), "Duration of opportunity is required.", "Duration toast mismatch!");
                    oppPage.enterOpportunityDuration(expectedValue);
                    softAssert.assertEquals(oppPage.getOpportunityDuration(), expectedValue, "Duration value mismatch!");
                    break;

                case "totalPositions":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.noOfPosToast(), "No of open positions is required.", "Positions toast mismatch!");
                    oppPage.enterTotalPositions(expectedValue);
                    softAssert.assertEquals(oppPage.getTotalPositions(), expectedValue, "Positions value mismatch!");
                    break;

                case "jobDescription":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.jobDescriptionToast(), "Job description is required.", "Job Description toast mismatch!");
                    oppPage.enterJobDescription(expectedValue);
                    softAssert.assertEquals(oppPage.getJobDescription(), expectedValue, "Job Description value mismatch!");
                    break;

                case "listOfResponsibilities":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.listOfRespToast(), "Job responsibilities are required.", "Responsibilities toast mismatch!");
                    oppPage.enterListOfResponsibilities(expectedValue);
                    softAssert.assertEquals(oppPage.getListOfResponsibilities(), expectedValue, "Responsibilities value mismatch!");
                    break;

                case "salaryFrom":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.salFromToast(), "Salary range from is required.", "Salary From toast mismatch!");
                    oppPage.enterSalaryFrom(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryFrom(), expectedValue, "Salary From value mismatch!");
                    break;

                case "salaryTo":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.salToToast(), "Salary range to is required.", "Salary To toast mismatch!");
                    oppPage.enterSalaryTo(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryTo(), expectedValue, "Salary To value mismatch!");
                    oppPage.checkBonus();
                    softAssert.assertTrue(oppPage.getBonusCheckDisplay(), "Bonus is checked!");
                    break;

                case "numberOfHolidays":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.noOfHolidaysToast(), "Number of holidays is required.", "Holidays toast mismatch!");
                    oppPage.enterNumberOfHolidays(expectedValue);
                    softAssert.assertEquals(oppPage.getNumberOfHolidays(), expectedValue, "Holidays value mismatch!");
                    oppPage.checkExpense();
                    softAssert.assertTrue(oppPage.getExpensesCheck(), "Expense is checked!");
                    break;

                case "benefit1":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.benefitsToast(), "Benefits are required.", "Benefits toast mismatch!");
                    oppPage.enterBenefits(expectedValue, testData.get("benefit2"));
                    softAssert.assertEquals(oppPage.getbenefitvalue1(expectedValue), expectedValue, "Benefit 1 mismatch!");
                    break;
                case "benefit2":
                    softAssert.assertEquals(oppPage.getbenefitvalue2(expectedValue), expectedValue, "Benefit 2 mismatch!");
                    break;


                case "qualification1":
                    oppPage.enterFirstQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getFirstQualification(), expectedValue, "First Qualification value mismatch!");
                    break;

                case "qualification2":
                    oppPage.enterSecondQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getSecondQualification(), expectedValue, "Second Qualification value mismatch!");
                    break;

                case "qualificationStage1":
                    oppPage.clickPublish();
                    softAssert.assertEquals(oppPage.stage1Toast(), "Stage round 1 is required.", "Stage 1 toast mismatch!");
                    oppPage.enterStage1Qualification(expectedValue);
                    softAssert.assertEquals(oppPage.getStage1Qualification(), expectedValue, "Stage 1 Qualification value mismatch!");
                    break;

                case "additionalComments":
                    oppPage.enterAdditionalComments(expectedValue);
                    softAssert.assertEquals(oppPage.getAdditionalComments(), expectedValue, "Additional Comments value mismatch!");
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected field key: " + fieldKey);
            }
        }


        // Step 9: Publish Opportunity
        oppPage.clickPublish();

        String dashboartitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboartitle, "Day One - Dashboard", "DashboardPage title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        boolean oppcreatetoast = dashboardpage.verifyOppCreatedToast();
        softAssert.assertTrue(oppcreatetoast, "Opp Create Toast is not visible");

        boolean oppNameTest = dashboardpage.verifyOppName(TestUtils.opportunityName);
        softAssert.assertTrue(oppNameTest, "Opp Name is not visible");



        softAssert.assertAll();
    }

    @Test(priority = 4, enabled = false)
    public void verifyFillOppPageAndSaveAsDraftTest() throws InterruptedException {

        String dashboardtitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboardtitle, "Day One - Dashboard", "Dashboard title didn't match!");

        oppPage = dashboardpage.clickOnCreateNewOpp();
        String oppPageTitleBackground = oppPage.verifyOppPageTitle();
        softAssert.assertEquals(oppPageTitleBackground, "Day One - Create Opportunity", "Opp page title didn't match!");


        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String fieldKey = entry.getKey();
            String expectedValue = entry.getValue();

            switch (fieldKey) {
                case "title":
                    oppPage.enterTitle(TestUtils.opportunityName);
                    softAssert.assertEquals(oppPage.getTitle(), expectedValue, "Title input field did not match!");
                    oppPage.titleClick();
                    break;
                case "location":
                    oppPage.enterLocation(expectedValue);
                    softAssert.assertEquals(oppPage.getLocation(), expectedValue, "Location input field did not match!");
                    break;
                case "opportunityType":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement oppTypeRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(oppTypeRadio.isSelected(), "Opportunity Type Radio button not selected");
                    break;
                case "workShift":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkShiftRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkShiftRadio.isSelected(), "Work Shift Radio button not selected");
                    break;
                case "workArrangement":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkArrangementRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkArrangementRadio.isSelected(), "Work Arrangement Radio button not selected");
                    break;
                case "workHours":
                    oppPage.selectRadioButton(expectedValue);
                    WebElement WorkHoursRadio = oppPage.getRadioButton(expectedValue);
                    softAssert.assertTrue(WorkHoursRadio.isSelected(), "Work Hours Radio button not selected");
                    break;
                case "skill1":
                    oppPage.selectSkills(expectedValue, testData.get("skill2"));
                    softAssert.assertEquals(oppPage.getskillvalue1(expectedValue), expectedValue, "Skill 1 mismatch!");
                    break;
                case "skill2":
                    softAssert.assertEquals(oppPage.getskillvalue2(expectedValue), expectedValue, "Skill 2 mismatch!");
                    break;
                case "contactName":
                    oppPage.enterContactName(expectedValue);
                    softAssert.assertEquals(oppPage.getContactName(), expectedValue, "Contact name input field did not match!");
                    break;
                case "contactEmail":
                    oppPage.enterContactEmail(expectedValue);
                    softAssert.assertEquals(oppPage.getContactEmail(), expectedValue, "Contact email input field did not match!");
                    break;
                case "opportunityDuration":
                    oppPage.enterOpportunityDuration(expectedValue);
                    softAssert.assertEquals(oppPage.getOpportunityDuration(), expectedValue, "Opportunity duration did not match!");
                    break;
                case "totalPositions":
                    oppPage.enterTotalPositions(expectedValue);
                    softAssert.assertEquals(oppPage.getTotalPositions(), expectedValue, "Total positions did not match!");
                    break;
                case "jobDescription":
                    oppPage.enterJobDescription(expectedValue);
                    softAssert.assertEquals(oppPage.getJobDescription(), expectedValue, "Job description did not match!");
                    break;
                case "listOfResponsibilities":
                    oppPage.enterListOfResponsibilities(expectedValue);
                    softAssert.assertEquals(oppPage.getListOfResponsibilities(), expectedValue, "Responsibilities list did not match!");
                    break;
                case "salaryFrom":
                    oppPage.enterSalaryFrom(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryFrom(), expectedValue, "Salary from input did not match!");
                    break;
                case "salaryTo":
                    oppPage.enterSalaryTo(expectedValue);
                    softAssert.assertEquals(oppPage.getSalaryTo(), expectedValue, "Salary to input did not match!");
                    oppPage.checkBonus();
                    softAssert.assertTrue(oppPage.getBonusCheckDisplay(), "Bonus is checked!");
                    break;
                case "numberOfHolidays":
                    oppPage.enterNumberOfHolidays(expectedValue);
                    softAssert.assertEquals(oppPage.getNumberOfHolidays(), expectedValue, "No of holidays did not match!");
                    oppPage.checkExpense();
                    softAssert.assertTrue(oppPage.getExpensesCheck(), "Expense is checked!");
                    break;
                case "benefit1":
                    oppPage.enterBenefits(expectedValue, testData.get("benefit2"));
                    softAssert.assertEquals(oppPage.getbenefitvalue1(expectedValue), expectedValue, "Benefit 1 mismatch!");
                    break;
                case "benefit2":
                    softAssert.assertEquals(oppPage.getbenefitvalue2(expectedValue), expectedValue, "Benefit 2 mismatch!");
                    break;
                case "qualification1":
                    oppPage.enterFirstQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getFirstQualification(), expectedValue, "First qualification did not match!");
                    break;
                case "qualification2":
                    oppPage.enterSecondQualification(expectedValue);
                    softAssert.assertEquals(oppPage.getSecondQualification(), expectedValue, "Second qualification did not match!");
                    break;
                case "qualificationStage1":
                    oppPage.enterStage1Qualification(expectedValue);
                    softAssert.assertEquals(oppPage.getStage1Qualification(), expectedValue, "Stage 1 qualification did not match!");
                    break;
                case "additionalComments":
                    oppPage.enterAdditionalComments(expectedValue);
                    softAssert.assertEquals(oppPage.getAdditionalComments(), expectedValue, "Additional comments did not match!");
                    break;
                default:
                    System.out.println("No action defined for field: " + fieldKey);
                    break;
            }
        }

        // Step 9: Save Opportunity as Draft
        oppPage.clickSaveAsDraft();

        String dashboartitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboartitle, "Day One - Dashboard", "DashboardPage title didn't match!");

        boolean dashnav = dashboardpage.verifyDashboardNav();
        softAssert.assertTrue(dashnav, "Dashboard button is not visible");

        boolean draftcreatetoast = dashboardpage.verifySaveAsDraftCreatedToast();
        softAssert.assertTrue(draftcreatetoast, "Draft Toast is not visible");



        boolean viewOppButton = dashboardpage.viewCreateNewOppButton();
        softAssert.assertTrue(viewOppButton, "Opp Button is not visisble");



        softAssert.assertAll();
    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
