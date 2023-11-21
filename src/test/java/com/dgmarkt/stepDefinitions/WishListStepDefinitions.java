package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.WishListPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishListStepDefinitions {

    WishListPage wishListPage = new WishListPage();




    @When("The user clicks on the Wish List")
    public void the_user_clicks_on_the_wish_list() {
        wishListPage.wishIcon.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that The products in the Wish list are visible")
    public void verify_that_the_products_in_the_wish_list_are_visible() {
        //Assert.assertFalse(wishListPage.wishProductTable.isEmpty());
        Assert.assertTrue(wishListPage.wishProductTable.size() > 0);
        BrowserUtils.waitFor(2);
    }
    @And("The user clicks on the first product`s Remove button")
    public void The_user_clicks_on_the_first_product_s_Remove_button() {
        wishListPage.remove_Btn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that the success message is displayed")
    public void Verify_that_the_success_message_is_displayed() {
        Assert.assertTrue(wishListPage.successMsg.isDisplayed());
        BrowserUtils.waitFor(2);
    }

    @And("The user clicks on the first product`s Add button")
    public void The_user_clicks_on_the_first_product_s_Add_button() {
        wishListPage.AddToCartBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that the product is added to the Cart successfully")
    public void Verify_that_the_product_is_added_to_the_Cart_successfully() {
        Assert.assertTrue(wishListPage.successMsgAddToCart.isDisplayed());
        BrowserUtils.waitFor(2);

    }

}