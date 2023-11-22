
Feature: Select Sub Category Tabs under Category Module

  Background:The user is on the home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And  The user enters account credentials "veliali@gmail.com" and "12341234" and clicks login

  Scenario Outline: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category and clicks to "<subCategoryName>"
    Then Verify that the user sees the "<subCategoryName>"
    Examples:
      | subCategoryName |
      | Health & Beauty |
      | Televisions     |
      | TV Accessories  |
      | Networking      |





