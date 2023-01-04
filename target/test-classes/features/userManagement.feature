Feature: Crater User Management
  User management focuses on user creation, update, delete, and authentication.

  @validLoginTest
  Scenario: User is able to login successfully
    Given user is on the login page
    When user enters valid "marci.brenner@yahoo.com" and "Password1234"
    And user clicks on login button
    Then user should be navigated to the dashboard page

  @invalidLoginTest
  Scenario: Invalid login attempts
    Given user is on the login page
    When user enters invalid "username@mail.com" and "wrongpassword"
    And user clicks on login button
    Then an error message appears
    And user is not logged in
