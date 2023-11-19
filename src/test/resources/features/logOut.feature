@D2DGMRT-2
Feature: Log out Functionality

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    When The user enters account credentials "proje1@dgmarkt.com" and "Test12345" and clicks login

  @D2DGMRT-27
  Scenario: The user should be able to terminated log out
    When The user click to my account button
    And The user click to logout button
    Then Verify that the user has securely terminated the session and sees the account logout page

  @D2DGMRT-28
  Scenario: The user should be able to log out with exit button (X)
    When The user click to exit button for the browser close
    Given The user navigate to web page
    Then The user verify that current browser is not old browser
    Then Verify that the user has securely terminated the session and the login panel page is open

  @D2DGMRT-29
  Scenario: The user cannot re-login with "back to page"  icon in browser, if the user has successfully logged out
    When The user click to my account button
    And The user click to logout button
    Then Verify that the user has securely terminated the session and sees the Account Logout Page
    And  The user click to go back button
    Then Verify that successfully logged out

  @D2DGMRT-30
  Scenario: The user should be automatic logout when there is no movement on the site for a certain period of time
    When The user waits 10 minutes without any movement on the web page
    And  The user click to refresh button
    Then Verify that automatic logged out of the web page

  @D2DGMRT-31
  Scenario: The user should be see the session is not active when click to go back after 10 minutes if navigate to a new web site
    When The user navigate to page "https://www.google.com/"
    And The user  waits  10 minutes and click to go back button
    Then Verify that automatic logged out of the web page