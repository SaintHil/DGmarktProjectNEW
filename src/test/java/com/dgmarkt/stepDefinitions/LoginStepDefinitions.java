package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPanel loginPanel = new LoginPanel();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("The user navigate to web page")
    public void the_user_navigate_to_web_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @And("The user enters login panel credential and clicks login button")
    public void the_user_enters_login_panel_credential_and_clicks_login_button() {
        loginPanel.loginPanel();
    }

    @And("The user closes cookies page")
    public void the_user_closes_cookies_page() {
        loginPage.popUpClose_Btn.click();
    }

    @And("The user clicks the login under the my account")
    public void the_user_clicks_the_login_under_the_my_account() {
        loginPage.myAccount_Btn.click();
        loginPage.accountLogin_Btn.click();
    }

    @When("The user enters account credentials {string} and {string} and clicks login")
    public void the_user_enters_account_credentials_and_and_clicks_login(String email, String password) {
        loginPage.loginPage(email, password);
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that the user is on home page")
    public void verify_that_the_user_is_on_home_page() {
        Assert.assertTrue(homePage.loginSuccessfully_msg.isDisplayed());
    }

    @Then("Verify that the error message is displayed")
    public void verify_that_the_error_message_is_displayed() {
        String actualWarningMessage = loginPage.loginAlert_msgText.getText();
        Assert.assertTrue(actualWarningMessage.contains("Warning: "));
    }

    @Then("Verify that the error {string} is visible")
    public void verify_that_the_error_is_visible(String msgText) {
        Assert.assertTrue(msgText.contains("Warning: "));
    }

    @Then("Verify that the user can see valid placeholder on Email input box")
    public void verify_that_the_user_can_see_valid_placeholder_on_Email_input_box() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.emailBox_variable_txt.getText().contains("E-Mail"));
        Assert.assertTrue(loginPage.email_inputBox.isDisplayed());
    }

    @Then("Verify that the user can see valid placeholder on Password input box")
    public void verify_that_the_user_can_see_valid_placeholder_on_Password_input_box() {
        Assert.assertTrue(loginPage.passwordBox_variable_txt.getText().contains("Password"));
        Assert.assertTrue(loginPage.password_inputBox.isDisplayed());
    }

    @And("Click on the Forgotten Password link")
    public void click_on_the_Forgotten_Password_link() {
        loginPage.forgotten_link.click();
    }

    @Then("Verify that the user can see Forgot Your Password register page")
    public void verify_that_the_user_can_see_Forgot_Your_Password_register_page() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.forgotten_page_text.getText().contains("Forgot Your Password?"));
    }


}
