@regression

Feature: user can reset password
  Scenario: user can change password successfully
    Given user open browser to reset password
    And user navigates to website to reset password
    And user login to reset password

    When user press my account tab
    And click on change password
    And fill data
    And click change password button

    Then user should see confirmation message