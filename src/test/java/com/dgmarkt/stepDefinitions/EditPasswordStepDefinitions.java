package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.EditAccountPage;
import com.dgmarkt.pages.EditPasswordPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EditPasswordStepDefinitions extends BasePage {

    EditPasswordPage editPasswordPage = new EditPasswordPage();

    @When("The user clicks on My Account")
    public void the_user_clicks_on_my_account() {
        editPasswordPage.myAccountBtn.click();
        BrowserUtils.waitFor(2);
    }

    @And("The user clicks on My Account under My Account")
    public void the_user_clicks_on_my_account_under_my_account() {
        editPasswordPage.myAccountBtnUnderMyAccount.click();
        BrowserUtils.waitFor(2);
    }

    @And("The user clicks on Change Password link")
    public void the_user_clicks_on_change_password_link() {
        editPasswordPage.changeYourPasswordLink.click();
        BrowserUtils.waitFor(2);
    }

    @And("The user enters new password {string} into the password input box")
    public void the_user_enters_new_password_into_the_password_input_box(String changePassword) {
        editPasswordPage.inPutPassword.sendKeys(changePassword);
        BrowserUtils.waitFor(2);
    }

    @And("The user enters the same password {string} into the confirm input box")
    public void the_user_enters_the_same_change_password_into_the_confirm_input_box(String changePasswordConfirm) {
        editPasswordPage.passwordConfirm.sendKeys(changePasswordConfirm);
        BrowserUtils.waitFor(2);

    }

    @When("The user click on Continue button")
    public void the_user_click_on_continue_button() {
        editPasswordPage.continueBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that updated success message for password is displayed")
    public void verify_that_updated_message_for_password_is_displayed() {
        Assert.assertTrue(editPasswordPage.successMsg.isDisplayed());
        BrowserUtils.waitFor(2);

    }

    @And("The user enters invalid password {string} into the password input box")
    public void the_user_enters_invalid_password_into_the_password_input_box(String changePassword) {
        editPasswordPage.inPutPassword.sendKeys(changePassword);
    }

    @And("The user enters the same invalid password {string} into the confirm input box")
    public void the_user_enters_the_same_invalid_password_into_the_confirm_input_box(String changePasswordConfirm) {
        editPasswordPage.passwordConfirm.sendKeys(changePasswordConfirm);

    }

    @Then("Verify that password is NOT changed {string} displayed")
    public void Verify_that_password_is_NOT_changed_displayed(String MsgText1) {
        Assert.assertTrue(editPasswordPage.error_MsgText1.getText().contains("Password"));


    }

    @And("Verify that password is NOT changed {string} seen")
    public void Verify_that_password_is_NOT_changed_seen(String MsgText2) {
        Assert.assertTrue(editPasswordPage.error_MsgText2.getText().contains("Password"));

    }
}

