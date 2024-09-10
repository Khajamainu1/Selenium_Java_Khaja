package com.automation.basetest;

import com.automation.driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected BaseTest()
    {}

    private Process allureServerProcess;




    @BeforeTest
    protected void setup()
    {
        Driver.initDriver();
    }

    @AfterSuite
    protected void tearDown()
    {

        Driver.quitDriver();

    }

//    @AfterSuite
//    protected void allureReport()
//    {
//        AllureReports.generateAndOpenAllureReport();
//    }
//


}
