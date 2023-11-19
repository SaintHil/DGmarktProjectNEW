package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[text()='Close']")
    public WebElement popUpClose_Btn;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement email_inputBox;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement password_inputBox;

    @FindBy(xpath = "(//button[@class='button btn'])[1]")
    public WebElement login_Btn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement loginAlert_msgText;

    @FindBy(xpath = "//label[text()='E-Mail Address']")
    public WebElement emailBox_variable_txt;

    @FindBy(xpath = "(//label[text()='Password'])[1]")
    public WebElement passwordBox_variable_txt;

    @FindBy(xpath = "//a[@class='forgotten']")
    public WebElement forgotten_link;

    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    public WebElement forgotten_page_text;

    @FindBy(xpath = "//h3[text()='Sign Up Newsletter']")
    public WebElement signUpCookies_text;

    @FindBy(xpath = "(//h2[text()='Login or create an account'])[1]")
    public WebElement loginPage_text;

    public void loginPage(String email, String password) {
        email_inputBox.sendKeys(email);
        password_inputBox.sendKeys(password);
        login_Btn.click();
    }

}
