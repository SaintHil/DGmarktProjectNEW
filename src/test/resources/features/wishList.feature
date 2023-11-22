@D2DGMRT-6
Feature: Like Icon (Wish list) Function

  Background: The user is on home page
    Given The user is logged in with valid credentials "sainthill599@gmail.com" and "123ABC"

  @D2DGMRT-32
  Scenario:The User should be able to see products in the Wish List
    Then Verify that the products in the Wish List are visible

  @D2DGMRT-38
  Scenario:User can be able to add products from Wish List to Add to Cart
    When The user clicks on the first products Add button
    Then Verify that the product is added to the Cart successfully

  @D2DGMRT-39
  Scenario:The user should be able to delete products from the Wish List
    When The user clicks on the first products Remove button
    Then Verify that the success message is displayed