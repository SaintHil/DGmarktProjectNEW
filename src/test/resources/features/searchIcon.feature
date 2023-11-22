@D2DGMRT-5
Feature: Search Icon Function

  Background:
    Given The user is logged in with valid credentials "per.nyberg@gmail.com" and "Pn12345"
    And The user clicks on the search icon
  @D2DGMRT-61
  Scenario Outline: Verify product display on search
    When The user searches for the product "<searchItem>" that is on the website
    Then Verify that the product "<expectedProduct>" is displayed
    Examples:
      | searchItem | expectedProduct           |
      | MAX        | Linksys MAX-STREAM MR6350 |
      | MA         | Linksys MAX-STREAM MR6350 |
      | Capsule    | Capsule Plate 6pcs        |
      | Cap        | Capsule Plate 6pcs        |
      | Capsul     | Capsule Plate 6pcs        |

  @D2DGMRT-63
  Scenario Outline: Verify "product not found" message
    When The user searches for the product "<searchItem>" that is not on the website
    Then Verify that the product not found message "<expectedMessage>" is displayed
    Examples:
      | searchItem | expectedMessage                                 |
      | Cellopop   | There are no products to list in this category. |
      | JAVA       | There are no products to list in this category. |
      | apple      | There are no products to list in this category. |
