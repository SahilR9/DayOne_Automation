package com.qa.DayOne.Seeker.Pages;

import com.qa.DayOne.Seeker.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class PastOppPage extends TestBase {

    public PastOppPage(){
        PageFactory.initElements(driver, this);

    }

    public String verifyPastOppPageTitle(){
        return driver.getTitle();
    }
}
