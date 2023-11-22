@D2DGMRT-10
Feature: My Account-User can Add or Modify address

  Background: The user is on home page
    Given The user is logged in with valid credentials "mlk@gmail.com" and "Test12345"
    And The user clicks on my account in the my account subcategory
    And The user clicks Adress Book button

  @D2DGMRT-70
  Scenario Outline: The user should be able to add new adress with valid credentials
    When The user clicks on the new address button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can receive a new address verification message "<message>"
    Examples:
      | FirstName                        | LastName                         | Company  | Address1                                                                                                                         | City                                                                                                                             | PostCode   | Country | Region | message                                  |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | M                                | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | MlkMlkMlkMlkMlkMlkMlkMlkMlkMlkMl | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | F                                | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | FalancaFalancaFalancaFalancaFala | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaa                                                                                                                              | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | bbbb                                                                                                                             | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bb                                                                                                                               | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb | 123456     | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 12         | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 1234567890 | Turkey  | Ankara | Your address has been successfully added |
      | M 12/*                           | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 1234567890 | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | b45/*?   | aaaa                                                                                                                             | bbbb                                                                                                                             | 1234567890 | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | bbbb                                                                                                                             | 1234M?&+ * | Turkey  | Ankara | Your address has been successfully added |
      | Mlk                              | Falanca                          | Bootflow | aaaa                                                                                                                             | b78^%& /                                                                                                                         | 1234567890 | Turkey  | Ankara | Your address has been successfully added |

  @D2DGMRT-71
  Scenario Outline: The user should be able to update the address by deleting any field and entering new data.
    When The user clicks on the edit button
    And The user clicks edit address on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can receive a update adress verification message "<message>"
    Examples:
      | FirstName | LastName | Company  | Address1 | City | PostCode | Country | Region | message                                    |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | cccc     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | cccc     | dddd | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | cccc     | dddd | 123      | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | cccc     | dddd | 123      | Germany | Berlin | Your address has been successfully updated |

  @D2DGMRT-72
  Scenario Outline: The user should not be able to create a new address if the required field is filled incorrectly or not.
    When The user clicks on the new address button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can get the error message "<massage>"
    Examples:
      | FirstName                         | LastName                          | Company  | Address1                                                                                                                          | City                                                                                                                              | PostCode    | Country               | Region                | massage                                         |
      |                                   | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | First Name must be between 1 and 32 characters! |
      | AhmetAhmetAhmetAhmetAhmetAhmetAhm | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | First Name must be between 1 and 32 characters! |
      | Ahmet                             |                                   | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | FalancaFalancaFalancaFalancaFalan | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | Falanca                           | Bootflow |                                                                                                                                   | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Address must be between 3 and 128 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | a                                                                                                                                 | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Address must be between 3 and 128 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aa                                                                                                                                | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Address must be between 3 and 128 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | bbbb                                                                                                                              | 123456      | Turkey                | Ankara                | Address must be between 3 and 128 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              |                                                                                                                                   | 123456      | Turkey                | Ankara                | City must be between 2 and 128 characters!      |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | b                                                                                                                                 | 123456      | Turkey                | Ankara                | City must be between 2 and 128 characters!      |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb | 123456      | Turkey                | Ankara                | City must be between 2 and 128 characters!      |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              |             | Germany               | Berlin                | Postcode must be between 2 and 10 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 1           | Germany               | Berlin                | Postcode must be between 2 and 10 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 12345678901 | Germany               | Berlin                | Postcode must be between 2 and 10 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | --- Please Select --- | --- None ---          | Please select a country!                        |
      | Ahmet                             | Falanca                           | Bootflow | aaaa                                                                                                                              | bbbb                                                                                                                              | 123456      | Turkey                | --- Please Select --- | Please select a region / state!                 |

  @D2DGMRT-73
  Scenario Outline: If the user has an address, they should not be able to delete it.
    When The user clicks on the edit button
    And The user clicks the radio button "<radiobutton>" on the default address
    And The user click Continue button
    When The user clicks Delete button
    Then Verify that you cannot delete the default address "<message>"
    Examples:
      | radiobutton | message                                           |
      | Yes         | Warning: You can not delete your default address! |

  @D2DGMRT-74
  Scenario Outline: If the address is not the default address, it can be deleted.
    When The user clicks DeleteIndex button
    Then Verify that you cannot delete the default address "<message>"
    Examples:
      | message                                    |
      | Your address has been successfully deleted |

