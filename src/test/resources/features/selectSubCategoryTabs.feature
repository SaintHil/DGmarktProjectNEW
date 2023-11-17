Feature: Select Sub Category Tabs under Category Module

  Background:
    Given The user is on the Homepage

  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category
    And The user clicks to 'HEALTH & BEAUTY' button
    Then Verify that the user sees the 'Healt & Beauty' page

  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category
    And The user clicks to 'TELEVISIONS' button
    Then Verify that the user sees the 'Televisions' page

  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category
    And The user clicks to 'TV ACCESSORIES' button
    Then Verify that the user sees the 'TV Accessories' page

  Scenario: The user navigates to Sub Category Tabs from Category button on Homepage
    When The user hover overs on Category
    And The user clicks to 'NETWORKING' button
    Then Verify that the user sees the 'Networking' page


