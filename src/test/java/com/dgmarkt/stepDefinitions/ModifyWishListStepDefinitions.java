package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.WishListPage;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ModifyWishListStepDefinitions {

    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    WishListPage wishListPage=new WishListPage();


    @When("The user clicks to My Account button on Home page")
    public void the_user_clicks_to_my_account_button_on_home_page() throws InterruptedException {
        loginPage.loginPage("veliali@gmail.com","12341234");
        Thread.sleep(2000);
        homePage.myAccount_Btn.click();
        Thread.sleep(2000);
    }
    @When("The user clicks to My Account button under My Account submenu")
    public void the_user_clicks_to_my_account_button_under_my_account_submenu() {
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
        wishListPage.addProductCelloTv.click();
    }

    @Then("Verify that the user sees {string} text.")
    public void verify_that_the_user_sees_text(String arg0) {
        Assert.assertTrue(wishListPage.addProductSuccesText.getText().contains("Success: You have modified your wish list!"));
    }

    @And("The user clicks to delete product button")
    public void the_user_clicks_to_delete_product_button() {
    }
}
