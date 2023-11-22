@D2DGMRT-13
Feature: Modify Wish List

  Background:The user is on the home page
    Given The user is logged in with credentials "veliali@gmail.com" and "12341234"
    And The user clicks to My Account button
    And The user clicks to My Account button under My Account submenu
    And The user clicks to Wish List button on the Account page

  Scenario: The user reachs to My Wish List page from My Account
    Then Verify that the user sees the My Wish List

  Scenario: The user modifies to My Wish List by adding product to Cart
    When The user clicks to add product button
    Then Verify that the user sees success message

  Scenario: The user modifies to My Wish List by deleting product from My Wish List
    When The user clicks to delete product button
    Then Verify that the user sees successfully modified message

