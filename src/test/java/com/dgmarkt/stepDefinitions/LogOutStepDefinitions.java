package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogOutStepDefinitions {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String unExpectedWindowId = "";

    @When("The user click to my account button")
    public void the_user_click_to_my_account_button() {
        BrowserUtils.waitForClickablility(homePage.myAccount_Btn, 3);
        homePage.myAccount_Btn.click();
    }

    @And("The user click to logout button")
    public void the_user_click_to_logout_button() {
        Assert.assertFalse("Account logout box should not be displayed", homePage.accountLogout_box.isDisplayed());
        homePage.logout_Btn.click();
    }

    @Then("Verify that the user has securely terminated the session and sees the account logout page")
    public void verify_that_the_user_has_securely_terminated_the_session_and_sees_the_account_logout_page() {
        BrowserUtils.waitForVisibility(homePage.accountLogout_box, 3);
        Assert.assertTrue("Account logout box should be displayed", homePage.accountLogout_box.isDisplayed());
    }

    @When("The user click to exit button for the browser close")
    public void the_user_click_to_exit_button_for_the_browser_close() throws InterruptedException {
        unExpectedWindowId = Driver.get().getWindowHandle();
        Driver.closeDriver();
        Thread.sleep(3000);
    }

    @Then("The user verify that current browser is not old browser")
    public void the_user_verify_that_current_browser_is_not_old_browser() {
        Assert.assertNotEquals(unExpectedWindowId, Driver.get().getWindowHandle());
    }

    @Then("Verify that the user has securely terminated the session and the login panel page is open")
    public void verify_that_the_user_has_securely_terminated_the_session_and_the_login_panel_page_is_open() {
        String actualMessage = Driver.get().findElement(By.xpath("//h5[text()='Please Enter Your Username and Password']")).getText();
        Assert.assertEquals("Please Enter Your Username and Password", actualMessage);
    }

    @Then("The user click to go back button")
    public void the_user_click_to_go_back_button() {
        Driver.get().navigate().back();
    }

    @Then("Verify that successfully logged out")
    public void verify_that_successfully_logged_out() {
        loginPage.popUpClose_Btn.click();
        loginPage.myAccount_Btn.click();
        Assert.assertTrue(loginPage.accountLogin_Btn.isDisplayed());
    }

    @When("The user waits {int} minutes without any movement on the web page")
    public void the_user_waits_minutes_without_any_movement_on_the_web_site(int waitMinutes) {
        BrowserUtils.waitFor(waitMinutes * 60);
    }

    @When("The user click to refresh button")
    public void the_user_click_to_refresh_button() {
        Driver.get().navigate().refresh();
    }

    @Then("Verify that automatic logged out of the web page")
    public void verify_that_automatic_logged_out_of_the_web_page() {
        Assert.assertTrue(loginPage.signUpCookies_text.getText().contains("Sign Up Newsletter"));
    }

    @When("The user navigate to page {string}")
    public void the_user_navigate_to_page(String url) {
        Driver.get().navigate().to(url);
        BrowserUtils.waitForPageToLoad(3);

    }

    @Then("Verify that the page {string} open")
    public void verify_that_the_page_open(String expUrl) {
        Assert.assertEquals(expUrl, Driver.get().getCurrentUrl());
    }

    @Then("The user  waits  {int} minutes and click to go back button")
    public void the_user_waits_minutes_and_clicks_to_go_back_button(int waitMinutes) {
        BrowserUtils.waitFor(waitMinutes * 60);
        Driver.get().navigate().back();
    }
}
