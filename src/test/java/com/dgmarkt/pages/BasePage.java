package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@title='My Account']/..")
    public WebElement myAccount_Btn;
    @FindBy(xpath = "//a[@id='pt-login-link']/..")
    public WebElement accountLogin_Btn;
    @FindBy(xpath = "//div[@id='logo']")
    public WebElement homeLogo_icon;
    @FindBy(xpath = "//a[@id='pt-logout-link']/..")
    public WebElement logout_Btn;
    @FindBy(xpath = "//a[text()='My Account'][1]")
    public WebElement myAccountShow_Btn;

}
