package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[text()=' Congratulation! Login Successfully']")
    public WebElement loginSuccessfully_msg;
    @FindBy(xpath = "//div[@class='logout-success']")
    public WebElement accountLogout_box;
    @FindBy(css = ".dropdown-toggle.search-button")
    public WebElement searchIcon;
    @FindBy(id = "text-search")
    public WebElement searchInputBox;
}
