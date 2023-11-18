package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    @FindBy(xpath = "//span[text()='Category']/../..")
    public WebElement category_Btn;

    public void hoverOverToCategoryBtn(){
        BrowserUtils.hover(category_Btn);
    }

    @FindBy(xpath = "//a[text()='Health & Beauty']")
    public WebElement healthBeauty_Btn;
    @FindBy(xpath = "//a[text()='TV Accessories']")
    public WebElement tvAccessories_Btn;
    @FindBy(xpath = "//a[text()='Televisions']")
    public WebElement televisions_Btn;
    @FindBy(xpath = "//a[text()='Networking']")
    public WebElement networking_Btn;

    public void navigateToSubCategory(String subCategoryName){
        Driver.get().findElement(By.xpath("//a[text()='" +subCategoryName+ "']")).click();
    }

    @FindBy(xpath = "//h1[text()='Health & Beauty']")
    public WebElement healthBeautyPageText;
    @FindBy(xpath = "//h1[text()='TV Accessories']")
    public WebElement tvAccessoriesPageText;
    @FindBy(xpath = "//h1[text()='Televisions']")
    public WebElement televisionsPageText;
    @FindBy(xpath = "//h1[text()='Networking']")
    public WebElement networkingPageText;

    public void verifySubCategory(String subCategoryPageText){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h1[text()='" +subCategoryPageText+ "']")).isDisplayed());
    }

}
