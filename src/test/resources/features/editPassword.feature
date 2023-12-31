@D2DGMRT-9
Feature: Edit Password

  Background: The user is on home page
    Given The user is logged in with valid credentials "sainthill599@gmail.com" and "123ABC"
    And The user clicks on my account in the my account subcategory
    And The user clicks on Change Password link

  @D2DGMRT-40
  Scenario: The user should be able to change password with confirm password
    When The user enters new password "123ABC" into the password input box
    And The user enters the same password "123ABC" into the confirm input box
    And The user clicks on Continue button
    Then Verify that updated success message for password is displayed

  @D2DGMRT-41
  Scenario Outline: The user should be able to not changed with different Credentials
    When The user enters invalid password "<Password>" into the password input box
    And The user enters the same invalid password "<ConfirmPassword>" into the confirm input box
    And The user click on Continue button
    Then Verify that password is NOT changed "<message1>" displayed
    And  Verify that password is NOT changed "<message2>" seen
    Examples:
      | Password | ConfirmPassword | message1                                      | message2                                       |
      | 123ABC   | 123XXX          |                                               | Password confirmation does not match password! |
      | 123      | 123ABC          | Password must be between 4 and 20 characters! | Password confirmation does not match password! |
      | 123ABC   |                 | Password must be between 4 and 20 characters! | Password confirmation does not match password! |
      |          | 123ABC          | Password must be between 4 and 20 characters! | Password confirmation does not match password! |
      | 123      |                 | Password must be between 4 and 20 characters! | Password confirmation does not match password! |
