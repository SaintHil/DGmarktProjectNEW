package com.dgmarkt.stepDefinitions;

import com.dgmarkt.pages.AddressBookPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressBookStepDefinitions {
    AddressBookPage addressBookPage = new AddressBookPage();

    @Given("The user clicks on my account in the my account subcategory")
    public void the_user_clicks_on_my_account_in_the_my_account_subcategory() {
        addressBookPage.myAccount_Btn.click();
        addressBookPage.getMyAccount_Btn.click();
    }

    @Given("The user clicks Adress Book button")
    public void the_user_clicks_adress_book_button() {
        addressBookPage.adressBook_Btn.click();
    }

    @When("The user clicks on the new address button")
    public void the_user_clicks_on_the_new_address_button() {
        addressBookPage.newAdress_Btn.click();
    }

    @When("The user clicks on {string} box,{string} box,{string} box,{string} box,{string} box and {string} box and {string} select and {string} select enters valid data")
    public void the_user_clicks_on_box_box_box_box_box_and_box_and_select_and_select_enters_valid_data(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
        addressBookPage.enterCredentials_mtd(FirstName, LastName, Company, Address1, City, PostCode, Country, Region);
    }

    @When("The user clicks the No radio button on the default address")
    public void the_user_clicks_the_no_radio_button_on_the_default_address() {
        addressBookPage.defaultAdressNo_btn.click();
    }

    @When("The user click Continue button")
    public void the_user_click_continue_button() {
        addressBookPage.continue_Btn.click();
    }

    @Then("Verify that you can receive a new address verification message {string}")
    public void verify_that_you_can_receive_a_new_address_verification_message(String message) {
        addressBookPage.verifyMessage(message);
    }

    @When("The user clicks on the edit button")
    public void the_user_clicks_on_the_edit_button() {
        addressBookPage.edit_Btn.click();
    }

    @When("The user clicks edit address on {string} box,{string} box,{string} box,{string} box,{string} box and {string} box and {string} select and {string} select enters valid data")
    public void the_user_clicks_edit_address_on_box_box_box_box_box_and_box_and_select_and_select_enters_valid_data(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
        addressBookPage.editAddress_mtd(FirstName, LastName, Company, Address1, City, PostCode, Country, Region);
    }

    @When("The user clicks the radio button {string} on the default address")
    public void the_user_clicks_the_radio_button_on_the_default_address(String radiobutton) {
        addressBookPage.radioBtn_mtd(radiobutton);
    }

    @When("The user clicks Delete button")
    public void the_user_clicks_delete_button() {
        BrowserUtils.waitFor(2);
        addressBookPage.delete_Btn.click();
        addressBookPage.alert_mtd();
        BrowserUtils.waitFor(2);
    }

    @When("The user clicks DeleteIndex button")
    public void the_user_clicks_delete_ındex_button() {
        BrowserUtils.waitFor(2);
        addressBookPage.delete_BtnIndex.click();
        addressBookPage.alert_mtd();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that you cannot delete the default address {string}")
    public void verify_that_you_cannot_delete_the_default_address(String message) {
        addressBookPage.verifyMessage(message);
    }

    @Then("Verify that you can get the error message {string}")
    public void verify_that_you_can_get_the_error_message(String message) {
        addressBookPage.errorVerifyMessage(message);
    }

    @Then("Verify that you can receive a update adress verification message {string}")
    public void verify_that_you_can_receive_a_update_adress_verification_message(String message) {
        addressBookPage.verifyMessage(message);
    }
}






