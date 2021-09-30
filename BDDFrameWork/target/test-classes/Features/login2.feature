Feature: OrangeHRM login functionality

  Scenario: login with valid credentials
    Given User should be on login page
    When User enters username and password
    And clicks on login button
    Then User should be navigated to Dashboard page