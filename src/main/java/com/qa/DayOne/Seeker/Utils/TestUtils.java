package com.qa.DayOne.Seeker.Utils;


import com.qa.DayOne.Seeker.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TestUtils extends TestBase {


    public static String opportunityName; // Shared static variable



    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        // Capture the screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the directory path for saving screenshots
        String currentDir = System.getProperty("user.dir") + "//screenshots//";
        File screenshotDir = new File(currentDir);

        // Create the directory if it doesn't exist
        if (!screenshotDir.exists() && !screenshotDir.mkdirs()) {
            System.err.println("Failed to create screenshot directory: " + screenshotDir.getAbsolutePath());
            return;
        }

        // Define the file path for the screenshot
        String screenshotPath = currentDir + System.currentTimeMillis() + ".png";

        // Save the screenshot to the defined path
        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void switchToFrame(){
        driver.switchTo().frame("");
    }

    // Method to set value of an input field using JavaScript
    public static void setInputFieldValue(WebDriver driver, WebElement element, String value) {
        // Check if driver and element are not null
        if (driver != null && element != null) {
            // Use JavascriptExecutor to set the value
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", element, value);
        }
    }



    public static void selectDropdownValue(String value) {
        List<WebElement> options = driver.findElements(By.xpath("//div[@title]")); // Locate all options by title
        for (WebElement option : options) {
            if (option.getAttribute("title").equals(value)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                option.click(); // Select the option

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.attributeContains(option, "class", "selected")); // Replace 'selected' with actual class indicating selection
                break;
            }
        }
    }

    public static String getSelectedDropdownValue(WebDriver driver, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait until the dropdown option with the specific value is visible
            WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='" + expectedValue + "']")
            ));
            return selectedOption.getText();
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Could not find the selected option with title: " + expectedValue);
        }
    }



    public static void scrollToAndFill(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)); // Wait for visibility
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(value);
    }


    // Explicit wait for an element to be visible
    public static void waitForElementVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element)); // Wait until the element is visible
        } catch (TimeoutException e) {
            System.out.println("Timeout: Element not visible after waiting for " + timeoutInSeconds + " seconds");
        }
    }

    public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout: Element not present in the DOM after " + timeoutInSeconds + " seconds. Locator: " + locator);
        } catch (Exception e) {
            System.err.println("Error while waiting for element. Locator: " + locator + ". Error: " + e.getMessage());
        }
        return null;
    }

    public static void waitForTextToBePresentInElementValue(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public static void waitForElementToDisappear(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Wait for an element to be clickable.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for
     * @param timeoutInSeconds Timeout in seconds
     */
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Timeout: Element not clickable after " + timeoutInSeconds + " seconds.");
        }
    }

    /**
     * Wait for an alert to be present.
     *
     * @param driver WebDriver instance
     * @param timeoutInSeconds Timeout in seconds
     */
    public static void waitForAlertPresence(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            System.out.println("Timeout: Alert not present after " + timeoutInSeconds + " seconds.");
        }
    }






}
