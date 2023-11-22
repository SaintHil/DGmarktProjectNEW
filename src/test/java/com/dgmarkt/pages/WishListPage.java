package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    public WebElement subMyAccountBtn;

    @FindBy(xpath = "(//a[text()='Wish List'])[1]")
    public WebElement wishListBtn_InAccountPage;

    @FindBy(xpath = "//a[text()='My Wish List']")
    public WebElement myWishListPageText;

    @FindBy(css = "#account-wishlist > div.alert.alert-success.alert-dismissible")
    public WebElement successMsg;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")
    public WebElement remove_Btn;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/button")
    public WebElement AddToCartBtn;

    @FindBy(css = "#account-wishlist > div.alert.alert-fix.alert-success.alert-dismissible")
    public WebElement successMsgAddToCart;
}






