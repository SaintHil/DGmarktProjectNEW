package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.dgmarkt.utilities.Driver.driver;

public class AddressBookPage extends BasePage{
        @FindBy(xpath = "//a[text()='Address Book']")
        public WebElement adressBook_Btn;
        @FindBy(xpath = "//a[text()='Edit']")
        public WebElement edit_Btn;
        @FindBy(xpath = "//a[text()='Delete']")
        public WebElement delete_Btn;
        @FindBy(xpath = "(//a[text()='Delete'])[2]")
        public WebElement delete_BtnIndex;
        @FindBy(xpath = "//a[text()='New Address']")
        public WebElement newAdress_Btn;
        @FindBy(xpath = "//a[text()='Back']")
        public WebElement back_Btn;
        @FindBy(css = "#input-firstname")
        public WebElement firstName_inputbox;
        @FindBy(css = "#input-lastname")
        public WebElement lastName_inputbox;
        @FindBy(css = "#input-company")
        public WebElement company_inputbox;
        @FindBy(css = "#input-address-1")
        public WebElement adress1_inputbox;
        @FindBy(css = "#input-city")
        public WebElement city_inputbox;
        @FindBy(css = "#input-postcode")
        public WebElement postCode_inputbox;
        @FindBy(id = "input-country")
        public WebElement country_selectbox;
        @FindBy(id = "input-zone")
        public WebElement regionState_selectbox;
        @FindBy(xpath = "//input[@name='default'][@value='1']")
        public WebElement defaultAdressYes_btn;
        @FindBy(xpath = "//input[@name='default'][@value='0']")
        public WebElement defaultAdressNo_btn;
        @FindBy(xpath = "//input[@type='submit']")
        public WebElement continue_Btn;
        @FindBy(xpath = "//*[text()=' Warning: You can not delete your default address!']")
        public WebElement warningMessage;
        @FindBy(xpath = "//*[text()=' Your address has been successfully deleted']")
        public WebElement deleteMessage;
        public void enterCredentials_mtd(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
            firstName_inputbox.sendKeys(FirstName);
            lastName_inputbox.sendKeys(LastName);
            company_inputbox.sendKeys(Company);
            adress1_inputbox.sendKeys(Address1);
            city_inputbox.sendKeys(City);
            postCode_inputbox.sendKeys(PostCode);
            selectCountryRegion_mtd(Country, Region);
        }
        public void selectCountryRegion_mtd(String Country, String Region) {
            Select slcCountry = new Select(country_selectbox);
            slcCountry.selectByVisibleText(Country);
            Select slcRegionState = new Select(regionState_selectbox);
            slcRegionState.selectByVisibleText(Region);
        }

        public void editAddress_mtd(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
            firstName_inputbox.clear();
            BrowserUtils.waitFor(1);
            firstName_inputbox.sendKeys(FirstName);
            lastName_inputbox.clear();
            BrowserUtils.waitFor(1);
            lastName_inputbox.sendKeys(LastName);
            company_inputbox.clear();
            BrowserUtils.waitFor(1);
            company_inputbox.sendKeys(Company);
            adress1_inputbox.clear();
            BrowserUtils.waitFor(1);
            adress1_inputbox.sendKeys(Address1);
            city_inputbox.clear();
            BrowserUtils.waitFor(1);
            city_inputbox.sendKeys(City);
            BrowserUtils.waitFor(1);
            selectCountryRegion_mtd(Country, Region);
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
        public void radioBtn_mtd(String radiobutton) {
            if (radiobutton.equals("Yes")) {
                defaultAdressYes_btn.click();
            } else if (radiobutton.equals("No"))
                defaultAdressNo_btn.click();
        }
        public void alert_mtd() {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }


