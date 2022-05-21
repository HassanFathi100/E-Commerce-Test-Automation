@smoke

  Feature: F05_ChangeCurrency | logged User could switch between currencies US-Euro

    Scenario: user can change currency successfully
      Given user open browser for changing currency
      And user navigates to website for changing currency
      And user login to change currency
      And user choose euro

