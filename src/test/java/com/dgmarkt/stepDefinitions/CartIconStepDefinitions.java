package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.CurrencyPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.dgmarkt.pages.CartIconPage;
import org.junit.Assert;


public class CartIconStepDefinitions {
String expCurrency;
    CartIconPage cartIconPage = new CartIconPage();
    CurrencyPage currencyPage = new CurrencyPage();

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
        cartIconPage.goToSubCategoryByName_mtd("Televisions");
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

    @Then("Verify that the user in on Shopping Cart Page")
    public void verify_that_the_user_in_on_shopping_cart_page() {
        Assert.assertTrue(cartIconPage.pageName_Text.getText().contains("Shopping Cart"));
    }

    @Then("Verify that the user two products in CartPage")
    public void verify_that_the_user_two_products_in_cartPage() {
        int actNumberOfProduct = cartIconPage.numberOfProductInCartList_mtd();
        int expNumberOfProduct = 2;
        Assert.assertEquals(expNumberOfProduct, actNumberOfProduct);
    }

    @And("The user click to checkout button")
    public void the_user_click_to_checkout_button() {
        cartIconPage.checkOut_Btn.click();
    }


    @And("The user checks and clicks confirm order")
    public void the_user_checks_and_clicks_confirm_order() {
        cartIconPage.confirmOrder_Btn.click();
    }

    @Then("Verify that the user can see success page")
    public void verify_that_the_user_can_see_success_page() {
        BrowserUtils.waitForVisibility(cartIconPage.checkoutSuccess_Text, 3);
        String expPageName = "Your Order Has Been Placed!";
        String actPageName = cartIconPage.pageName_Text.getText();
        Assert.assertEquals(expPageName, actPageName);
    }

    @Then("Verify that the user not able to continue to delivery details")
    public void verify_that_the_user_not_able_to_continue_to_delivery_details() {
        BrowserUtils.waitFor(1);
        Assert.assertFalse(cartIconPage.deliveryContinue_Btn.isDisplayed());
    }

    @When("The user navigates to sub-category {string}")
    public void the_user_navigates_to_sub_category(String subCategoryname) {
        BrowserUtils.waitFor(2);
        currencyPage.goToSubCategoryByName_mtd(subCategoryname);

    }

    @And("The user adds two products to the cart list names {string} and {string}")
    public void theUserAddsTwoProductsToTheCartListNamesAnd(String item1, String item2) {
        BrowserUtils.waitFor(2);
        currencyPage.addToCartByProductName_mtd(item1);
        currencyPage.addToCartByProductName_mtd(item2);
    }

    @When("The user clicks cart icon button")
    public void the_user_clicks_cart_icon_button() {
        currencyPage.cartIcon_btn.click();


    }

    @When("The user clicks view cart button")
    public void the_user_clicks_view_cart_button() {
        BrowserUtils.clickWithJS(currencyPage.viewCart_btn);

    }

    @When("The user clicks currency button")
    public void the_user_clicks_currency_button() {
        currencyPage.currency_btn.click();
    }

    @Then("The user click the {string} Button")
    public void the_user_click_the_button(String currencyName) {
        expCurrency = currencyPage.currencySubmenuByName_mtd(currencyName).getText();
        currencyPage.currencySubmenuByName_mtd(currencyName).click();

    }

    @When("The user clicks Checkout button")
    public void the_user_clicks_checkout_button() {
        currencyPage.checkOut_btn.click();
    }

    @When("The user clicks continue for billing details with exist credentials")
    public void the_user_clicks_continue_for_billing_details_with_exist_credentials() {
        currencyPage.billingContinue_btn.click();

    }

    @When("The user clicks continue for delivery details with exist credentials")
    public void the_user_clicks_continue_for_delivery_details_with_exist_credentials() {
        currencyPage.deliveryContinue_btn.click();

    }

    @When("The user adds comment about his order {string} and clicks continue for delivery method")
    public void the_user_adds_comment_about_his_order_and_clicks_continue_for_delivery_method(String comment) {
        currencyPage.deliveryMethodCommentArea_text.sendKeys(comment);
        currencyPage.deliveryMethodContinue_btn.click();
    }

    @When("The user adds comment about his order {string} and clicks checkbox to agree Terms and Conditions and clicks continue")
    public void the_user_adds_comment_about_his_order_and_clicks_checkbox_to_agree_terms_and_conditions_and_clicks_continue(String comment) {
        currencyPage.deliveryMethodCommentArea_text.sendKeys(comment);
        BrowserUtils.waitForClickablility(currencyPage.agreeTermsAndConditions_checkBox, 3);
        currencyPage.agreeTermsAndConditions_checkBox.click();
        currencyPage.paymentContinue_btn.click();
    }

    @Then("Verify that confirm order total price is in expected currency {string}")
    public void verify_that_confirm_order_total_price_is_in_expected_currency(String expCurrecyIcon) {
        BrowserUtils.waitFor(2);
        String actTotalPrice = currencyPage.confirmOrderTotalPrice_text.getText();
        Assert.assertTrue(actTotalPrice.contains(expCurrecyIcon));
        Driver.get().navigate().back();
        currencyPage.removeAllProductfromCart();
    }

}
