@D2DGMRT-4
Feature: Currency Functionality


  Background: The user logs in for login panel
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And The user enters account credentials "aysegun@gmail.com" and "Test_1234" and clicks login


  @D2DGMRT-48
  Scenario Outline: The user sees the currency selected
    When The user clicks currency button
    And The user click the "<currencyName>" Button
    And The user closes cookies pop up
    Then Verify that the user sees select currency
    Examples:
      | currencyName   |
      | Euro           |
      | Pound Sterling |
      | US Dollar      |
  @D2DGMRT-69
  Scenario Outline: The user completes his/her purchase with the currency his/her choice
    When The user navigates to sub-category "Networking"
    And The user adds two products to the cart list names "ASUS ROG STRIX GS-AX3000" and "Belkin Secure Flip KVM Switch"
    And The user clicks cart icon button
    And The user clicks view cart button
    And The user clicks currency button
    And The user click the "<currencyName>" Button
    And The user clicks Checkout button
    And The user clicks continue for billing details with exist credentials
    And The user clicks continue for delivery details with exist credentials
    And The user adds comment about his order "Everything is ok!" and clicks continue for delivery method
    And The user adds comment about his order "Thanks! Everything is ok!" and clicks checkbox to agree Terms and Conditions and clicks continue
    Then Verify that confirm order total price is in expected currency "<expectedicon>"
    Examples:
      | currencyName   | expectedicon |
      | Euro           | €            |
      | Pound Sterling | £            |
      | US Dollar      | $            |