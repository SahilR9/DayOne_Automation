package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OppPage extends TestBase {


    @FindBy (id = "opportunityTitle")
    WebElement oppTitle;

    @FindBy(id = "saveOpportunityTitle")
    WebElement titleTick;

    @FindBy(id="closeOpportunityTitle")
    WebElement titleCross;

    @FindBy(xpath = "//span[text()='Seasonal Roles']")
    WebElement Opptype;

    @FindBy(xpath = "(//div[@class='pac-item'])[1]")
    WebElement locDrop;

    @FindBy(xpath = "//input[@placeholder='Search for location']")
    WebElement location;

    @FindBy(xpath = "//span[@class='ant-input-suffix']")
    WebElement locationCross;

    public WebElement oppTypeRadio;
    public WebElement workShiftRadio;
    public WebElement workArrangementRadio;
    public WebElement workHoursRadio;

    @FindBy(xpath = "//input[@type='search']")
    WebElement skillsSearch;

    @FindBy(id = "contactName")
    WebElement contactName;

    @FindBy(id = "contactEmailAddress")
    WebElement contactEmail;

    @FindBy(id = "opportunityDuration")
    WebElement oppDuration;

    @FindBy(id = "totalPositions")
    WebElement totalPositions;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[1]")
    WebElement jobDescription;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[2]")
    WebElement listofResp;

    @FindBy(id = "salaryRangeFrom")
    WebElement salaryFrom;

    @FindBy(id = "salaryRangeTo")
    WebElement salaryTo;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement bonusCheck;

    @FindBy(id = "noOfHolidays")
    WebElement noOfHoli;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement expenseCheck;

    @FindBy(id = "benefits")
    WebElement benefits;

    @FindBy(id = "firstQualifyingQuestion")
    WebElement firstQualify;

    @FindBy(id = "secondQualifyingQuestion")
    WebElement secondQualify;

    @FindBy(id = "stage1")
    WebElement stage1;

    @FindBy(id = "comments")
    WebElement additionalComm;

    @FindBy(id = "opportunityPagePublish")
    WebElement oppPublish;

    @FindBy(id = "opportunityPageSaveasDraft")
    WebElement saveAsDraft;

    @FindBy(id = "opportunityPreview")
    WebElement preview;

    @FindBy(id = "backButton")
    WebElement backButton;

    @FindBy(xpath = "//span[text()='Opportunity title is required.']")
    WebElement titleToast;

    @FindBy(xpath = "//span[text()='Location is required.']")
    WebElement locationToast;

    @FindBy(xpath = "//span[text()='Opportunity type is required.']")
    WebElement oppTypeToast;

    @FindBy(xpath = "//span[text()='Working shift is required.']")
    WebElement workShiftToast;

    @FindBy(xpath = "//span[text()='Working arrangement is required.']")
    WebElement workArrangementToast;

    @FindBy(xpath = "//span[text()='Working hours are required.']")
    WebElement workHoursToast;

    @FindBy(xpath = "//span[text()='At least one skill is required.']")
    WebElement skillsToast;

    @FindBy(xpath = "//span[text()='Contact Name is required.']")
    WebElement conNameToast;

    @FindBy(xpath = "//span[text()='Contact email address is required.']")
    WebElement conEmailToast;

    @FindBy(xpath = "//span[text()='Duration of opportunity is required.']")
    WebElement durOfOppToast;

    @FindBy(xpath = "//span[text()='No of open positions is required.']")
    WebElement noOfPosToast;

    @FindBy(xpath = "//span[text()='Job description is required.']")
    WebElement jobDesToast;

    @FindBy(xpath = "//span[text()='Job responsibilities are required.']")
    WebElement lisOfResToast;

    @FindBy(xpath = "//span[text()='Salary range from is required.']")
    WebElement salFromToast;

    @FindBy(xpath = "//span[text()='Salary range to is required.']")
    WebElement salToToast;

    @FindBy(xpath = "//span[text()='Number of holidays is required.']")
    WebElement noOfHolToast;

    @FindBy(xpath = "//span[text()='Benefits are required.']")
    WebElement BenefitsToast;

    @FindBy(xpath = "//span[text()='Stage round 1 is required.']")
    WebElement stage1Toast;












    public OppPage(){
        PageFactory.initElements(driver, this);

    }

    // Method to get a dynamic locator for radio buttons
    public By dynamicRadioButton(String value) {
        return By.xpath("//input[@id='" +value+ "']");
    }

    public WebElement commRadio(String radioButtonValue) {
        By radioButtonLocator = dynamicRadioButton(radioButtonValue);
        return driver.findElement(radioButtonLocator);
    }






    public String verifyOppPageTitle(){
        TestUtils.waitForTitle(driver, "Day One - Create Opportunity", 20);
        return driver.getTitle();
    }

    public void enterTitle(String title) {

        TestUtils.waitForElementVisibility(driver, oppTitle, 10);

        if (!oppTitle.getAttribute("value").isEmpty()) {
            // If there is text, clear it by selecting all and backspacing
            oppTitle.sendKeys(Keys.CONTROL + "a");  // Select all text
            oppTitle.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, oppTitle, 5);
        oppTitle.sendKeys(title);
    }

    public void titleClick(){
            TestUtils.waitForElementToBeClickable(driver, titleTick, 10);
            titleTick.click();

    }

    public void enterLocation(String loc) {
        location.sendKeys(loc);
        TestUtils.waitForElementVisibility(driver, locDrop,10);
        location.sendKeys(Keys.ENTER);
//        TestUtils.scrollToElement(driver, Opptype, 10);


        new Actions(driver).moveByOffset(0, 0).click().perform();
        }

    public void selectRadioButton(String radioButtonValue) {
//        By radioButtonLocator = dynamicRadioButton(radioButtonValue);
        WebElement radioButton = commRadio(radioButtonValue);
        TestUtils.scrollToElement(driver, radioButton);
        radioButton.click();
    }


    public void selectSkills(String skill1, String skill2) {
        skillsSearch.click();
        TestUtils.selectDropdownValue(skill1);
        TestUtils.selectDropdownValue(skill2);
        new Actions(driver).moveByOffset(0, 0).click().perform();
    }

    public void enterContactName(String conName) {
        TestUtils.waitForElementVisibility(driver, contactName, 10);

        if (!contactName.getAttribute("value").isEmpty()) {
            contactName.sendKeys(Keys.CONTROL + "a");  // Select all text
            contactName.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, contactName, 10);
        contactName.sendKeys(conName);
    }

    // Method to enter contact email
    public void enterContactEmail(String conEmail) {
        TestUtils.waitForElementVisibility(driver, contactEmail, 10);

        if (!contactEmail.getAttribute("value").isEmpty()) {
            contactEmail.sendKeys(Keys.CONTROL + "a");  // Select all text
            contactEmail.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, contactEmail, 10);
        contactEmail.sendKeys(conEmail);
    }

    // Method to enter opportunity duration
    public void enterOpportunityDuration(String oppdu) {
        TestUtils.waitForElementVisibility(driver, oppDuration, 10);

        if (!oppDuration.getAttribute("value").isEmpty()) {
            oppDuration.sendKeys(Keys.CONTROL + "a");  // Select all text
            oppDuration.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, oppDuration, 10);
        oppDuration.sendKeys(oppdu);
    }

    // Method to enter total positions
    public void enterTotalPositions(String totps) {
        TestUtils.waitForElementVisibility(driver, totalPositions, 10);

        if (!totalPositions.getAttribute("value").isEmpty()) {
            totalPositions.sendKeys(Keys.CONTROL + "a");  // Select all text
            totalPositions.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, totalPositions, 5);
        totalPositions.sendKeys(totps);
    }

    // Method to enter job description
    public void enterJobDescription(String jodes) {
        TestUtils.waitForElementVisibility(driver, jobDescription, 10);

        if (!jobDescription.getText().isEmpty()) {
            jobDescription.sendKeys(Keys.CONTROL + "a");  // Select all text
            jobDescription.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, jobDescription, 10);
        jobDescription.sendKeys(jodes);
    }

    // Method to enter list of responsibilities
    public void enterListOfResponsibilities(String list) {
        TestUtils.waitForElementVisibility(driver, listofResp, 10);

        if (!listofResp.getText().isEmpty()) {
            listofResp.sendKeys(Keys.CONTROL + "a");  // Select all text
            listofResp.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, listofResp, 10);
        listofResp.sendKeys(list);
    }

    public void enterSalaryFrom(String salf) {
        TestUtils.waitForElementVisibility(driver, salaryFrom, 10);

        if (!salaryFrom.getAttribute("value").isEmpty()) {
            salaryFrom.sendKeys(Keys.CONTROL + "a");  // Select all text
            salaryFrom.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, salaryFrom, 3);
        salaryFrom.sendKeys(salf);
    }

    public void enterSalaryTo(String salto) {
        TestUtils.waitForElementVisibility(driver, salaryTo, 3);

        if (!salaryTo.getAttribute("value").isEmpty()) {
            salaryTo.sendKeys(Keys.CONTROL + "a");  // Select all text
            salaryTo.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, salaryTo, 3);
        salaryTo.sendKeys(salto);
    }

    // Method to check the bonus checkbox
    public void checkBonus() {
        if (!bonusCheck.isSelected()) {
            bonusCheck.click(); // Click it to check
        }
    }

    public void enterNumberOfHolidays(String noofhol) {
        TestUtils.waitForElementVisibility(driver, noOfHoli, 3);

        if (!noOfHoli.getAttribute("value").isEmpty()) {
            noOfHoli.sendKeys(Keys.CONTROL + "a");  // Select all text
            noOfHoli.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, noOfHoli, 3);
        noOfHoli.sendKeys(noofhol); // Enter the holiday value
    }

    public void checkExpense(){

        if(!expenseCheck.isSelected()) {
            expenseCheck.click();
        }
    }

    public void enterBenefits(String benefit1, String benefit2) {
        benefits.click();
        TestUtils.selectDropdownValue(benefit1);
        TestUtils.selectDropdownValue(benefit2);
        new Actions(driver).moveByOffset(0, 0).click().perform();
    }

    // Method to enter the first qualification
    public void enterFirstQualification(String firstql) {
        TestUtils.waitForElementVisibility(driver, firstQualify, 3);

        if (!firstQualify.getAttribute("value").isEmpty()) {
            firstQualify.sendKeys(Keys.CONTROL + "a");  // Select all text
            firstQualify.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, firstQualify, 3);
        firstQualify.sendKeys(firstql);
    }

    // Method to enter the second qualification
    public void enterSecondQualification(String secql) {
        TestUtils.waitForElementVisibility(driver, secondQualify, 3);

        if (!secondQualify.getAttribute("value").isEmpty()) {
            secondQualify.sendKeys(Keys.CONTROL + "a");  // Select all text
            secondQualify.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, secondQualify, 3);
        secondQualify.sendKeys(secql);
    }

    // Method to enter stage 1 qualification
    public void enterStage1Qualification(String sta) {
        TestUtils.waitForElementVisibility(driver, stage1, 10);

        if (!stage1.getAttribute("value").isEmpty()) {
            stage1.sendKeys(Keys.CONTROL + "a");  // Select all text
            stage1.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, stage1, 10);
        stage1.sendKeys(sta);
    }

    // Method to enter additional comments
    public void enterAdditionalComments(String addcom) {
        TestUtils.waitForElementVisibility(driver, additionalComm, 10);

        if (!additionalComm.getAttribute("value").isEmpty()) {
            additionalComm.sendKeys(Keys.CONTROL + "a");  // Select all text
            additionalComm.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        TestUtils.waitForElementVisibility(driver, additionalComm, 10);
        additionalComm.sendKeys(addcom);
    }

    public void clickPublish() {
        TestUtils.waitForElementToBeClickable(driver, oppPublish, 10);
        oppPublish.click();
    }

    public void clickSaveAsDraft(){
        TestUtils.waitForElementToBeClickable(driver, saveAsDraft, 10);
        saveAsDraft.click();

    }

    public boolean verifySaveasDraftButton(){
        TestUtils.waitForElementVisibility(driver, saveAsDraft, 5);

        return saveAsDraft.isDisplayed();
    }

    //Toast messages

    public String titleToast(){
        TestUtils.waitForElementVisibility(driver, titleToast, 5);
        return titleToast.getText();
    }

    public String locationToast(){
        TestUtils.waitForElementVisibility(driver, locationToast, 10);
        return locationToast.getText();
    }

    public String oppTypeToast(){
        TestUtils.waitForElementVisibility(driver, oppTypeToast, 6);
        return oppTypeToast.getText();
    }

    public String workShiftToast(){
        TestUtils.waitForElementVisibility(driver, workShiftToast, 6);
        return workShiftToast.getText();
    }

    public String workArrangementToast(){
        TestUtils.waitForElementVisibility(driver, workArrangementToast, 10);
        return workArrangementToast.getText();
    }


    public String workHoursToast(){
        TestUtils.waitForElementVisibility(driver, workHoursToast, 10);
        return workHoursToast.getText();
    }

    public String skillsToast(){
        TestUtils.waitForElementVisibility(driver, skillsToast, 6);
        return skillsToast.getText();
    }

    public String contactNameToast(){
        TestUtils.waitForElementVisibility(driver, conNameToast, 6);
        return conNameToast.getText();
    }

    public String contactEmailToast(){
        TestUtils.waitForElementVisibility(driver, conEmailToast, 6);
        return conEmailToast.getText();
    }

    public String durationOfOppToast(){
        TestUtils.waitForElementVisibility(driver, durOfOppToast, 6);
        return durOfOppToast.getText();
    }

    public String noOfPosToast(){
        TestUtils.waitForElementVisibility(driver, noOfPosToast, 6);
        return noOfPosToast.getText();
    }

    public String jobDescriptionToast(){
        TestUtils.waitForElementVisibility(driver, jobDesToast, 6);
        return jobDesToast.getText();
    }

    public String listOfRespToast(){
        TestUtils.waitForElementVisibility(driver, lisOfResToast, 6);
        return lisOfResToast.getText();
    }

    public String salFromToast(){
        TestUtils.waitForElementVisibility(driver, salFromToast, 6);
        return salFromToast.getText();
    }

    public String salToToast(){
        TestUtils.waitForElementVisibility(driver, salToToast, 6);
        return salToToast.getText();
    }

    public String noOfHolidaysToast(){
        TestUtils.waitForElementVisibility(driver, noOfHolToast, 6);
        return noOfHolToast.getText();
    }

    public String benefitsToast(){
        TestUtils.waitForElementVisibility(driver, BenefitsToast, 6);
        return BenefitsToast.getText();
    }

    public String stage1Toast(){
        TestUtils.waitForElementVisibility(driver, stage1Toast, 6);
        return stage1Toast.getText();
    }






    // Getters

    public String getTitle(){
        TestUtils.waitForElementVisibility(driver, oppTitle, 3);
        return oppTitle.getAttribute("value"); //
    }
    public String getLocation() {
        TestUtils.waitForElementVisibility(driver, location, 10);
        return location.getAttribute("value"); // Assuming location is the WebElement for the location input
    }

    public WebElement getRadioButton(String radioButtonValue) {
//        By radioButtonLocator = dynamicRadioButton(radioButtonValue);
        WebElement radioButton = commRadio(radioButtonValue);
        return radioButton;
    }

    public String getskillvalue1(String skill1){
        return TestUtils.getSelectedDropdownValue(driver, skill1);
    }

    public String getskillvalue2(String skill2){
        return TestUtils.getSelectedDropdownValue(driver, skill2);
    }




    // Getter for Contact Name
    public String getContactName() {
        return contactName.getAttribute("value"); // Assuming contactName is the WebElement for contact name input
    }

    // Getter for Contact Email
    public String getContactEmail() {
        return contactEmail.getAttribute("value"); // Assuming contactEmail is the WebElement for contact email input
    }

    // Getter for Opportunity Duration
    public String getOpportunityDuration() {
        return oppDuration.getAttribute("value"); // Assuming oppDuration is the WebElement for duration input
    }

    // Getter for Total Positions
    public String getTotalPositions() {
        return totalPositions.getAttribute("value"); // Assuming totalPositions is the WebElement for total positions input
    }

    // Getter for Job Description
    public String getJobDescription() {
        return jobDescription.getText();    }

    // Getter for List of Responsibilities
    public String getListOfResponsibilities() {
        return listofResp.getText();
    }

    // Getter for Salary From
    public String getSalaryFrom() {
        return salaryFrom.getAttribute("value"); // Assuming salaryFrom is the WebElement for salary 'from' input
    }

    // Getter for Salary To
    public String getSalaryTo() {
        return salaryTo.getAttribute("value"); // Assuming salaryTo is the WebElement for salary 'to' input
    }

    public  boolean getBonusCheckDisplay(){
        return  bonusCheck.isSelected();
    }

    // Getter for Number of Holidays
    public String getNumberOfHolidays() {
        return noOfHoli.getAttribute("value"); // Assuming noOfHoli is the WebElement for number of holidays input
    }

    public boolean getExpensesCheck(){
        return expenseCheck.isSelected();
    }

    public String getbenefitvalue1(String benefit1){
        return TestUtils.getSelectedDropdownValue(driver, benefit1);
    }

    public String getbenefitvalue2(String benefit1){
        return TestUtils.getSelectedDropdownValue(driver, benefit1);
    }


    public String getFirstQualification() {
        return firstQualify.getAttribute("value"); // Assuming additionalComm is the WebElement for additional comments input
    }

    public String getSecondQualification() {
        return secondQualify.getAttribute("value"); // Assuming additionalComm is the WebElement for additional comments input
    }

    public String getStage1Qualification() {
        return stage1.getAttribute("value"); // Assuming additionalComm is the WebElement for additional comments input
    }

    // Getter for Additional Comments
    public String getAdditionalComments() {
        return additionalComm.getAttribute("value"); // Assuming additionalComm is the WebElement for additional comments input
    }

}
