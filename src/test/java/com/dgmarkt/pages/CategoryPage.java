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

    public void navigateToSubCategory(String subCategoryName){
        BrowserUtils.hover(category_Btn);
        Driver.get().findElement(By.xpath("//a[text()='" +subCategoryName+ "']")).click();
    }
    public void verifySubCategory(String subCategoryPageText){
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h1[text()='" +subCategoryPageText+ "']")).isDisplayed());
    }

}
