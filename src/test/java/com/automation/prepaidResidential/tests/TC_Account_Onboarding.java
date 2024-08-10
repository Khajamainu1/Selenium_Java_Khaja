package com.automation.prepaidResidential.tests;

import com.automation.basetest.BaseTest;
import com.automation.enums.ConfigProperties;
import com.automation.pages.AccountListViewPage;
import com.automation.pages.GlobalUtilities;
import com.automation.pages.LoginPage;
import com.automation.utils.PropertyUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class TC_Account_Onboarding extends BaseTest {

        @Epic("3000")
        @Feature("Login")
        @Story("Valid Credentials")
        @Severity(SeverityLevel.BLOCKER)
        @Test(description="Residential Onboarding")
        public void onboarding ()
        {
            LoginPage loginPage = new LoginPage();
            GlobalUtilities utilities = new GlobalUtilities();
            AccountListViewPage accountListViewPage = new AccountListViewPage();


//
//            loginPage.loginCRM(PropertyUtils.get(ConfigProperties.CRMUSERNAME), PropertyUtils.get(ConfigProperties.CRMPASSWORD));
//            utilities.mouseHoverOnModules("Customers Management", "Accounts");

            accountListViewPage.clickAddCart();
        }
    }
