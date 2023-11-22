package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchIconPage extends BasePage{

    LoginPage loginPage = new LoginPage();
    LoginPanel loginPanel = new LoginPanel();
    @FindBy(xpath = "//p[contains(.,'There are no products to list in this category.')]")
    public WebElement noProductsMessage;

    public WebElement getExpectedProduct(String product){
        String locator = "//a[contains(.,'"+product+"')]";
        WebElement productLocator = Driver.get().findElement(By.xpath(locator));
        return productLocator;
    }
    public void login(String email, String password){
        Driver.get().get(ConfigurationReader.get("url"));
        loginPanel.loginPanel();
        loginPage.popUpClose_Btn.click();
        loginPage.myAccount_Btn.click();
        loginPage.accountLogin_Btn.click();
        loginPage.loginPage(email, password);
        BrowserUtils.waitFor(2);
    }
}
