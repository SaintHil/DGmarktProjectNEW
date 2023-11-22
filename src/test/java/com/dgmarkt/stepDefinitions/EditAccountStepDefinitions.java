package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.EditAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAccountStepDefinitions {
    EditAccountPage editAccountPage=new EditAccountPage();
    @Given("The user clicks on the Edit Account button")
    public void the_user_clicks_on_the_edit_account_button() {
        editAccountPage.editAccountBtn.click();
    }
    @When("The user clicks on {string} box,{string} box,{string} box,{string} box select enters valid data")
    public void the_user_clicks_on_box_box_box_box_select_enters_valid_data(String FirstName, String LastName , String Email, String Telephone) {
        editAccountPage.editMyAccountLogin(FirstName,LastName,Email,Telephone);
    }
    @When("The user click continue button")
    public void the_user_click_continue_button() {
        editAccountPage.continueBtn.click();
    }
    @Then("Verify that you can receive a my account verification message {string}")
    public void verify_that_you_can_receive_a_my_account_verification_message(String message) {
        editAccountPage.verifySuccesMessage(message);
    }
    @When("The user clicks on {string} box,{string} box,{string} box,{string} box select enters invalid data")
    public void the_user_clicks_on_box_box_box_box_select_enters_invalid_data(String FirstName, String LastName , String Email, String Telephone) {
        editAccountPage.editMyAccountLogin(FirstName,LastName,Email,Telephone);
    }
    @Then("Verify that you can receive my account alert message {string}")
    public void verify_that_you_can_receive_my_account_alert_message(String message) {
        editAccountPage.verifyMessage(message);
    }
    @Then("The use standardizes login data")
    public void the_use_standardizes_login_data() {
        editAccountPage.dataStandardizesLogin();
    }
    @Given("The user clicks on my account in the my account subcategory")
    public void the_user_clicks_on_my_account_in_the_my_account_subcategory() {
        editAccountPage.myAccount_Btn.click();
        editAccountPage.childMyAccountBtn.click();
    }
    @Then("The warning message contains {string}")
    public void theWarningMessageContainsMessage(String message) {
    editAccountPage.getDisappearingWarningMessage(message);
    }
}

