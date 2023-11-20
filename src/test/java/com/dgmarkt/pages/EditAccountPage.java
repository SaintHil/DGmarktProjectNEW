package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage {

    @FindBy(xpath = "//a[@title='My Account']/..")
    public WebElement myAccountBtn;

    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    public WebElement myAccountBtnUnderMyAccount;
    @FindBy(xpath = "//a[text()='Change your password']")
    public WebElement changeYourPasswordLink;

    @FindBy(xpath = "//*[@id='input-password']")
    public WebElement inPutPassword;

    @FindBy(xpath = "//*[@id='input-confirm']")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//*[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[@id='account-account']/div[1]")
    public WebElement successMsg;

    @FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
    public WebElement error_MsgText1;

    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    public WebElement error_MsgText2;

}


