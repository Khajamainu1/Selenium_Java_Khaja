package com.automation.listeners;

import com.automation.driver.Driver;
import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ExtentReportListner implements ITestListener {

    private static ExtentReports extentReports = ExtentReportManager.getInstance();
    private  static ExtentTest extentTest = ExtentReportManager.getExtentTest();


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getDescription();
        if (testName == null || testName.isEmpty()) {
            testName = result.getMethod().getMethodName();
        }
//        ExtentReportManager.startTest(testName);
        extentTest= extentReports.createTest(testName);
        ExtentReportManager.setExtentTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (extentTest != null) {
            ExtentLogger.pass(result.getMethod().getMethodName()+"is passed");
            ExtentLogger.info("Test "+result.getMethod().getMethodName() +" is completed successfully");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (extentTest != null) {
            String base64Screenshot = getBase64Image(Driver.getDriver());
            extentTest.fail(result.getMethod().getMethodName() + " failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           extentTest.fail(result.getThrowable().toString());
////            ExtentLogger.info(result.getMethod().getMethodName());


        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (extentTest != null) {
            extentTest.skip("Test Case Skipped");
            extentTest.info("Test "+result.getMethod().getMethodName()+" was skipped");
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onFinish(ITestContext context) {
       extentReports.flush();
       try{
           Desktop.getDesktop().browse(new File("target/ExtentReports/ExtentReport.html").toURI());
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }


    public static String getBase64Image(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}

