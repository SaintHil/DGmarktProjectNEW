@D2DGMRT-2
Feature: Log out Functionality

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And The user enters account credentials "proje1@dgmarkt.com" and "Test12345" and clicks login

  @D2DGMRT-27
  Scenario: The user should be able to log out
    When The user clicks to My Account button
    And The user clicks to Logout button
    Then Verify that the user has securely terminated the session and sees the Account Logout Page