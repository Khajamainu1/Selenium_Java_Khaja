package com.automation.driver;

import com.automation.enums.ConfigProperties;
import com.automation.utils.PropertyUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver() {
    }

   private static WebDriver driver;


    public static WebDriver initDriver() {
    String browserType = PropertyUtils.get(ConfigProperties.BROWSER);

        if (browserType == null || browserType.isEmpty()) {
            throw new IllegalArgumentException("Browser type is not specified in the properties file.");
        }

        if (driver == null) {
            switch (browserType.toLowerCase()) {

                case "chrome":

                    driver = new ChromeDriver();

                    break;

                case "firefox":

                    driver = new FirefoxDriver();
                    break;

                case "edge":

                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Browser type not supported :" + browserType);


            }
        }
//        driver.get(PropertyUtils.get(ConfigProperties.CRMURL));

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        return driver;

    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

        public static WebDriver getDriver()
        {
        return driver;
        }



    }


