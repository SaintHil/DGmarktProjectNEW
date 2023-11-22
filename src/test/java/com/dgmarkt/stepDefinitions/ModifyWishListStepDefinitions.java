package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.WishListPage;
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
    @When("The user clicks to My Account button under My Account submenu")
    public void the_user_clicks_to_my_account_button_under_my_account() {
        wishListPage.myAccount_Btn.click();
        wishListPage.subMyAccountBtn.click();
    }
    @When("The user clicks to Wish List button on the Account page")
    public void the_user_clicks_to_wish_list_button_on_the_account_page() {
        wishListPage.wishListBtn_InAccountPage.click();
    }
    @Then("Verify that the user sees the My Wish List")
    public void verify_that_the_user_sees_the_my_wish_list() {
        Assert.assertTrue(wishListPage.myWishListPageText.isDisplayed());
    }
    @And("The user clicks to add product button")
    public void the_user_clicks_to_add_product_button() {
        wishListPage.AddToCartBtn.click();
    }
    @Then("Verify that the user sees success message")
    public void verify_that_the_user_sees_success_message() {
        Assert.assertTrue(wishListPage.successMsgAddToCart.getText().contains("Success"));
    }
    @And("The user clicks to delete product button")
    public void the_user_clicks_to_delete_product_button() {
        wishListPage.remove_Btn.click();
    }
    @Then("Verify that the user sees successfully modified message")
    public void verify_that_the_user_sees_successfully_modified_message() {
        Assert.assertTrue(wishListPage.successMsg.getText().contains("Success: You have modified"));
    }
}