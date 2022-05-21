@smoke

  Feature: F04_Search | user can search products
    Scenario: user search for product successfully
      Given user open browser for search
      And user navigate to website for search
      And user login to search

      When user types "apple"
      And user press search

      Then search page title should be displayed