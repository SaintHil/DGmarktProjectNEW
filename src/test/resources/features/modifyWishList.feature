Feature: Modify Wish List

  Background:The user is on the home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page


  Scenario: The user reachs to My Wish List page from My Account
    When The user clicks to My Account button on Home page
    And The user clicks to My Account button under My Account submenu
    And The user clicks to Wish List button on the Account page
    Then Verify that the user sees the My Wish List

  Scenario: The user modifies to My Wish List by adding product to Cart
    When The user clicks to My Account button on Home page
    And The user clicks to My Account button under My Account submenu
    And The user clicks to Wish List button on the Account page
    And The user clicks to add product button
    Then Verify that the user sees "Success: You have added (…) to your shopping cart!" text.

  Scenario: The user modifies to My Wish List by deleting product from My Wish List
    When The user clicks to My Account button on Home page
    And The user clicks to My Account button under My Account submenu
    And The user clicks to Wish List button on the Account page
    And The user clicks to delete product button
    Then Verify that the user sees "Success: You have modified your wish list!" text.