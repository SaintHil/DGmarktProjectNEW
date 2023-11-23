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
    @FindBy(xpath = "//div[@class='breadcrumbs']//h1")
    public WebElement pageName_Text;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
    public WebElement cartProduct_list;
    public int numberOfProductInCartList_mtd() {
        List<WebElement> allProductRowInCartList = Driver.get().findElements(By.xpath("(//table)[3]/tbody/tr"));
        return allProductRowInCartList.size();
    }
    public void addToCartByProductName_mtd(String productName) {
        WebElement productName_Box = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../../.."));
        actions.moveToElement(productName_Box);
        WebElement addToCart_BtnOfProduct = Driver.get().findElement(By.xpath("//div[@class='caption']//a[text()='" + productName + "']/../..//button"));
        BrowserUtils.waitFor(1);
        addToCart_BtnOfProduct.click();
    }
}