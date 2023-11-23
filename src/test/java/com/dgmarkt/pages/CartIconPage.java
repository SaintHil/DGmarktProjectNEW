package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartIconPage extends BasePage{

    Actions actions = new Actions(Driver.get());
    Select selectCountry;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]/button[2]")
    public WebElement removeFirstProductFromCart_Btn;
    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkOut_Btn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[2]/td[2]")
    public WebElement totalPrice;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]/button[1]")
    public WebElement updateQuantityFirstProductInCart_Btn;
    @FindBy(xpath = "(//input[contains(@name, 'quantity')])[1]")
    public WebElement quantityFirstProductInCart_Text;
    @FindBy(xpath = "//a[text()='Shopping Cart']")
    public WebElement shoppingCartHeader_loc;
    @FindBy(xpath = "//button[@class=\"btn btn-danger\"]")
    public WebElement cartPageRemove_Btn;
    @FindBy(xpath = "(//input[@name='payment_address'])[2]/..")
    public WebElement billingNewAddress_radioBtn;
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    public WebElement billingFirstname_Text;
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    public WebElement billingLastname_Text;
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    public WebElement billingAddress1_Text;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    public WebElement billingCity_Text;
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    public WebElement billingPostcode_Text;
    @FindBy(xpath = "//select[@id='input-payment-country']")
    public WebElement billingCountry_Select;
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    public WebElement billingRegion_Select;
    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingContinue_Btn;
    @FindBy(xpath = "(//input[@name='shipping_address'])[2]")
    public WebElement deliveryNewAddress_radioBtn;
    @FindBy(xpath = "//input[@id='input-shipping-firstname']")
    public WebElement deliveryFirstname_Text;
    @FindBy(xpath = "//input[@id='input-shipping-lastname']")
    public WebElement deliveryLastname_Text;
    @FindBy(xpath = "//input[@id='input-shipping-address-1']")
    public WebElement deliveryAddress1_Text;
    @FindBy(xpath = "//input[@id='input-shipping-city']")
    public WebElement deliveryCity_Text;
    @FindBy(xpath = "//input[@id='input-shipping-postcode']")
    public WebElement deliveryPostcode_Text;
    @FindBy(xpath = "//select[@id='input-shipping-country']")
    public WebElement deliveryCountry_Select;
    @FindBy(xpath = "//select[@id='input-shipping-zone']")
    public WebElement deliveryRegion_Select;
    @FindBy(xpath = "//input[@id='button-shipping-address']/..")
    public WebElement deliveryContinue_Btn;
    @FindBy(xpath = "(//textarea[@name='comment'])[1]")
    public WebElement deliveryMethodCommentArea_Text;
    @FindBy(id = "button-shipping-method")
    public WebElement deliveryMethodContinue_Btn;
    @FindBy(xpath = "(//textarea[@name='comment'])[2]")
    public WebElement paymentCommentArea_Text;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement agreeTermsAndConditions_CheckBox;
    @FindBy(id = "button-payment-method")
    public WebElement paymentContinue_Btn;
    @FindBy(xpath = "//input[@value='Confirm Order']")
    public WebElement confirmOrder_Btn;
    @FindBy(xpath = "//a[text()='Success']")
    public WebElement checkoutSuccess_Text;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[2]")
    public WebElement confirmOrderTotalPrice_Text;
    @FindBy(xpath = "(//*[@class='txt-count'])[2]")
    public WebElement countProduct_Text;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartIcon_Btn;
    @FindBy(xpath = "//a[@href='https://dgmarkt.com/index.php?route=checkout/cart']")
    public WebElement viewCart_Btn;
    @FindBy(xpath = "(//ul//li//a[@class='a-top-link'])[2]")
    public WebElement category_Btn;
    @FindBy(xpath = "(//td[@class='text-right'])[2]")
    public WebElement productTotalPrice;
    @FindBy(xpath = "//div[@class='breadcrumbs']//h1")
    public WebElement pageName_Text;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
    public WebElement cartProduct_list;
    @FindBy(xpath = "//input[@name='agree']")
    public WebElement checkOutAgreeBtn;


    public void removeAllProductCart() {
        BrowserUtils.scrollToElement(cartIcon_Btn);
        cartIcon_Btn.click();
        viewCart_Btn.click();
        BrowserUtils.waitFor(2);
        int numberofProduct = numberOfProductInCartList_mtd();
        for (int i = 0; i < numberofProduct; i++) {
            removeFirstProductFromCart_Btn.click();
            BrowserUtils.waitFor(2);
        }
    }

    public int numberOfProductInCartList_mtd() {
        List<WebElement> allProductRowInCartList = Driver.get().findElements(By.xpath("(//table)[3]/tbody/tr"));
        return allProductRowInCartList.size();
    }

    public void setSelect_mtd(WebElement selectElement, String selectName) {
        selectCountry = new Select(selectElement);
        selectCountry.selectByVisibleText(selectName);
    }

    public void enterCredentialsForBilling_mtd(String firstname, String lastname, String address1, String city, String postcode, String country, String region) {
        billingFirstname_Text.sendKeys(firstname);
        billingLastname_Text.sendKeys(lastname);
        billingAddress1_Text.sendKeys(address1);
        billingCity_Text.sendKeys(city);
        billingPostcode_Text.sendKeys(postcode);
        setSelect_mtd(billingCountry_Select, country);
        setSelect_mtd(billingRegion_Select, region);
        billingContinue_Btn.click();
    }

    public void enterCredentialsForDelivery_mtd(String firstname, String lastname, String address1, String city, String postcode, String country, String region) {
        deliveryFirstname_Text.sendKeys(firstname);
        deliveryLastname_Text.sendKeys(lastname);
        deliveryAddress1_Text.sendKeys(address1);
        deliveryCity_Text.sendKeys(city);
        deliveryPostcode_Text.sendKeys(postcode);
        setSelect_mtd(deliveryCountry_Select, country);
        setSelect_mtd(deliveryRegion_Select, region);
        deliveryContinue_Btn.click();
    }

    public void addToCartByProductName_mtd(String productName) {
        WebElement productName_Box = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../../.."));
        actions.moveToElement(productName_Box);
        WebElement addToCart_BtnOfProduct = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../..//button"));
        BrowserUtils.waitFor(1);
        addToCart_BtnOfProduct.click();
    }

    public void goToSubmenu(String Menu, String Submenu) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.xpath("//span[text()='" + Menu + "']"))).perform();
        Driver.get().findElement(By.xpath("(//h4//a[text()='" + Submenu + "'])[1]")).click();
    }

    public void goToSubCategoryByName_mtd(String subCategoryName) {
        WebElement subCategory = Driver.get().findElement(xpath("//a[text()='" + subCategoryName + "']/../.."));
        hoverAndClick(category_Btn, subCategory);
    }

    public static void hoverAndClick(WebElement menu, WebElement subMenu) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(menu).perform();
        actions.click(subMenu).perform();
    }
}