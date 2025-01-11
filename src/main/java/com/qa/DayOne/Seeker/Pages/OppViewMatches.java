package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppViewMatches extends TestBase {

    @FindBy (xpath = "//tbody[@class='ant-table-tbody']/tr[1]//div[contains(text(), 'Talent')]")
    WebElement firstTalent;

    @FindBy (xpath = "//tbody[@class='ant-table-tbody']/tr[1]/td[5]//button[@id='bookmarkTalent']")
    WebElement firstTalentShortlistButton;

    @FindBy (xpath = "(//p[contains(text(), 'Shortlisted')])[2]")
    WebElement shortlistedTabButton;

    @FindBy (xpath = "(//span[@role='img']//*[local-name()='svg'])[1]")
    WebElement viewMatchThreeDots;

    @FindBy (xpath = "//div[contains(text(), 'Edit')]")
    WebElement editOpp;

    @FindBy (xpath = "//div[text()='View']")
    WebElement viewOpp;

    @FindBy (xpath = "//div[text()='Close hiring']")
    WebElement closeHiring;

    @FindBy (xpath = "//h4[text()='Back']")
    WebElement backButton;

    @FindBy (xpath = "//tbody[@class='ant-table-tbody']/tr[1]//div[contains(text(), 'Talent')]")
    WebElement shortlistedFirstTalent;

    @FindBy (xpath = "//tbody[@class='ant-table-tbody']/tr[1]/td[5]//button[@id='actionsButton']")
    WebElement actionButton;

    @FindBy (xpath = "//div[text()='Connect']")
    WebElement connectButton;

    @FindBy (xpath = "//div[text()='Not a fit']")
    WebElement NotaFitButton;

    @FindBy (xpath = "//span[text()='Talent-11306 has been shortlisted.']")
    WebElement shortlistedToast;

    @FindBy (xpath = "//div[text()='Invitation sent']")
    WebElement invitationSentStatus;

    @FindBy (xpath = "//h3[contains(text(), 'Profile Summary')]")
    WebElement profileSectioHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Education')]")
    WebElement educationHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Work Experience')]")
    WebElement workExperienceHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Skills')]")
    WebElement skillsHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Languages')]")
    WebElement languagesHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Achievements')]")
    WebElement achievementsHeader;

    @FindBy (xpath = "//div[text()='Aspirations']")
    WebElement aspirationTab;

    @FindBy (xpath = "//h3[contains(text(), 'Career Preference')]")
    WebElement careerPreferenceHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Availability and Preferred Work Setup')]")
    WebElement availabilityHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Work Flexibility')]")
    WebElement flexibilityHeader;

    @FindBy (xpath = "//div[text()='Values']")
    WebElement valuesTab;

    @FindBy (xpath = "//h3[contains(text(), 'Code of Behaviour')]")
    WebElement codeOfBehaviourHeader;

    @FindBy (xpath = "//div[text()='Essence']")
    WebElement essenceTab;

    @FindBy (xpath = "//h3[contains(text(), 'Your Strengths')]")
    WebElement yourStrengthHeader;

    @FindBy (xpath = "//h3[contains(text(), 'Activities involved in')]")
    WebElement activitiesInvolvedHeader;

    @FindBy (xpath = "//div[text()='Work-related Activities Overview']")
    WebElement workRelatedTab;








    public OppViewMatches(){
        PageFactory.initElements(driver, this);

    }

    public String verifyMatchOppTitle(String value){
        TestUtils.waitForTitle(driver, "Day One - " + value, 20);
        return driver.getTitle();
    }

    public void clickOnViewFirstTalent(){
        TestUtils.waitForElementVisibility(driver, firstTalent, 20);
        firstTalent.click();
    }

    public String firstTalentTitle(String title){
        TestUtils.waitForTitle(driver, "Day One - " + title, 20);
        return driver.getTitle();
    }


    public void shortlistFirstTalent(){
        TestUtils.waitForElementVisibility(driver, firstTalentShortlistButton, 20);
        firstTalentShortlistButton.click();
    }

    public void clickOnShortlistedSection(){
        shortlistedTabButton.click();
    }

    public void clickOnThreeDots(){
        viewMatchThreeDots.click();
    }

    public void clickOnEditOpp(){
        editOpp.click();
    }

    public void clickOnView(){
        viewOpp.click();
    }

    public void clickOnCloseHiringButton(){
        closeHiring.click();
    }

    public void clickOnBackButton(){
        backButton.click();
    }

    public void clickOnActionButton(){
        TestUtils.waitForElementVisibility(driver, actionButton, 20);
        actionButton.click();

    }

    public void clickOnConnectButton(){
        TestUtils.waitForElementVisibility(driver, connectButton, 20);
        connectButton.click();
    }

    public boolean shortlistedToast(){
        TestUtils.waitForElementVisibility(driver, shortlistedToast, 20);
        return shortlistedToast.isDisplayed();
    }

    public void clickOnAspirationsTab(){
        aspirationTab.click();
    }

    public void clickOnValuesTab(){
        valuesTab.click();
    }

    public void clickOnEssenceTab(){
        essenceTab.click();
    }

    public void clickOnWorkRelatedTab(){
        workRelatedTab.click();
    }

    public void clickOnNameBack(String value){
        WebElement backButton = driver.findElement(By.xpath("//span[text()='" + value + "']"));
        backButton.click();

    }




    //Getter
    public boolean isFirstTalentVisible() {
        TestUtils.waitForElementVisibility(driver, firstTalent, 20);
        return firstTalent.isDisplayed();
    }

    public String getfirstTalentName(){
        return firstTalent.getText();
    }

    public boolean getFirstTitleNameOnPage(String value){
        WebElement talentName = driver.findElement(By.xpath("//p[text()='" +value+ "']"));
        return talentName.isDisplayed();
    }

    public boolean isFirstTalentShortlistButtonEnabled() {
        return firstTalentShortlistButton.isEnabled();
    }

    public boolean isShortlistedTabButtonSelected() {
        return shortlistedTabButton.isSelected();
    }

    public boolean isThreeDotsVisible() {
        return viewMatchThreeDots.isDisplayed();
    }

    public boolean isEditOppButtonEnabled() {
        return editOpp.isEnabled();
    }

    public boolean isViewOppButtonVisible() {
        return viewOpp.isDisplayed();
    }

    public boolean isCloseHiringButtonEnabled() {
        return closeHiring.isEnabled();
    }

    public boolean isBackButtonVisible() {
        return backButton.isDisplayed();
    }

    public boolean isInvitationSentDisplayed(){
        TestUtils.waitForElementVisibility(driver, invitationSentStatus, 20);
        return invitationSentStatus.isDisplayed();
    }

    public String getProfileSummaryHeader(){
        return profileSectioHeader.getText();
    }

    public String getEducationHeader(){
        return educationHeader.getText();
    }

    public String getWorkExperienceHeader(){
        return workExperienceHeader.getText();
    }

    public String getSkillsHeader(){
        return skillsHeader.getText();
    }

    public String getLanguagesHeader(){
        return languagesHeader.getText();
    }


    public String getAchievementsHeader(){
        return achievementsHeader.getText();
    }


    public String getCareerPreferenceHeader(){
        return careerPreferenceHeader.getText();
    }

    public String getAvailabilityHeader(){
        return availabilityHeader.getText();
    }


    public String getFlexibilityHeader(){
        return flexibilityHeader.getText();
    }

    public String getCodeOfBehaviourHeader(){
        return codeOfBehaviourHeader.getText();
    }

    public String getYourStrengthsHeader(){
        return yourStrengthHeader.getText();
    }

    public String getActivitiesInvolvedHeader(){
        return activitiesInvolvedHeader.getText();
    }





}
