@D2DGMRT-11
Feature: Modify Wish List

  Background: The user is on home page
    Given The user is logged in with valid credentials "veliali@gmail.com" and "12341234"
    And The user clicks on my account in the my account subcategory
    And The user clicks to Wish List button on the Account page

  @D2DGMRT-42
  Scenario: The user reachs to My Wish List page from My Account
    Then Verify that the user sees the My Wish List

  @D2DGMRT-44
  Scenario: The user modifies to My Wish List by adding product to Cart
    When The user clicks on the first products Add button
    Then Verify that the product is added to the Cart successfully

  @D2DGMRT-46
  Scenario: The user modifies to My Wish List by deleting product from My Wish List
    When The user clicks on the first products Remove button
    Then Verify that the success message is displayed

