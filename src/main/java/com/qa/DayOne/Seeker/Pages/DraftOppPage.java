package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftOppPage extends TestBase {


    @FindBy(xpath = "//a[text()='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//a[text()='Edit']")
    WebElement editDraftButton;

    @FindBy(xpath = "//span[text()='Edit Title']")
    WebElement editTitle;

    @FindBy (id = "opportunityTitle")
    WebElement oppTitle;

    @FindBy(id = "opportunityPagePublish")
    WebElement oppPublish;





    public DraftOppPage(){
        PageFactory.initElements(driver, this);

    }

    public String verifyDraftPageTitle(){
        return driver.getTitle();
    }

    public void clickOnDraftOpp(String value) {

        By draftOppThreeDotLocator = By.xpath("//div[text()='" + value + "']/following::div[contains(@class, 'ant-dropdown-trigger')][1]");

        WebElement draftOppThreeDot = TestUtils.waitForElementPresence(driver, draftOppThreeDotLocator, 10);

        if (draftOppThreeDot != null) {
            // Perform the click action using Actions
            Actions actions = new Actions(driver);
            actions.moveToElement(draftOppThreeDot).click().perform();
        } else {
            System.err.println("The three-dot element for the opportunity '" + value + "' was not found within the timeout period.");
        }
    }

    public void clickOnEditDraft(){
        TestUtils.waitForElementToBeClickable(driver, editDraftButton, 10);
        editDraftButton.click();

    }



    public void clickOnDelete(){
        TestUtils.waitForElementVisibility(driver, deleteButton, 10);

        deleteButton.click();
    }

    public void clickEditTitle(){
        TestUtils.waitForElementToBeClickable(driver, editTitle, 10);
        editTitle.click();
    }

}
