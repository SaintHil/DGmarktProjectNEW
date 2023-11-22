package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditAccountPage extends BasePage{
    @FindBy(xpath= "//input[@id='input-email']")
    public WebElement email_inputBtn;
    @FindBy(xpath= "(//a[text()='My Account'])[1]")
    public WebElement childMyAccountBtn;
    @FindBy(xpath= "//a[text()='Edit Account']")
    public WebElement editAccountBtn;
    @FindBy(xpath= "//input[@id='input-firstname']")
    public WebElement firstName_Btn;
    @FindBy(xpath= "//input[@id='input-lastname']")
    public WebElement lastName_Btn;
    @FindBy(css = "#input-email")
    public WebElement email_Btn;
    @FindBy(css = "#input-telephone")
    public WebElement telephone_Btn;
    @FindBy(xpath= "//input[@value='Continue']")
    public WebElement continueBtn;
    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    public WebElement emailRedWarningMessage;
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
        BrowserUtils.waitFor(1);
        firstName_Btn.sendKeys("nesibe");
        lastName_Btn.clear();BrowserUtils.waitFor(1);
        lastName_Btn.sendKeys("oguz");
        email_Btn.clear();BrowserUtils.waitFor(1);
        email_Btn.sendKeys("nesibe@ogux.sss");
        telephone_Btn.clear();BrowserUtils.waitFor(1);
        telephone_Btn.sendKeys("123456");
    }
    public void verifySuccesMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath(" //div[text()=' Success: Your account has been successfully updated.']")));
        BrowserUtils.waitFor(2);
        String actualMessage = element.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(actualMessage, expectedMessage);
    }
    public void verifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//*[text()='"+expectedMessage +"']")));
        BrowserUtils.waitFor(2);
        String actualMessage = element.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(actualMessage, expectedMessage);
    }
    public void getDisappearingWarningMessage(String message) {
        String actualMessage1="";
        String actualMessage2="";
        if (message.contains(".")) {
            BrowserUtils.waitFor(4);
            actualMessage1 = email_inputBtn.getAttribute("validationMessage");
            System.out.println("actualMessage = " + actualMessage1);
            assertTrue(actualMessage1.contains(message));

        }else if (message.contains("valid")) {BrowserUtils.waitFor(2);
            actualMessage2 = emailRedWarningMessage.getText();
            System.out.println("actualMessage = " + actualMessage2);
            assertTrue(actualMessage2.contains(message));
        }
    }
    public void verifyGetWarningMessage(String expectedMessage) {
        BrowserUtils.waitForVisibility(emailRedWarningMessage, 3);
        String actualWarningMessage = emailRedWarningMessage.getText();
        assertEquals("E-Mail Address does not",expectedMessage, actualWarningMessage);
    }
}
