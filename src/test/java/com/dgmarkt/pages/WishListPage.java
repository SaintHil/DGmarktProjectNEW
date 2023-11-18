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

    @FindBy(xpath = "//td[text()='Cello C1920FS 19\" LED-backlit LCD TV']//following::i[1]")
    public WebElement addProductCelloTv;

    @FindBy(xpath = "//td[text()='Cello C1920FS 19\" LED-backlit LCD TV']//following::i[2]")
    public WebElement deleteProductCelloTv;

    @FindBy(xpath = "//div[contains(text(),'Success')]")
    public WebElement addProductSuccessMessage;

    @FindBy(xpath = "//div[contains(text(),'Success: You have modified')]")
    public WebElement deleteProductSuccessMessage;





}
