package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackgroundPage extends TestBase {

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[1]")
    WebElement comStory;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[2]")
    WebElement products;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[3]")
    WebElement customerHelp;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[4]")
    WebElement unique;

    @FindBy(id="awardTitle-0")
    WebElement awardTitle;

    @FindBy(id="awardIssueDate-0")
    WebElement issueDate;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor')])[5]")
    WebElement awardDescription;

    @FindBy(id = "linkedInUrl")
    WebElement linkedIn;

    @FindBy(id = "twitterUrl")
    WebElement x;

    @FindBy(id = "facebookUrl")
    WebElement facebook;

    @FindBy(id = "instagramUrl")
    WebElement instagram;

    @FindBy(id = "tiktokUrl")
    WebElement tiktok;

    @FindBy(id = "continueBtn")
    WebElement BgContinue;







    public BackgroundPage(){
        PageFactory.initElements(driver, this);

    }




    public String verifyBackgroundPageTitle(){
        TestUtils.waitForTitle(driver, "Day One - Background", 20);
        return driver.getTitle();
    }

    public void fillCompanyStory(String story) {
        TestUtils.waitForElementVisibility(driver, comStory, 4);
        if (!comStory.getText().isEmpty()) {
            comStory.sendKeys(Keys.CONTROL + "a");  // Select all text
            comStory.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        comStory.sendKeys(story);
        TestUtils.waitForElementVisibility(driver, comStory, 4);

    }

    public void fillProducts(String prod) {
        TestUtils.waitForElementVisibility(driver, products , 4);
        if (!products.getText().isEmpty()) {
            products.sendKeys(Keys.CONTROL + "a");  // Select all text
            products.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        products.sendKeys(prod);
        TestUtils.waitForElementVisibility(driver, products , 4);

    }

    public void fillCustomerHelp(String help) {
        TestUtils.waitForElementVisibility(driver, customerHelp, 4);
        if (!customerHelp.getText().isEmpty()) {
            customerHelp.sendKeys(Keys.CONTROL + "a");  // Select all text
            customerHelp.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }

        customerHelp.sendKeys(help);
        TestUtils.waitForElementVisibility(driver, customerHelp, 4);

    }

    public void fillUniqueFeature(String uni) {
        if (!unique.getText().isEmpty()) {
            unique.sendKeys(Keys.CONTROL + "a");  // Select all text
            unique.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        unique.sendKeys(uni);
    }

    // Award Details
    public void fillAwardTitle(String title) {
        if (!awardTitle.getAttribute("value").isEmpty()) {
            awardTitle.sendKeys(Keys.CONTROL + "a");  // Select all text
            awardTitle.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        awardTitle.sendKeys(title);
        TestUtils.waitForElementVisibility(driver, awardTitle, 4);

    }

    public void fillAwardIssueDate(String date) {
        issueDate.sendKeys(date);
    }

    public void fillAwardDescription(String description) {
        TestUtils.waitForElementVisibility(driver, awardDescription, 4);

        if (!awardDescription.getText().isEmpty()) {
            awardDescription.sendKeys(Keys.CONTROL + "a");  // Select all text
            awardDescription.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }


        awardDescription.sendKeys(description);

        TestUtils.waitForElementVisibility(driver, awardDescription, 4);

    }

    // Social Media Links
    public void fillLinkedIn(String linked) {
        if (!linkedIn.getAttribute("value").isEmpty()) {
            linkedIn.sendKeys(Keys.CONTROL + "a");  // Select all text
            linkedIn.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        linkedIn.sendKeys(linked);
    }

    public void fillX(String xt) {
        if (!x.getAttribute("value").isEmpty()) {
            x.sendKeys(Keys.CONTROL + "a");  // Select all text
            x.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        x.sendKeys(xt);
    }

    public void fillFacebook(String fb) {
        if (!facebook.getAttribute("value").isEmpty()) {
            facebook.sendKeys(Keys.CONTROL + "a");  // Select all text
            facebook.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        facebook.sendKeys(fb);
    }

    public void fillInstagram(String insta) {
        if (!instagram.getAttribute("value").isEmpty()) {
            instagram.sendKeys(Keys.CONTROL + "a");  // Select all text
            instagram.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        instagram.sendKeys(insta);
    }

    public void fillTiktok(String tik) {
        if (!tiktok.getAttribute("value").isEmpty()) {
            tiktok.sendKeys(Keys.CONTROL + "a");  // Select all text
            tiktok.sendKeys(Keys.BACK_SPACE);     // Delete the selected text
        }
        tiktok.sendKeys(tik);
    }

    public ValuesPage backgroundContinue(){
        TestUtils.waitForElementToBeClickable(driver, BgContinue , 10);
        BgContinue.click();
        return new ValuesPage();

    }


    // Getter methods for assertions
    public String getCompanyStory() {
        return comStory.getText();
    }

    public String getProducts() {
        return products.getText();
    }

    public String getCustomerHelp() {
        return customerHelp.getText();
    }

    public String getUniqueFeature() {
        return unique.getText();
    }

    public String getAwardTitle() {
        return awardTitle.getAttribute("value");
    }

    public String getAwardIssueDate() {
        return issueDate.getAttribute("value");
    }

    public String getAwardDescription() {
        return awardDescription.getText();
    }

    public String getLinkedInUrl() {
        return linkedIn.getAttribute("value");
    }

    public String getXUrl() {
        return x.getAttribute("value");
    }

    public String getFacebookUrl() {
        return facebook.getAttribute("value");
    }

    public String getInstagramUrl() {
        return instagram.getAttribute("value");
    }

    public String getTiktokUrl() {
        return tiktok.getAttribute("value");
    }



}
