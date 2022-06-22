@smoke

  Feature: F02_Login | user could log in with valid email and password


    Scenario: user enter valid credentials
      Given user open browser for login
      And user navigates to website for login
      And user click on Login button

      When user enter "automation2@testing.com" and "P@ssw0rd"
      And user press Login button

      Then user should be navigated to home page
      And user should see My account tab
#      And close browser for login
