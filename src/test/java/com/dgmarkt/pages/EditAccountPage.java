package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(className = "text-danger")
    public WebElement blankInputWarningMessage;
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
        email_Btn.sendKeys("nesibe@ogux.sss");
        telephone_Btn.clear();BrowserUtils.waitFor(2);
        telephone_Btn.sendKeys("123456");
    }
    public void verifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//*[text()=' " + expectedMessage + "']")));
        String acutuelMessage = element.getText();
        Assert.assertEquals(acutuelMessage, expectedMessage);

    }
    /**Getting POP-UP messages
     * and control that if contains valid or @*/
    public void getDisappearingWarningMessage(String message) {
        String actualMessage;
        if (message.contains("@")) {
            actualMessage = email_inputBtn.getAttribute("validationMessage");
            System.out.println("actualMessage = " + actualMessage);
        } else if (message.contains("valid")) {
            actualMessage = blankInputWarningMessage.getText();
            System.out.println("actualMessage = " + actualMessage);
        }
    }
}
