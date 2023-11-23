package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CurrencyPage extends BasePage {
    Actions actions = new Actions(Driver.get());
    @FindBy(xpath = "//span[contains(.,'Currency')]")
    public WebElement currency_btn;
    @FindBy(xpath = "//span[text()='Category']/../..")
    public WebElement category_btn;
    @FindBy(xpath = "//*[text()='Currency']/../span[1]")
    public WebElement currentCurrency_text;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]/button[2]")
    public WebElement removeFirstProductFromCart_btn;

    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[2]/td[2]")
    public WebElement totalPrice;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartIcon_btn;
    @FindBy(xpath = "//a[@href='https://dgmarkt.com/index.php?route=checkout/cart']")
    public WebElement viewCart_btn;
    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkOut_btn;
    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingContinue_btn;
    @FindBy(xpath = "//input[@id='button-shipping-address']/..")
    public WebElement deliveryContinue_btn;
    @FindBy(id = "button-shipping-method")
    public WebElement deliveryMethodContinue_btn;
    @FindBy(xpath = "(//textarea[@name='comment'])[1]")
    public WebElement deliveryMethodCommentArea_text;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement agreeTermsAndConditions_checkBox;
    @FindBy(id = "button-payment-method")
    public WebElement paymentContinue_btn;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[2]")
    public WebElement confirmOrderTotalPrice_text;

    public void removeAllProductfromCart() {
        int numberofProduct = numberOfProductInCartList_mtd();
        for (int i = 0; i < numberofProduct; i++) {
            removeFirstProductFromCart_btn.click();
            BrowserUtils.waitFor(2);
        }
    }

    public int numberOfProductInCartList_mtd() {
        List<WebElement> allProductRowInCartList = Driver.get().findElements(By.xpath("(//table)[3]/tbody/tr"));
        return allProductRowInCartList.size();
    }

    public void productSelect(String productsname) {
        WebElement product = Driver.get().findElement(xpath("//a[text()='" + productsname + "']/../.."));
        product.click();
    }


    public void addToCartByProductName_mtd(String productName) {
        WebElement productName_Box = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../../.."));
        actions.moveToElement(productName_Box);
        WebElement addToCart_BtnOfProduct = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../..//button"));
        BrowserUtils.waitFor(1);
        addToCart_BtnOfProduct.click();
    }

    public WebElement currencySubmenuByName_mtd(String currencyName) {
        WebElement submenuCurrency = Driver.get().findElement(xpath("//*[contains(text(),' " + currencyName + "')]/.."));
        return submenuCurrency;
    }

    public void goToSubCategoryByName_mtd(String subCategoryName) {
        WebElement subCategory = Driver.get().findElement(xpath("//a[text()='" + subCategoryName + "']/../.."));
        BrowserUtils.hoverAndClick(category_btn, subCategory);
    }

}