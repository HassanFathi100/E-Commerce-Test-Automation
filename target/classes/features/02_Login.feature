@regression

  Feature: user can login successfully

    Scenario: user enter valid credentials
      Given user open browser for login
      And user navigates to website for login
      And user click on Login button

      When user enter "automation4@testing.com" and "P@ssw0rd"
      And user press Login button

      Then user should be navigated to home page
      And user should see My account tab
