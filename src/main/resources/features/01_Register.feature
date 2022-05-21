@smoke
Feature: F01_Register | user should be able to register in the website and

  #Test Scenario 1
  Scenario: user enter valid registration data
    Given user open browser for registration
    And user navigates to website for registration
    And user go to registration page

    When user enters valid data
    And press "Resister" button

    Then user should see successful registration message
#    And close browser for registration