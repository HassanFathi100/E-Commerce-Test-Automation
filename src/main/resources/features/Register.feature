Feature: user should be able to register in the website and

  #Test Scenario 1
  Scenario: user enter valid registration data
    Given user open browser
    And user go to registration page

    When user enters valid data
    And press "Resister" button

    Then user should see successfull registration message
