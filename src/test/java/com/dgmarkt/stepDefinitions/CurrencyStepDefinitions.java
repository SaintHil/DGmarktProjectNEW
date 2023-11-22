package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.CurrencyPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CurrencyStepDefinitions {
    CurrencyPage currencyPage = new CurrencyPage();
    String expCurrency;
    LoginPage loginPage = new LoginPage();
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


    @When("The user clicks currency button")
    public void the_user_clicks_currency_button() {
        currencyPage.currency_btn.click();
    }

    @Then("The user click the {string} Button")
    public void the_user_click_the_button(String currencyName) {
        expCurrency = currencyPage.currencySubmenuByName_mtd(currencyName).getText();
        currencyPage.currencySubmenuByName_mtd(currencyName).click();

    }

    @Then("Verify that the user sees select currency")
    public void verify_that_the_user_sees_select_currency() {
        Assert.assertTrue(expCurrency.contains(currencyPage.currentCurrency_text.getText()));

    }

    @Then("The user closes cookies pop up")
    public void the_user_closes_cookies_pop_up() {
        loginPage.popUpClose_Btn.click();

    }

    @When("The user navigates to sub-category {string}")
    public void the_user_navigates_to_sub_category(String subCategoryname) {
        BrowserUtils.waitFor(2);
        currencyPage.goToSubCategoryByName_mtd(subCategoryname);

    }


    @When("The user clicks cart icon button")
    public void the_user_clicks_cart_icon_button() {
        currencyPage.cartIcon_btn.click();


    }

    @When("The user clicks view cart button")
    public void the_user_clicks_view_cart_button() {
        BrowserUtils.clickWithJS(currencyPage.viewCart_btn);

    }

    @When("The user adds  products to the cart list names {string}")
    public void the_user_adds_products_to_the_cart_list_names(String productsname) {
        currencyPage.productSelect(productsname);

    }

    @Then("Verify that total price is in expected currency {string}")
    public void verify_that_total_price_is_in_expected_currency(String expectedCurrency) {
        String actTotalPrice = currencyPage.totalPrice.getText();
        Assert.assertTrue(actTotalPrice.contains(expectedCurrency));
        currencyPage.removeAllProductfromCart();
    }


    @And("The user adds two products to the cart list names {string} and {string}")
    public void theUserAddsTwoProductsToTheCartListNamesAnd(String item1, String item2) {
        BrowserUtils.waitFor(2);
        currencyPage.addToCartByProductName_mtd(item1);
        currencyPage.addToCartByProductName_mtd(item2);
    }
}