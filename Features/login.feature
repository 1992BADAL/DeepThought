Feature: Login Functionality

  Scenario Outline: Login with Valid credentials
    Given User has navigates to login page
    When User enters valid email address <username> into email field
    And User has enterd valid password <password> into the password field
    And User clicks on Login button
    Then User should get successfully logged in
    Examples:
    |  username               | password  |
    |mondalbadal79@gmail.com  | 1992Badal |
    |mondalbadal790@gmail.com | 1992Badal |
  Scenario: Login with invalid credentials
    Given User has navigates to login page
    When User enters invalid email address into email field
    And User has enterd invalid password "123456789" into the password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User has navigates to login page
    When User enters valid email address "mondalbadal79@gmail.com" into email field
    And User has enterd invalid password "123456789" into the password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User has navigates to login page
    When User enters invalid email address into email field
    And User has enterd valid password "12345" into the password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User has navigates to login page
    When User dont enters any email address into email field
    And User dont enterd any password into the password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
