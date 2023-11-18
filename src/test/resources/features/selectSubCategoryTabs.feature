Feature: Select Sub Category Tabs under Category Module

  Background:The user is on the home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And  The user enters account credentials "veliali@gmail.com" and "12341234" and clicks login

#  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
#    When The user hover overs on Category
#    And The user clicks to 'HEALTH & BEAUTY' button
#    Then Verify that the user sees the 'Health & Beauty' page
#
#
#  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
#    When The user hover overs on Category
#    And The user clicks to 'TELEVISIONS' button
#    Then Verify that the user sees the 'Televisions' page
#
#  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
#    When The user hover overs on Category
#    And The user clicks to 'TV ACCESSORIES' button
#    Then Verify that the user sees the 'TV Accessories' page
#
#  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
#    When The user hover overs on Category
#    And The user clicks to 'NETWORKING' button
#    Then Verify that the user sees the 'Networking' page


  Scenario Outline: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category
    And The user clicks to "<subCategoryName>" button
    Then Verify that the user sees the "<subCategoryPageText>" page
    Examples:
      | subCategoryName | subCategoryPageText |
      | Health & Beauty | Health & Beauty     |
      | Televisions     | Televisions         |
      | TV Accessories  | TV Accessories      |
      | Networking      | Networking          |





