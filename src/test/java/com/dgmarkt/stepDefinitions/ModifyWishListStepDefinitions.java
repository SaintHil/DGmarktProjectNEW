package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ModifyWishListStepDefinitions {

    WishListPage wishListPage = new WishListPage();

    @When("The user clicks to Wish List button on the Account page")
    public void the_user_clicks_to_wish_list_button_on_the_account_page() {
        wishListPage.wishListBtn_InAccountPage.click();
    }
    @Then("Verify that the user sees the My Wish List")
    public void verify_that_the_user_sees_the_my_wish_list() {
        Assert.assertTrue(wishListPage.myWishListPageText.isDisplayed());
    }

}