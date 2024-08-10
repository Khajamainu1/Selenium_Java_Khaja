package com.automation.listeners;

import com.automation.driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.DriverManager;

public class AllureListners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    @Attachment
    public void onTestSuccess(ITestResult result) {
        result.getMethod().getMethodName().toLowerCase();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenShot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }



    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Attachment(value ="Screenshot on failure", type = "image/png")
    public byte[] captureScreenShot()
    {
        WebDriver driver = Driver.getDriver();
       return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
