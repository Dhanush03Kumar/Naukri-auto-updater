Feature: Update Experience in Naukri Profile

  Scenario: User logs in and updates experience in profile
    Given User is on login page
    When User enters valid username and password
    Then User should be navigated to home page
    When User clicks on profile
    Then User should be navigated to profile page
    When User updates experience details
    Then Experience should be updated successfully
