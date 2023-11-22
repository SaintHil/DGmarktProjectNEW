package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    @FindBy(css = "#wishlist-total")
    public WebElement wishIcon;

    @FindBy(xpath = "//*[@id=\"content\"]/h2")
    public List<WebElement> wishProductTable;

    @FindBy(xpath = "//*[@id='account-wishlist']/div[1]")
    public WebElement successMsg;

    @FindBy(xpath = "//*[@id='content']/div[1]/table/tbody/tr/td[6]/a")
    public WebElement remove_Btn;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/button")
    public WebElement AddToCartBtn;

    @FindBy(css = "#account-wishlist > div.alert.alert-fix.alert-success.alert-dismissible")
    public WebElement successMsgAddToCart;
}
