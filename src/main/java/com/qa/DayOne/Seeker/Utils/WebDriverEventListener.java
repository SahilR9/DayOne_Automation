package com.qa.DayOne.Seeker.Utils;

import com.qa.DayOne.Seeker.Utils.TestUtils;
import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.WebDriverListener;

import javax.sound.midi.Sequence;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebDriverEventListener extends TestBase implements WebDriverListener {

    private WebDriver driver;

    public WebDriverEventListener(WebDriver driver) {
        this.driver = driver;
    }

    public void onException(Throwable error, WebDriver driver) {
        // Log the exception details
        System.out.println("Exception occurred: " + error.getMessage());
        error.printStackTrace(); // Print the full stack trace for better debugging

        // Attempt to capture a screenshot
        try {
            System.out.println("Attempting to capture screenshot...");
            TestUtils.takeScreenshotAtEndOfTest(driver); // Pass the driver explicitly
            System.out.println("Screenshot captured successfully.");
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            e.printStackTrace(); // Log the error for capturing the screenshot
        }
    }

    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Before navigating to URL: " + url);
    }

    public void afterGet(WebDriver driver, String url) {
        System.out.println("After navigating to URL: " + url);
    }

    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before finding element by: " + locator);
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("After finding element by: " + locator);
    }

    public void beforeClick(WebElement element) {
        System.out.println("Before clicking on element.");
    }

    public void afterClick(WebElement element) {
        System.out.println("After clicking on element.");
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Before sending keys to element.");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("After sending keys to element.");
    }

    public void beforeGetText(WebElement element) {
        System.out.println("Before getting text from element.");
    }

    public void afterGetText(WebElement element, String result) {
        System.out.println("After getting text from element: " + result);
    }

    public void beforeSubmit(WebElement element) {
        System.out.println("Before submitting a form element.");
    }

    public void afterSubmit(WebElement element) {
        System.out.println("After submitting a form element.");
    }

    public void beforeGetCurrentUrl(WebDriver driver) {
        System.out.println("Before getting current URL.");
    }

    public void afterGetCurrentUrl(String result, WebDriver driver) {
        System.out.println("After getting current URL: " + result);
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("Error while calling method: " + method.getName() + " - " + e.getMessage());
    }

    public void beforeQuit(WebDriver driver) {
        System.out.println("Before quitting the WebDriver.");
    }

    public void afterQuit(WebDriver driver) {
        System.out.println("After quitting the WebDriver.");
    }

}
