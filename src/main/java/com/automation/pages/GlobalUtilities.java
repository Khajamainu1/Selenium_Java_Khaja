package com.automation.pages;

import com.automation.driver.Driver;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GlobalUtilities extends BasePage{

    public GlobalUtilities()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="appnavigator")
    WebElement mainMenu;
    public void mouseHoverOnModules(String mainModule, String subModule)
    {
    click(mainMenu, "Main Menu");

    WebElement mainModuleElement = Driver.getDriver().findElement(By.xpath("//div[@id='"+mainModule+"_modules_dropdownMenu']"));
    WebElement subModuleElement = Driver.getDriver().findElement(By.xpath("//span[@class='module-name textOverflowEllipsis' and text()='"+subModule+"']"));

    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(mainModuleElement).perform();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        visibilityOfElementLocated(By.xpath("//span[@class='module-name textOverflowEllipsis' and text()='"+subModule+"']"));
    actions.moveToElement(subModuleElement).click().perform();
//        clickUsingJavaScriptExecutor(subModuleElement, "Sub Module");
    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }
}
