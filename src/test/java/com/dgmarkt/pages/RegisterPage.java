package com.dgmarkt.pages;

import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class RegisterPage extends BasePage{

    LoginPage loginPage = new LoginPage();
    LoginPanel loginPanel = new LoginPanel();

    @FindBy(id ="pt-register-link")
    public WebElement registrationBtn;
    @FindBy(id ="input-firstname")
    public WebElement firstnameInputBox;
    @FindBy(id ="input-lastname")
    public WebElement lastnameInputBox;
    @FindBy(id ="input-register-email")
    public WebElement emailInputBox;
    @FindBy(id ="input-telephone")
    public WebElement telephoneInputBox;
    @FindBy(id ="input-register-password")
    public WebElement passwprdInputBox;
    @FindBy(id ="input-confirm")
    public WebElement passwordConfirmInputBox;
    @FindBy(css = "input[name='newsletter'][value='1']")
    public WebElement subscribeRadioYes;
    @FindBy(css = "input[name='newsletter'][value='0']")
    public WebElement subscribeRadioNo;
    @FindBy(css = "input[name='agree']")
    public WebElement privacyCheckBox;
    @FindBy(css = "input[value='Continue']")
    public WebElement continueBtn;
    @FindBy(xpath = "//h2[contains(.,'Your Account Has Been Created!')]")
    public WebElement registrationMessage;
    @FindBy(xpath = "//span[contains(.,'Warning:')]")
    public WebElement warningMessage;
    @FindBy(css = "div.alert.alert-danger.for-error.error-warning")
    public WebElement alertWarningMessage;

    public void getOnRegPage(){
        Driver.get().get(ConfigurationReader.get("url"));
        loginPanel.loginPanel();
        loginPage.popUpClose_Btn.click();
        loginPage.myAccount_Btn.click();
        registrationBtn.click();
    }
    public WebElement getErrorMessage(String field) {
        try {
            String errorMessageLocator = "//div[contains(@class,'for-error error-" + field + " text-danger')]";
                WebElement errorMessage = Driver.get().findElement(By.xpath(errorMessageLocator));
                return errorMessage;
        } catch (NoSuchElementException e) {
            System.out.println("Error: Element not found for field: " + field);
            return null;
        }
    }
    public WebElement getWarningMessage(String warning) {
        try {
            String warningLocator = "//span[contains(.,'Warning:')]";
            WebElement warningMessage = Driver.get().findElement(By.xpath(warningLocator));
            return warningMessage;
        } catch (NoSuchElementException e) {
            System.out.println("Error: Warning message element not found for locator: " + warning);
            return null;
        }
    }
}
