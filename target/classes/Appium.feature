Feature: Validate user is able to create account, search and book flight for travel purpose.

  @Appium
  Scenario: Validate user is able to navigate to the Account section on the app.
    Given User is on home page of the application
    When user tap on account to create an account
    Then user is able to navigate to account section successfully


