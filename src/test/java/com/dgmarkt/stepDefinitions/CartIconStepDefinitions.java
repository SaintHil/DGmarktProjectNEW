package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.CartIconPage;
import com.dgmarkt.pages.CurrencyPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartIconStepDefinitions {
    CartIconPage cartIconPage=new CartIconPage();
    CurrencyPage currencyPage=new CurrencyPage();

    @And("The user click to cart icon button")
    public void the_user_click_to_cart_icon_button() {
        Assert.assertFalse("Product list shouldn't be display!", cartIconPage.cartProduct_list.isDisplayed());
        cartIconPage.cartIcon_Btn.click();
    }

    @Then("Verify that added product list is displayed")
    public void verify_that_added_product_list_is_displayed() {
        Assert.assertTrue("Product list should be display!", cartIconPage.cartProduct_list.isDisplayed());
    }

    @When("The user navigates to sub-category Televisions")
    public void the_user_navigates_to_sub_category_televisions() {
        BrowserUtils.waitFor(2);
        currencyPage.goToSubCategoryByName_mtd("Televisions");
    }

    @And("The user adds two products to the cart list")
    public void the_user_adds_two_products_to_the_cart_list() {
        cartIconPage.addToCartByProductName_mtd("Cello C1920FS 19\" LED-backlit LCD TV");
        cartIconPage.addToCartByProductName_mtd("Cello C2420G 24\" LED-backlit LCD TV");
    }

    @And("The user click to view cart button")
    public void the_user_click_to_view_cart_button() {
        BrowserUtils.waitFor(2);
        cartIconPage.viewCart_Btn.click();
    }

    @Then("Verify that the user two products in CartPage")
    public void verify_that_the_user_two_products_in_cartPage() {
        int actNumberOfProduct = cartIconPage.numberOfProductInCartList_mtd();
        int expNumberOfProduct = 2;
        Assert.assertEquals(expNumberOfProduct, actNumberOfProduct);
    }
    @Then("Verify that the user can see success page")
    public void verify_that_the_user_can_see_success_page() {
        BrowserUtils.waitForVisibility(cartIconPage.checkoutSuccess_Text, 3);
        String expPageName = "Your Order Has Been Placed!";
        String actPageName = cartIconPage.pageName_Text.getText();
        Assert.assertEquals(expPageName, actPageName);
        currencyPage.removeAllProductfromCart();
    }

}