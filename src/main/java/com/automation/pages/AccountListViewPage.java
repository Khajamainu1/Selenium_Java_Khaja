package com.automation.pages;

import com.automation.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountListViewPage extends BasePage {

public AccountListViewPage ()
{
    PageFactory.initElements(Driver.getDriver(), this);

}

@FindBy(id="Accounts_listView_basicAction_LBL_ADD_RECORD")
    WebElement btn_addAccount;

@FindBy(xpath="//a[text()='Cart']")
WebElement btn_addCart;

    public void clickAddCart()
    {
        click(btn_addCart, "Add Cart");
    }

public void clickAddAccount()
{
    click(btn_addAccount, "Add Account");
}



}
