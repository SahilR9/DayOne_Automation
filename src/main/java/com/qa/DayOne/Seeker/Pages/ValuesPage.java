package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValuesPage extends TestBase {

    @FindBy(xpath = "//div[text()='Values']")
    WebElement valuesButton;

    @FindBy (xpath = "//input[@type='search']")
    WebElement coreValues;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[1]")
    WebElement thrive;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[2]")
    WebElement diversify;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[3]")
    WebElement support;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[4]")
    WebElement future;

    @FindBy(id = "finishSetupBtn")
    WebElement finishSetUp;

    @FindBy(id = "companyRepresentativeCreateOpp")
    WebElement goToDashboard;

    public ValuesPage(){
        PageFactory.initElements(driver, this);

    }

    public String verifyValuesPageTitle(){
        TestUtils.waitForTitle(driver, "Day One - Values", 20);
        return driver.getTitle();
    }

    public boolean verifyValuesButton(){
        TestUtils.waitForElementVisibility(driver, valuesButton, 10);
        return valuesButton.isDisplayed();
    }

    // Method to select core values
    public void selectCoreValues(String value1, String value2) {
        TestUtils.waitForElementVisibility(driver, coreValues, 5);
        coreValues.click();

        TestUtils.selectDropdownValue(value1);
        TestUtils.selectDropdownValue(value2);

        // Move focus to avoid dropdown issues
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();
    }

    // Method to fill thrive value
    public void fillThrive(String tri) {
        TestUtils.scrollToElement(driver, thrive);
        if (!thrive.getText().isEmpty()) {
            thrive.sendKeys(Keys.CONTROL + "a");  // Select all text
            thrive.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        thrive.sendKeys(tri);

    }

    // Method to fill diversify value
    public void fillDiversify(String div) {
        TestUtils.scrollToElement(driver, diversify);

        if (!diversify.getText().isEmpty()) {
            diversify.sendKeys(Keys.CONTROL + "a");  // Select all text
            diversify.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        diversify.sendKeys(div);
    }

    // Method to fill support value
    public void fillSupport(String supp) {
        TestUtils.scrollToElement(driver, support);

        if (!support.getText().isEmpty()) {
            support.sendKeys(Keys.CONTROL + "a");  // Select all text
            support.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        support.sendKeys(supp);
    }

    // Method to fill future value
    public void fillFuture(String fut) {

        TestUtils.scrollToElement(driver, future);

        if (!future.getText().isEmpty()) {
            future.sendKeys(Keys.CONTROL + "a");  // Select all text
            future.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        future.sendKeys(fut);
    }

    // Method to click finish setup
    public void clickFinishSetup() {
        TestUtils.waitForElementToBeClickable(driver, finishSetUp, 10);
        finishSetUp.click();
    }

    public DashboardPage clickGoToDashboard() {
        TestUtils.waitForElementToBeClickable(driver, finishSetUp, 10);
        goToDashboard.click();
        return new DashboardPage();
    }

    // Getter Methods for Assertions

    public String getValue1(String value1){
        return TestUtils.getSelectedDropdownValue(driver, value1);
    }

    public String getValue2(String value2){
        return TestUtils.getSelectedDropdownValue(driver, value2);
    }



    public String getThriveValue() {
        return thrive.getText();
    }

    public String getDiversifyValue() {
        return diversify.getText();
    }

    public String getSupportValue() {
        return support.getText();
    }

    public String getFutureValue() {
        return future.getText();
    }




    }


