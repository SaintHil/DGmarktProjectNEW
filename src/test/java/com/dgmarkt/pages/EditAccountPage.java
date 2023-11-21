package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "(//button[@class='button btn'])[1]")
    public WebElement login_clickBtn;
    @FindBy(xpath= "(//a[text()='My Account'])[1]")
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
    public void editMyAccountLogin(String firstName, String lastName, String email, String telefon){
        firstName_Btn.clear();
        firstName_Btn.sendKeys(firstName);
        lastName_Btn.clear();
        lastName_Btn.sendKeys(lastName);
        email_Btn.clear();
        email_Btn.sendKeys(email);
        telephone_Btn.clear();
        telephone_Btn.sendKeys(telefon);
    }
    public void dataStandardizesLogin(){
        editAccountBtn.click();
        firstName_Btn.clear();
        BrowserUtils.waitFor(2);
        firstName_Btn.sendKeys("nesibe");
        lastName_Btn.clear();BrowserUtils.waitFor(2);
        lastName_Btn.sendKeys("oguz");
        email_Btn.clear();BrowserUtils.waitFor(2);
       // BrowserUtils.scrollToElement(email_Btn);
        email_Btn.sendKeys(ConfigurationReader.get("nesibe@ogux.sss"));
        telephone_Btn.clear();BrowserUtils.waitFor(2);
        telephone_Btn.sendKeys(ConfigurationReader.get("123456"));
       // continueBtn.click();
    }
    public void verifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//*[text()=' " + expectedMessage + "']")));
        String acutuelMessage = element.getText();
        Assert.assertEquals(acutuelMessage, expectedMessage);

    }
    public void errorVerifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//div[text()='" + expectedMessage + "']")));
        String acutuelMessage = element.getText();
        Assert.assertEquals(acutuelMessage, expectedMessage);
    }
}
