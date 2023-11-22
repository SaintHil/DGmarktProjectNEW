
Feature: Select Sub Category Tabs under Category Module

  Background: The user is on home page
    Given The user is logged in with valid credentials "veliali@gmail.com" and "12341234"

  Scenario Outline: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category and clicks to "<subCategoryName>"
    Then Verify that the user sees the "<subCategoryName>"
    Examples:
      | subCategoryName |
      | Health & Beauty |
      | Televisions     |
      | TV Accessories  |
      | Networking      |





