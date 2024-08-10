package com.automation.reports;

public class ExtentLogger {

    public static void pass(String message)
    {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail (String message)
    {
        ExtentReportManager.getExtentTest().fail(message);
        System.out.println("FAIL: " + message);
    }

    public static void info(String message)
    {
        ExtentReportManager.getExtentTest().info(message);
    }

    public static void skip(String message)
    {
        ExtentReportManager.getExtentTest().skip(message);
    }
}
