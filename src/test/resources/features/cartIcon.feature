@D2DGMRT-7
Feature: Cart Icon Function

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    When The user enters account credentials "serkan35@dgmarkt.com" and "12345" and clicks login

  @D2DGMRT-77
  Scenario: The user should be able to see added product list by click cart icon
    When The user navigates to sub-category Televisions
    And The user adds two products to the cart list
    And The user click to cart icon button
    Then Verify that added product list is displayed

  @D2DGMRT-78
  Scenario: The user should be able to see product in cart list if add any product by click cart icon
    And The user click to cart icon button
    And The user click to view cart button
    Then Verify that the user two products in CartPage

  @D2DGMRT-79
  Scenario: The user should be able to go to the Checkout page from the cart icon and complete the checkout
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
    Then Verify that the user can see success page
