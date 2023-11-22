@D2DGMRT-3
Feature:DGmarkt Register Feature

  Background:
    Given The user is on the Registration page

  @D2DGMRT-57
  Scenario Outline: Successful Registration
    When the user enters the following information: "<first_name>""<last_name>""<email>""<telephone>""<password>""<confirm_password>""<subscribe>""<privacy_policy>"
    And The user clicks on Continue button
    Then Verify that registration is successful
    Examples:
      | first_name                       | last_name                        | email      | telephone                        | password             | confirm_password     | subscribe | privacy_policy |
      | Per                              | Nyberg                           | ValidEmail | 0123456789                       | test1234             | test1234             | No        | Ticked         |
      | PerPerPerPerPerPerPerPerPerPerPe | Nyberg                           | ValidEmail | 0123456789                       | test1234             | test1234             | No        | Ticked         |
      | P                                | Nyberg                           | ValidEmail | 0123456789                       | test1234             | test1234             | No        | Ticked         |
      | Per                              | NybergNybergNybergNybergNybergNy | ValidEmail | 0123456789                       | test1234             | test1234             | No        | Ticked         |
      | Per                              | N                                | ValidEmail | 0123456789                       | test1234             | test1234             | No        | Ticked         |
      | Per                              | Nyberg                           | ValidEmail | 01234567890123456789012345678901 | test1234             | test1234             | No        | Ticked         |
      | Per                              | Nyberg                           | ValidEmail | 012                              | test1234             | test1234             | No        | Ticked         |
      | Per                              | Nyberg                           | ValidEmail | 0123456789                       | test1234567890123456 | test1234567890123456 | No        | Ticked         |
      | Per                              | Nyberg                           | ValidEmail | 0123456789                       | test                 | test                 | No        | Ticked         |
      | Per                              | Nyberg                           | ValidEmail | 0123456789                       | test1234             | test1234             | Yes       | Ticked         |

  @D2DGMRT-59
  Scenario Outline: Registration Validation (Negative Cases - Error)
    When the user enters the following information: "<first_name>""<last_name>""<email>""<telephone>""<password>""<confirm_password>""<subscribe>""<privacy_policy>"
    And The user clicks on Continue button
    Then Verify that an error message is displayed for the "<field>"
    Examples: Error Messages
      | first_name                        | last_name                         | email        | telephone                         | password | confirm_password | subscribe | privacy_policy | field     |
      |                                   | Nyberg                            | ValidEmail   | 0123456789                        | test1234 | test1234         | No        | Ticked         | firstname |
      | PerPerPerPerPerPerPerPerPerPerPer | Nyberg                            | ValidEmail   | 0123456789                        | test1234 | test1234         | No        | Ticked         | firstname |
      | Per                               |                                   | ValidEmail   | 0123456789                        | test1234 | test1234         | No        | Ticked         | lastname  |
      | Per                               | NybergNybergNybergNybergNybergNyb | ValidEmail   | 0123456789                        | test1234 | test1234         | No        | Ticked         | lastname  |
      | Per                               | Nyberg                            | Null         | 0123456789                        | test1234 | test1234         | No        | Ticked         | email     |
      | Per                               | Nyberg                            | InvalidEmail | 0123456789                        | test1234 | test1234         | No        | Ticked         | email     |
      | Per                               | Nyberg                            | ValidEmail   |                                   | test1234 | test1234         | No        | Ticked         | telephone |
      | Per                               | Nyberg                            | ValidEmail   | 012345678901234567890123456789012 | test1234 | test1234         | No        | Ticked         | telephone |
      | Per                               | Nyberg                            | ValidEmail   | 01                                | test1234 | test1234         | Yes       | Ticked         | telephone |
      | Per                               | Nyberg                            | ValidEmail   | 0123456789                        |          | test1234         | Yes       | Ticked         | password  |
      | Per                               | Nyberg                            | ValidEmail   | 0123456789                        | tes      | tes              | No        | Ticked         | password  |
      | Per                               | Nyberg                            | ValidEmail   | 0123456789                        | test1234 | 1234test         | No        | Ticked         | confirm   |

  @D2DGMRT-60
  Scenario Outline: Registration Validation (Negative Cases - Warning)
    When the user enters the following information: "<first_name>""<last_name>""<email>""<telephone>""<password>""<confirm_password>""<subscribe>""<privacy_policy>"
    And The user clicks on Continue button
    Then Verify that a warning message is displayed for the "<warning>"
    Examples: Warning Messages
      | first_name | last_name | email                | telephone  | password | confirm_password | subscribe | privacy_policy | warning |
      | Per        | Nyberg    | per.nyberg@gmail.com | 0123456789 | test1234 | test1234         | No        | Ticked         | Yes     |
      | Per        | Nyberg    | ValidEmail           | 0123456789 | test1234 | test1234         | No        | Unticked       | Yes     |









