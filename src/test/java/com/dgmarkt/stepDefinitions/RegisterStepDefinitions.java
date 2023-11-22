package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.HomePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanel;
import com.dgmarkt.pages.RegisterPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.Random;

public class RegisterStepDefinitions {
    LoginPanel loginPanel = new LoginPanel();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();

    @Given("The user is on the Registration page")
    public void the_user_is_on_the_registration_page() {
        registerPage.getOnRegPage();
    }
    @When("the user enters the following information: {string}{string}{string}{string}{string}{string}{string}{string}")
    public void the_user_enters_the_following_information(String first_name, String last_name, String email, String telephone, String password, String confirm_password, String subscribe, String privacy_policy) {
        registerPage.firstnameInputBox.sendKeys(first_name);
        registerPage.lastnameInputBox.sendKeys(last_name);
        if (email.equals("ValidEmail")) {
            registerPage.emailInputBox.sendKeys(faker.internet().emailAddress());
        } else if (email.equals("InvalidEmail")) {
            registerPage.emailInputBox.sendKeys("invalid.email@com");
        } else if (email.equals("Null")) {
            registerPage.emailInputBox.clear();
        } else {
            registerPage.emailInputBox.sendKeys(email);
        }
        registerPage.telephoneInputBox.sendKeys(telephone);
        registerPage.passwprdInputBox.sendKeys(password);
        registerPage.passwordConfirmInputBox.sendKeys(confirm_password);
        if (subscribe.equals("No")) {
            registerPage.subscribeRadioNo.click();
        } else registerPage.subscribeRadioYes.click();
        if (privacy_policy.equals("Ticked")) {
            registerPage.privacyCheckBox.click();
        }
    }
    @When("The user clicks on Continue button")
    public void the_user_clicks_on_continue_button() {
        registerPage.continueBtn.click();
        BrowserUtils.waitFor(1);
    }
    @Then("Verify that registration is successful")
    public void verify_that_registration_is_successful() {
        Assert.assertTrue(registerPage.registrationMessage.isDisplayed());
    }
    @Then("Verify that an error message is displayed for the {string}")
    public void verify_that_an_error_message_is_displayed_for_the(String field) {
        Assert.assertTrue(registerPage.getErrorMessage(field).isDisplayed());
    }
    @Then("Verify that a warning message is displayed for the {string}")
    public void verify_that_a_warning_message_is_displayed_for_the(String warning) {
        Assert.assertTrue(registerPage.getWarningMessage(warning).isDisplayed());
    }
}
