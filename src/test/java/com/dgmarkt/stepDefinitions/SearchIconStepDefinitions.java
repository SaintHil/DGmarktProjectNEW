package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.pages.SearchIconPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dgmarkt.utilities.Driver.driver;

public class SearchIconStepDefinitions {
    LoginPanel loginPanel=new LoginPanel();
    LoginPage loginPage=new LoginPage();
    HomePage homePage = new HomePage();
    SearchIconPage searchIconPage = new SearchIconPage();

    @Given("The user is logged in with valid credentials {string} and {string}")
    public void the_user_is_logged_in_with_valid_credentials_and(String email, String password) {
        searchIconPage.login(email, password);
    }
    @When("The user clicks on the search icon")
    public void the_user_clicks_on_the_search_icon() {
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.searchIcon);
        homePage.searchIcon.click();
    }
    @When("The user searches for the product {string} that is on the website")
    public void the_user_searches_for_the_product_that_is_on_the_website(String searchItem) {
        homePage.searchInputBox.sendKeys(searchItem);
        BrowserUtils.waitFor(2);
    }
    @Then("Verify that the product {string} is displayed")
    public void verify_that_the_product_is_displayed(String expectedProduct) {
        Assert.assertTrue(searchIconPage.getExpectedProduct(expectedProduct).isDisplayed());
    }
    @When("The user searches for the product {string} that is not on the website")
    public void the_user_searches_for_the_product_that_is_not_on_the_website(String searchItem) {
        homePage.searchInputBox.sendKeys(searchItem);
        BrowserUtils.waitFor(2);
    }
    @Then("Verify that the product not found message {string} is displayed")
    public void verify_that_the_product_not_found_message_is_displayed(String expectedMessage) {
        Assert.assertTrue(searchIconPage.noProductsMessage.isDisplayed());
    }

}
