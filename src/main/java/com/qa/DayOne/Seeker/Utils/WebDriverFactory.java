package com.qa.DayOne.Seeker.Utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory {

    public WebDriver createWebDriver(String browser) {
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(getFirefoxOptions());
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(getEdgeOptions());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Wrap WebDriver with EventFiringDecorator and WebDriverEventListener
        WebDriverEventListener eventListener = new WebDriverEventListener(driver);
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        return decorator.decorate(driver);



    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        return options;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
