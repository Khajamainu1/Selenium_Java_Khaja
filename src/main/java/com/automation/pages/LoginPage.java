package com.automation.pages;

import com.automation.driver.Driver;
import com.automation.enums.ConfigProperties;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    public LoginPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="username")
    WebElement txt_userName;

    @FindBy(id="password")
    WebElement txt_password;

    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement btn_submit;

    public void enterUserName(String userName)
    {
        sendKeys(txt_userName, userName, "UserName");
    }

    public void enterPassword(String password)
    {
        sendKeys(txt_password, password, "Password");
    }
    public void loginCRM(String userName, String password)
    {
    enterUserName(userName);
    enterPassword(password);
    click(btn_submit, "Submit");
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }

}
