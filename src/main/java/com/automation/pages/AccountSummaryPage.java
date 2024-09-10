package com.automation.pages;

import com.automation.driver.Driver;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//button[@class='btn btn-default dropdown-toggle'])[1]")
    WebElement btn_more;

    @FindBy(id="Accounts_detailView_moreAction_Add_Service_Account")
    WebElement btn_AddServiceAccount;

    public void clickMore()
    {
        presenceOfElementLocated(By.xpath("(//button[@class='btn btn-default dropdown-toggle'])[1]"));
        click(btn_more, "More Button");
    }


    public void kycVerification() {
        presenceOfElementLocated(By.xpath("//td[contains(text(), 'KYC Verified successfully!')]"));
        presenceOfElementLocated(By.xpath("//td[contains(text(), 'KYC Verified successfully!')]"));
    }

    public void addServiceAccount()
    {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        clickMore();
        click(btn_AddServiceAccount, "Add Service Account");

    }

}
