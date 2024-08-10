package com.automation.practice.tests;

import com.automation.basetest.BaseTest;
import com.automation.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice_1 extends BaseTest {


    @Test()

    public void openBrowser()
    {
        Driver.getDriver().get("https://amzaon.com/");
    }
}
