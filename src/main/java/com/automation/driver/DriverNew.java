package com.automation.driver;

import com.automation.enums.ConfigProperties;
import com.automation.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverNew {

    private DriverNew() {
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        String browserType = PropertyUtils.get(ConfigProperties.BROWSER);
        String runMode = PropertyUtils.get(ConfigProperties.EXECUTION);

        if (browserType == null || browserType.isEmpty()) {
            throw new IllegalArgumentException("Browser type is not specified in the properties file.");
        }

        if (driver.get() == null) {
            if (runMode.equalsIgnoreCase("docker")) {
                driver.set(initRemoteDriver(browserType));
            } else {
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        chromeOptions.addArguments("--start-maximized");
                        driver.set(new ChromeDriver(chromeOptions));
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--disable-notifications");
                        firefoxOptions.addArguments("--start-maximized");
                        driver.set(new FirefoxDriver(firefoxOptions));
                        break;
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--start-maximized");
                        driver.set(new EdgeDriver(edgeOptions));
                        break;
                    default:
                        throw new IllegalArgumentException("Browser type not supported: " + browserType);
                }
            }
        }

        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
            driverInstance.get(PropertyUtils.get(ConfigProperties.CRMURL));
//            driverInstance.manage().window().maximize();
            driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverInstance;
    }

    private static WebDriver initRemoteDriver(String browserType) {
        try {
            RemoteWebDriver driver;
            switch (browserType.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("browserName", "chrome");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("browserName", "firefox");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setCapability("browserName", "edge");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Browser type not supported: " + browserType);
            }
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Malformed URL for the RemoteWebDriver hub");
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}