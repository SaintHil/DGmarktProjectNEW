package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage{
    @FindBy(xpath= "//span[text()='My Account']")
    public WebElement MyAccountBtn;
    @FindBy(id= "pt-login-link")
    public WebElement loginBtn;
    @FindBy(xpath= "//input[@id='input-email']")
    public WebElement email_inputBtn;
    @FindBy(xpath= "//input[@id='input-password']")
    public WebElement password_inputBtn;
    @FindBy(linkText = "Login")
    public WebElement login_clickBtn;
    @FindBy(xpath= "(//a[contains(.,'My Account')])[2]")
    public WebElement childMyAccountBtn;
    @FindBy(xpath= "//a[text()='Edit Account']")
    public WebElement editAccountBtn;
    @FindBy(xpath= "//input[@id='input-firstname']")
    public WebElement firstName_Btn;
    @FindBy(xpath= "//input[@id='input-lastname']")
    public WebElement lastName_Btn;
    @FindBy(xpath= "//input[@id='input-email']")
    public WebElement email_Btn;
    @FindBy(xpath= "//input[@id='input-telephone']")
    public WebElement telephone_Btn;
    @FindBy(xpath= "//input[@value='Continue']")
    public WebElement continueBtn;
    @FindBy(linkText = " Success: Your account has been successfully updated.")
    public WebElement successVerify;
}
