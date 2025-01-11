package com.qa.DayOne.Seeker.Utils;

import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class WebDriverEventListener extends TestBase implements WebDriverListener {

    private WebDriver driver;
    private final Set<String> loggedLocators = new HashSet<>(); // Track logged locators to prevent repetition
    private Set<String> capturedExceptions = new HashSet<>(); // Store captured exception messages



    public WebDriverEventListener(WebDriver driver) {
        this.driver = driver;
    }



    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Before navigating to URL: " + url);
    }

    public void afterGet(WebDriver driver, String url) {
        System.out.println("After navigating to URL: " + url);
    }

    public void beforeFindElement(WebDriver driver, By locator) {
        String locatorString = locator.toString();
        if (!loggedLocators.contains(locatorString)) {
            System.out.println("Before finding element by: " + locator);
            loggedLocators.add(locatorString);
        }
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


    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        String exceptionMessage = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();

        // Check if the exception is a NoSuchElementException and was not handled in the method
        if (e.getCause() instanceof NoSuchElementException) {
            // Retry logic for @FindBy elements or regular By locators
            int retryCount = Integer.parseInt(pr.getProperty("retry.count"));
            long timeoutMs = Long.parseLong(pr.getProperty("timeout.ms"));

            // Retry logic for @FindBy elements or regular By locators
            boolean isElementFound = retryForFindByOrLocator(target, args, retryCount, timeoutMs);

            if (!isElementFound) {
                handleNoSuchElementException(exceptionMessage);
            }
        }
    }

    /**
     * Retries finding elements, whether they are @FindBy WebElements or By locators.
     *
     * @param target      The target object.
     * @param args        The arguments passed to the method, typically includes the WebElement or locator.
     * @param retryCount  Number of retries.
     * @param timeoutMs   Total timeout duration in milliseconds.
     * @return true if the element is found; false otherwise.
     */
    private boolean retryForFindByOrLocator(Object target, Object[] args, int retryCount, long timeoutMs) {
        if (args == null || args.length == 0) {
            return false; // No arguments to process
        }

        Object potentialElement = args[0];
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMs / retryCount));

        for (int i = 0; i < retryCount; i++) {
            try {
                // Case 1: If argument is WebElement (@FindBy fields)
                if (potentialElement instanceof WebElement) {
                    WebElement element = (WebElement) potentialElement;
                    wait.until(ExpectedConditions.visibilityOf(element));
                    return true; // Element is visible
                }

                // Case 2: If argument is By locator
                if (potentialElement instanceof By) {
                    By locator = (By) potentialElement;
                    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                    return true; // Element is present
                }
            } catch (TimeoutException ex) {
            }
        }
        return false; // All retries failed
    }

    /**
     * Handles NoSuchElementException by capturing a screenshot and logging the exception.
     *
     * @param exceptionMessage The exception message to identify unique cases.
     */
    private void handleNoSuchElementException(String exceptionMessage) {
        synchronized (capturedExceptions) {
            // Capture screenshot only if it has not been captured already
            if (!capturedExceptions.contains(exceptionMessage)) {
                try {
                    TestUtils.takeScreenshotAtEndOfTest(driver); // Capture screenshot
                    System.out.println("Screenshot captured successfully for NoSuchElementException.");
                    capturedExceptions.add(exceptionMessage); // Mark the exception as handled
                } catch (IOException ioException) {
                    System.err.println("Failed to capture screenshot: " + ioException.getMessage());
                }
            } else {
                System.out.println("Screenshot already captured for this exception.");
            }
        }
    }


    public void beforeQuit(WebDriver driver) {
        System.out.println("Before quitting the WebDriver.");
    }

    public void afterQuit(WebDriver driver) {
        System.out.println("After quitting the WebDriver.");
    }


}
