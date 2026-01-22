Feature: Welcome Feature

  @BulletTest @ANDROID @WELCOME
  Scenario: Verify whether user is able to navigate through Welcome screens
    Given User click the Welcome arrows
    Then User should select email icon