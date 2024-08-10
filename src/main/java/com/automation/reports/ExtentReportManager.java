package com.automation.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
   public static ExtentReports getInstance() {
       if(extentReports==null) {
           extentReports = new ExtentReports();
           ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
           extentReports.attachReporter(extentSparkReporter);
       }
       return extentReports;
   }

   public static void  setExtentTest(ExtentTest testName)
   {
       extentTest.set(testName);
   }

   public static ExtentTest getExtentTest()
   {

      return extentTest.get();
   }


}
