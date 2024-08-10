package com.automation.basetest;

import com.automation.driver.Driver;
import com.automation.reports.AllureReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

    @AfterSuite
    protected void allureReport()
    {
        AllureReports.generateAndOpenAllureReport();
    }



}
