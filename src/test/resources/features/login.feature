@D2DGMRT-1
Feature: Login Functionality

  Background: The user logs in for login panel
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page

  @D2DGMRT-23
  Scenario: The user logs in for my account login with valid credential
    When The user clicks the login under the my account
    And The user enters account credentials "proje1@dgmarkt.com" and "Test12345" and clicks login
    Then Verify that the user is on home page