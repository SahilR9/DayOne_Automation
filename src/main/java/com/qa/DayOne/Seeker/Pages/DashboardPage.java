package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.DayOne.Seeker.base.TestBase.driver;

public class DashboardPage {



    @FindBy(xpath = "//button[@id='createNewOpportunity']")
    WebElement createNewOpp;

    @FindBy(id = "viewOpportunity")
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
        TestUtils.waitForTitle(driver, "Day One - Dashboard", 40);

        return driver.getTitle();
    }

    public boolean verifyOppName(String value){
        By oppNameLocator = By.xpath("//p[text()='" + value + "']");
        WebElement oppName = TestUtils.waitForElementPresence(driver, oppNameLocator, 20);
        return  oppName.isDisplayed();


    }

    public boolean viewMatchButton(){
        TestUtils.waitForElementVisibility(driver, viewMatch, 30);
        return viewMatch.isDisplayed();

    }

    public boolean verifyOppCreatedToast(){
        TestUtils.waitForElementVisibility(driver, oppCreatedToast, 10);

        return oppCreatedToast.isDisplayed();

    }

    public boolean verifySaveAsDraftCreatedToast(){
        TestUtils.waitForElementVisibility(driver, saveAsDraftToast, 10);

        return saveAsDraftToast.isDisplayed();

    }

    public OppViewMatches clickOnOppViewMatch(String value){
        By opViewMatchLoc = By.xpath("//p[text()='" + value + "']//..//following-sibling::div[2]//button");

        WebElement oppviewMatch = TestUtils.waitForElementPresence(driver, opViewMatchLoc, 10);

        if (oppviewMatch != null) {
            // Perform the click action using Actions
            Actions actions = new Actions(driver);
            actions.moveToElement(oppviewMatch).click().perform();
        } else {
            System.err.println("The three-dot element for the opportunity '" + value + "' was not found within the timeout period.");
        }

        return new OppViewMatches();

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
        String dynamicXpath = "(//h1[text()='" + labelName + "'])[1]";
        return driver.findElement(By.xpath(dynamicXpath));
    }

    public boolean verifyLabelName(String labelName) {
        TestUtils.waitForElementPresence(driver, By.xpath("(//h1[text()='" + labelName + "'])[1]"), 20);

        return getDynamicLabel(labelName).isDisplayed();
        }






    public OppPage clickOnCreateNewOpp() {
        TestUtils.waitForElementVisibility(driver, createNewOpp, 60);
        TestUtils.waitForElementToBeClickable(driver, createNewOpp, 60);
        createNewOpp.click();
        return new OppPage();
        }


    public boolean viewCreateNewOppButton() {
        TestUtils.waitForElementVisibility(driver, createNewOpp, 50);

        return createNewOpp.isDisplayed();
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
