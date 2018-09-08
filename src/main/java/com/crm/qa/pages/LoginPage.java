package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR:

    @FindBy(name="UserIdentifier")
    WebElement username;

    @FindBy(name="Password")
    WebElement password;

    @FindBy(className="loginButtonText")
    WebElement loginBtn;

    @FindBy(xpath="//img[contains(@src,'ESVConnect')]")
    WebElement crmLogo;

    //Initializing the Page Object:
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

   public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un , String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }
}


