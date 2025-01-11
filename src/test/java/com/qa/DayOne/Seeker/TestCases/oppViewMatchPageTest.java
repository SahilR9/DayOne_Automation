package com.qa.DayOne.Seeker.TestCases;

import com.qa.DayOne.Seeker.Pages.*;
import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class oppViewMatchPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardpage;
    BackgroundPage backgroundPage;
    ValuesPage valuesPage;

    OppPage oppPage;
    DraftOppPage draftOppPage;
    OppViewMatches oppViewMatches;
    SoftAssert softAssert;


    public oppViewMatchPageTest(){

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
        oppViewMatches = new OppViewMatches();
        softAssert = new SoftAssert();
    }

    public OppViewMatches navigateToOppViewMatches() {
        String dashboardTitle = dashboardpage.verifyDashboardPageTitle();
        softAssert.assertEquals(dashboardTitle, "Day One - Dashboard", "Dashboard title didn't match!");

        boolean viewMatchButton = dashboardpage.viewMatchButton();
        softAssert.assertEquals(viewMatchButton, true, "ViewMatches button is not visible");

        return dashboardpage.clickOnOppViewMatch(TestUtils.opportunityName);
    }

    @Test(priority = 1, enabled = false)
    public void verifyOppViewMatchTest() {


        oppViewMatches = navigateToOppViewMatches();
        String OppViewMatchTitle = oppViewMatches.verifyMatchOppTitle(TestUtils.opportunityName);
        softAssert.assertEquals(OppViewMatchTitle, "Day One - "  + TestUtils.opportunityName, "Title didn't match");

    }

    @Test(priority = 2, enabled = false)
    public void shortlistFirstTalentTest() {
        oppViewMatches = navigateToOppViewMatches();

        String OppViewMatchTitle = oppViewMatches.verifyMatchOppTitle(TestUtils.opportunityName);
        softAssert.assertEquals(OppViewMatchTitle, "Day One - "  + TestUtils.opportunityName, "Title didn't match");



        oppViewMatches.shortlistFirstTalent();
        boolean ShortlistToastAppear = oppViewMatches.shortlistedToast();
        softAssert.assertEquals(ShortlistToastAppear, true, "Shortlist Toast didn't appear");

        oppViewMatches.clickOnShortlistedSection();
        boolean shortlistedTabSelected = oppViewMatches.isShortlistedTabButtonSelected();
        softAssert.assertEquals(shortlistedTabSelected, true, "Shortlist Tab is not selected");

        oppViewMatches.clickOnActionButton();
        oppViewMatches.clickOnConnectButton();
        boolean invitationSent = oppViewMatches.isInvitationSentDisplayed();
        softAssert.assertEquals(invitationSent, true, "Invitation sent is not visible");

    }

    @Test(priority = 3)
    public void  firstTalentProfileView() {
        oppViewMatches = navigateToOppViewMatches();

        String OppViewMatchTitle = oppViewMatches.verifyMatchOppTitle(TestUtils.opportunityName);
        softAssert.assertEquals(OppViewMatchTitle, "Day One - "  + TestUtils.opportunityName, "Title didn't match");

        boolean firstTalentVisisble = oppViewMatches.isFirstTalentVisible();
        softAssert.assertEquals(firstTalentVisisble, true, "first talent is not visible");

        String firstTitleName = oppViewMatches.getfirstTalentName();
        oppViewMatches.clickOnViewFirstTalent();

        oppViewMatches.firstTalentTitle(firstTitleName);
        softAssert.assertEquals(firstTitleName, "Day One - "  + firstTitleName, "Title didn't match");

        oppViewMatches.getFirstTitleNameOnPage(firstTitleName);
        softAssert.assertEquals(firstTalentVisisble, true, "Talent Name is not visible");

        String profileHeader = oppViewMatches.getProfileSummaryHeader();
        softAssert.assertEquals(profileHeader, "Profile Summary", "header didn't match");

        String educationHeader = oppViewMatches.getEducationHeader();
        softAssert.assertEquals(educationHeader, "Education", "header didn't match");

        String workExperienceHeader = oppViewMatches.getWorkExperienceHeader();
        softAssert.assertEquals(workExperienceHeader, "Work Experience", "header didn't match");

        String skillsHeader = oppViewMatches.getSkillsHeader();
        softAssert.assertEquals(skillsHeader, "Skills", "header didn't match");

        String languagesHeader = oppViewMatches.getLanguagesHeader();
        softAssert.assertEquals(languagesHeader, "Languages", "header didn't match");

        String achievementsHeader = oppViewMatches.getAchievementsHeader();
        softAssert.assertEquals(achievementsHeader, "Achievements", "header didn't match");

        oppViewMatches.clickOnAspirationsTab();

        String careerPreferenceHeader = oppViewMatches.getCareerPreferenceHeader();
        softAssert.assertEquals(careerPreferenceHeader, "Career Preference", "header didn't match");

        String availabilityHeader = oppViewMatches.getCareerPreferenceHeader();
        softAssert.assertEquals(availabilityHeader, "Availability and Preferred Work Setup", "header didn't match");

        String workFlexibilityHeader = oppViewMatches.getCareerPreferenceHeader();
        softAssert.assertEquals(workFlexibilityHeader, "Work Flexibility", "header didn't match");

        oppViewMatches.clickOnValuesTab();

        String codeOfBehaviourHeader = oppViewMatches.getCareerPreferenceHeader();
        softAssert.assertEquals(codeOfBehaviourHeader, "Code of Behaviour", "header didn't match");

        oppViewMatches.clickOnEssenceTab();

        String YourStrengthsHeader = oppViewMatches.getYourStrengthsHeader();
        softAssert.assertEquals(YourStrengthsHeader, "Your Strengths", "header didn't match");

        String activitiesHeader = oppViewMatches.getActivitiesInvolvedHeader();
        softAssert.assertEquals(activitiesHeader, "Activities involved in", "header didn't match");

        oppViewMatches.clickOnWorkRelatedTab();

        oppViewMatches.clickOnNameBack(firstTitleName);

        oppViewMatches.firstTalentTitle(firstTitleName);
        softAssert.assertEquals(firstTitleName, "Day One - "  + firstTitleName, "Title didn't match");






    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
