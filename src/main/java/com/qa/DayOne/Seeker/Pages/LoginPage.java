package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {
    @FindBy(id = "identifier")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);

    }


    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public DashboardPage login(String un, String pwd){
        // Wait for the email input field to be visible and then send keys
        TestUtils.waitForElementVisibility(driver, email, 10);
        email.sendKeys(un);

        // Wait for the password input field to be visible and then send keys
        TestUtils.waitForElementVisibility(driver, password, 10);
        password.sendKeys(pwd);

        // Wait for the login button to be clickable and then click it
        TestUtils.waitForElementToBeClickable(driver, loginButton, 10);
        loginButton.click();

        return new DashboardPage();
    }



}
