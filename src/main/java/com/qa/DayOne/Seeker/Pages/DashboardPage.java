package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.DayOne.Seeker.base.TestBase.driver;

public class DashboardPage {



    @FindBy(xpath = "//button[text()='Create new opportunity']")
    WebElement createNewOppBlankPage;

    @FindBy (id = "createNewOpportunity")
    WebElement createNewOppAfterCreate;

    @FindBy(xpath = "(//button[@id='viewOpportunity'])[1]")
    WebElement viewMatch;

    @FindBy(xpath = "//div[@title='Past']")
    WebElement pastOpportunity;

    @FindBy(xpath = "//div[@title='Draft']")
    WebElement draftOpportunity;

    @FindBy(xpath = "(//h4[text()='Step']//..//*[local-name()='svg'])[1]")
    WebElement backgroundPage;

    @FindBy(xpath = "(//h4[text()='Step']//..//*[local-name()='svg'])[2]")
    WebElement valuesPage;

    @FindBy(xpath = "//a[text()='Dashboard']")
    WebElement dashboardbutton;

    @FindBy(xpath = "//span[text()='Opportunity Created']")
    WebElement oppCreatedToast;

    @FindBy(xpath = "//span[text()='Opportunity Saved as Draft']")
    WebElement saveAsDraftToast;

    @FindBy(xpath = "//div[@title='On-Going']")
    WebElement OngoingButton;


    public DashboardPage(){
        PageFactory.initElements(driver, this);

    }

    public String verifyDashboardPageTitle(){

        return driver.getTitle();
    }

    public boolean verifyOppName(String value){
        By oppNameLocator = By.xpath("//p[text()='" + value + "']");
        WebElement oppName = TestUtils.waitForElementPresence(driver, oppNameLocator, 15);
        return  oppName.isDisplayed();


    }

    public boolean verifyOppCreatedToast(){
        TestUtils.waitForElementVisibility(driver, oppCreatedToast, 5);

        return oppCreatedToast.isDisplayed();

    }

    public boolean verifySaveAsDraftCreatedToast(){
        TestUtils.waitForElementVisibility(driver, saveAsDraftToast, 5);

        return saveAsDraftToast.isDisplayed();

    }




    public boolean verifyDashboardNav(){
        TestUtils.waitForElementVisibility(driver, dashboardbutton, 5);

        return dashboardbutton.isDisplayed();
    }

    public boolean verifyDraftButtonVisible(){
        TestUtils.waitForElementVisibility(driver, draftOpportunity, 5);
        return draftOpportunity.isDisplayed();

    }

    public WebElement getDynamicLabel(String labelName) {
        String dynamicXpath = "//h1[text()='" + labelName + "']";
        return driver.findElement(By.xpath(dynamicXpath));
    }

    public boolean verifyLabelName(String labelName) {
        try {
            return getDynamicLabel(labelName).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }





    public OppPage clickOnCreateNewOpp(){

        try {
            // Attempt to wait for the 'viewMatch' element to be visible
            TestUtils.waitForElementVisibility(driver, viewMatch, 10);

            // If 'viewMatch' is visible, click the appropriate button
            if (viewMatch.isDisplayed()) {
                TestUtils.waitForElementToBeClickable(driver, createNewOppAfterCreate, 5);
                createNewOppAfterCreate.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            // Handle case when 'viewMatch' is not found (element is not yet in the DOM)
            // Proceed with the 'createNewOppBlankPage' click as this happens before the element is visible
            TestUtils.waitForElementToBeClickable(driver, createNewOppBlankPage, 5);
            createNewOppBlankPage.click();
        }

        return new OppPage();
    }


    public PastOppPage clickOnPastOpportunity(){
        TestUtils.waitForElementToBeClickable(driver, pastOpportunity, 10);

        pastOpportunity.click();
        return new PastOppPage();
    }

    public DraftOppPage clickOnDraftOpportunity(){
        TestUtils.waitForElementToBeClickable(driver, draftOpportunity, 10);

        draftOpportunity.click();
        return new DraftOppPage();

    }

    public BackgroundPage clickOnBackgroundPage(){
        TestUtils.waitForElementToBeClickable(driver, backgroundPage, 5);

        backgroundPage.click();
        return new BackgroundPage();

    }

    public ValuesPage clickOnValuesPage(){
        TestUtils.waitForElementToBeClickable(driver, valuesPage, 10);

        valuesPage.click();
        return new ValuesPage();

    }


}
