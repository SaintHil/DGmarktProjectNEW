package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.CategoryPage;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class SelectSubCategoryTabsStepDefinitions {

    CategoryPage categoryPage=new CategoryPage();
    @When("The user hover overs on Category and clicks to {string}")
    public void the_user_hover_overs_on_category_and_clicks_to(String subCategoryName) {
        categoryPage.navigateToSubCategory(subCategoryName);    }
    @Then("Verify that the user sees the {string}")
    public void verify_that_the_user_sees_the(String subCategoryPageText){
        categoryPage.verifySubCategory(subCategoryPageText);
    }
}
