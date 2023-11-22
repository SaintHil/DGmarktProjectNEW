@D2DGMRT-1
Feature: Login Functionality

  Background: The user logs in for login panel
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account

  @D2DGMRT-34
  Scenario: The user can see valid Placeholders on Email and Password fields
    Then Verify that the user can see valid placeholder on Email input box
    Then Verify that the user can see valid placeholder on Password input box

  @D2DGMRT-35
  Scenario: The user can see the "Forgot Your Password" register page
    And Click on the Forgotten Password link
    Then Verify that the user can see Forgot Your Password register page

  @D2DGMRT-23
  Scenario: The user logs in for my account login with valid credential
    When The user enters account credentials "proje1@dgmarkt.com" and "Test12345" and clicks login
    Then Verify that the user is on home page

  @D2DGMRT-24
  Scenario Outline: The user logs in for my account login with different credentials
    When The user enters account credentials "<email>" and "<password>" and clicks login
    Then Verify that the error "<message>" is visible
    Examples:
      | email              | password  | message                                               |
      |                    |           | Warning: No match for E-Mail Address and/or Password. |
      |                    | Test12345 | Warning: No match for E-Mail Address and/or Password. |
      | ppppp@dgmarkt.com  | Test12345 | Warning: No match for E-Mail Address and/or Password. |
      | proje1@dgmarkt.com | 1234567   | Warning: No match for E-Mail Address and/or Password. |
      | proje1@dgmarkt.com |           | Warning: No match for E-Mail Address and/or Password. |