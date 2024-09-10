package com.automation.pages;

import com.automation.driver.Driver;
import com.automation.utils.RandamUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AccountCreationPage extends BasePage {

  public AccountCreationPage()
  {
      PageFactory.initElements(Driver.getDriver(), this);
  }

    @FindBy(id="Accounts_editView_fieldName_accountname")
    WebElement txt_accountName;

    @FindBy(xpath = "//select[@name='accounttype']")
    WebElement dropdown_CustomerType;

    @FindBy(id = "Accounts_editView_fieldName_primary_contact_create")
    WebElement btn_createContact;

    @FindBy(id = "Contacts_editView_fieldName_firstname")
    WebElement txt_firstName;

  @FindBy(id = "Contacts_editView_fieldName_lasstname")
  WebElement txt_lastName;

  @FindBy(id = "Contacts_editView_fieldName_mobile")
  WebElement txt_mobileNumber;



  @FindBy(id = " Contacts_editView_fieldName_email")
  WebElement txt_email;

  @FindBy(id = "Contacts_editView_fieldName_birthday")
  WebElement txt_dob;

  @FindBy(id = "Contacts_editView_fieldName_nationalIdNum")
  WebElement txt_idNumber;

  @FindBy(id = "Contacts_editView_fieldName_mailinghouseno")
  WebElement txt_mailingHouseNo;



  @FindBy(xpath = "//textarea[@name='mailingstreet']")
  WebElement txt_mailingStreet;

  @FindBy(xpath = "//select[@data-fieldname='nationalidproof']")
  WebElement dropdown_nationalIDProof;

  @FindBy(id = "Contacts_editView_fieldName_mailingcity")
  WebElement txt_mailingCity;

  @FindBy(id = "Contacts_editView_fieldName_mailingzip")
  WebElement txt_mailingZip;

  @FindBy(xpath = "//button[@name='saveButton']")
  WebElement btn_ContactSave;

  @FindBy(xpath = "//button[text()='Save']")
  WebElement btn_Save;


  @FindBy(xpath = "//a[@title='Switch to v7 Layout']")
  WebElement btn_Eye;

  @FindBy(xpath = "//select[@data-fieldname='platform']")
  WebElement dropdown_platform;

    public void enterAccountName()
    {
        sendKeys(txt_accountName, RandamUtils.getFirstName(),"Account Name");
    }


    public void enterAccountname(String accountName)
    {
      sendKeys(txt_accountName, accountName, "Account Name");
    }

    public void selectCustomerType(String customerType)
    {
      selectDropDownOption(dropdown_CustomerType, customerType, "Customer Type");
    }


    public void clickSave()
    {

      click(btn_Save, "Button Save");
      visibilityOfElementLocated(By.xpath("//a[@title='Switch to v7 Layout']"));
      GlobalUtilities utilities = new GlobalUtilities();
      utilities.click360();
    }
    public void quickCreateContact()
    {
      click(btn_createContact, "Create Contact");
      presenceOfElementLocated(By.xpath("//h4[text()='Quick Create Contact']"));
      Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
      sendKeys(txt_firstName,RandamUtils.getFirstName(),"First Name");
      sendKeys(txt_lastName,RandamUtils.getLastName(),"Last Name");
      sendKeys(txt_idNumber, RandamUtils.getmobileNumber(), "Mobile Number");
      sendKeys(txt_email, RandamUtils.getEmail(),"Eamil");
      sendKeys(txt_dob, "20-02-1999", "DOB");
      sendKeys(txt_idNumber, RandamUtils.getNumber(), "ID Number");
      sendKeys(txt_mailingHouseNo, RandamUtils.getNumber(), "Mailing House Number");
      selectDropDownOption(dropdown_nationalIDProof, "NIN","National ID Proof");

      WebElement element = Driver.getDriver().findElement(By.xpath("//select[@data-fieldname='mailingcountry']"));
      element.sendKeys(Keys.PAGE_DOWN);
      element.sendKeys(Keys.BACK_SPACE);
      sendKeys(txt_mailingStreet, RandamUtils.getStreet(), "Mailing Street");
      sendKeys(txt_mailingCity, RandamUtils.getCity(), "Mailing City");
      sendKeys(txt_mailingZip, "300AB", "ZIP Code");
      click(btn_ContactSave, "Save Button");

      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Quick Create Contact']")));


    }



    public void selectPlatform(String value)
    {
      selectDropDownOption(dropdown_platform, value, "Platform");
    }
}
