package com.automation.pages;

import com.automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


    protected void click (WebElement element, String elementName)
    {
        element.click();
        System.out.println(elementName +" is clicked");
    }

    protected void sendKeys(WebElement element, String value, String elementName)
    {
        element.sendKeys(value);
        System.out.println(value + " is entered in " +elementName +" field");
    }

    protected void selectDropDownOption(WebElement element, String valueToBeSelected, String dropDownName)
    {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(valueToBeSelected);
        System.out.println(valueToBeSelected +" is selected from the " +dropDownName +"dropdown");
    }

   protected void clickUsingJavaScriptExecutor(WebElement element, String elementName)
   {
       JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       executor.executeScript("arguments[0].click()", element);
       System.out.println(elementName + " is clicked");

   }

   protected void scrollDown(WebElement element)
   {
       JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       executor.executeScript("arguments[0].scrollIntoView()", element);
   }

   protected  void scrollUp(WebElement element)
   {
       JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       executor.executeScript("argument[0].scrollIntoView()", element);
   }

   protected String getText(WebElement element, String elementName)
   {
       return element.getText().trim();
   }

    protected static void visibilityOfElementLocated(By by)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected  static void presenceOfElementLocated(By by)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected static void elementToBeClickable(By by)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
