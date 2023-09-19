Feature: Registration functionality

  Scenario: User creates an account with all fields
    Given User navigates to Registration Account page
    When User enters the details into below fields
      | Username | 1992Badal                  |
      | password | 1234                       |
    And User clicks on registerNow button 
    Then User account should created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Registration Account page
    When User enters the details into below fields with the duplicate email
      | Username  | 1992Badal                  |
      | email     | mondalbadal79@gmail.com 	 |             |
      | password  | 1234                       |
    And User clicks on registerNow button 
    Then User should get a proper warning about duplicate emali

  Scenario: User create an account without filling any details
    Given User navigates to Registration Account page
    When User dont enter any details into fields
    And User clicks on registerNow button 
   