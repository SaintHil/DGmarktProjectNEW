@D2DGMRT-6
Feature: Like Icon (Wish list) Function

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And The user enters account credentials "sainthill599@gmail.com" and "123ABC" and clicks login
    And The user clicks on the Wish List

  @D2DGMRT-32
  Scenario:The User should be able to see products in the Wish List
    Then Verify that The products in the Wish list are visible

  @D2DGMRT-38
  Scenario:User can be able to add products from Wish List to Add to Cart
    When The user clicks on the first product`s Add button
    Then Verify that the product is added to the Cart successfully

  @D2DGMRT-39
  Scenario:The user should be able to delete products from the Wish List
    When The user clicks on the first product`s Remove button
    Then Verify that the success message is displayed