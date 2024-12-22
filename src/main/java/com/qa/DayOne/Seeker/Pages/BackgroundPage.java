package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
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
        return driver.getTitle();
    }

    public void fillCompanyStory(String story) {
        TestUtils.waitForElementVisibility(driver, comStory, 4);
        comStory.clear();
        comStory.sendKeys(story);
        TestUtils.waitForElementVisibility(driver, comStory, 4);

    }

    public void fillProducts(String prod) {
        TestUtils.waitForElementVisibility(driver, products , 4);
        products.clear();
        products.sendKeys(prod);
        TestUtils.waitForElementVisibility(driver, products , 4);

    }

    public void fillCustomerHelp(String help) {
        TestUtils.waitForElementVisibility(driver, customerHelp, 4);
        customerHelp.clear();

        customerHelp.sendKeys(help);
        TestUtils.waitForElementVisibility(driver, customerHelp, 4);

    }

    public void fillUniqueFeature(String uni) {
        unique.clear();

        unique.sendKeys(uni);
    }

    // Award Details
    public void fillAwardTitle(String title) {
        awardTitle.clear();
        awardTitle.sendKeys(title);
        TestUtils.waitForElementVisibility(driver, awardTitle, 4);

    }

    public void fillAwardIssueDate(String date) {
        issueDate.sendKeys(date);
    }

    public void fillAwardDescription(String description) {
        TestUtils.waitForElementVisibility(driver, awardDescription, 4);
        awardDescription.clear();

        awardDescription.sendKeys(description);

        TestUtils.waitForElementVisibility(driver, awardDescription, 4);

    }

    // Social Media Links
    public void fillLinkedIn(String linked) {
        linkedIn.clear();
        linkedIn.sendKeys(linked);
    }

    public void fillX(String xt) {
        x.clear();
        x.sendKeys(xt);
    }

    public void fillFacebook(String fb) {
        facebook.clear();
        facebook.sendKeys(fb);
    }

    public void fillInstagram(String insta) {
        instagram.clear();
        instagram.sendKeys(insta);
    }

    public void fillTiktok(String tik) {
        tiktok.clear();
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
