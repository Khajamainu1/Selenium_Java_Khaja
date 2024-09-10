package com.automation.prepaidResidential.tests;

import com.automation.basetest.BaseTest;
import com.automation.enums.ConfigProperties;
import com.automation.pages.*;
import com.automation.utils.PropertyUtils;

import com.automation.utils.RandamUtils;
import org.testng.annotations.Test;

public class TC_Account_Onboarding extends BaseTest {


        @Test(description="Residential Onboarding")
        public void onboarding ()
        {
            LoginPage loginPage = new LoginPage();
            GlobalUtilities utilities = new GlobalUtilities();
            AccountListViewPage accountListViewPage = new AccountListViewPage();
            AccountCreationPage accountCreationPage = new AccountCreationPage();
            AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

            loginPage.loginCRM(PropertyUtils.get(ConfigProperties.CRMUSERNAME), PropertyUtils.get(ConfigProperties.CRMPASSWORD));
            utilities.mouseHoverOnModules("Customers Management", "Accounts");

            accountListViewPage.clickAddAccount();
            accountCreationPage.enterAccountName();
            accountCreationPage.enterAccountname(RandamUtils.getUserName());
            accountCreationPage.selectCustomerType("Residential");
            accountCreationPage.quickCreateContact();
            accountCreationPage.clickSave();

            accountSummaryPage.addServiceAccount();
            accountSummaryPage.kycVerification();
            accountSummaryPage.addServiceAccount();

            accountCreationPage.selectPlatform("Prepaid");
            accountCreationPage.clickSave();

        }
    }
