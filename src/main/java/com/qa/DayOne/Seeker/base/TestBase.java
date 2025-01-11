package com.qa.DayOne.Seeker.base;


import com.qa.DayOne.Seeker.Utils.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class TestBase  {

    public static WebDriver driver;
    public static Properties pr;





    public TestBase(){

        try{
            pr = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//com//qa//DayOne//Seeker//Config//config.properties");
            pr.load(ip);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();

        }

    }

    public static void initialisation(){

        String browserName = pr.getProperty("browser");
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(browserName);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(pr.getProperty("UAT_url"));
       }


}

