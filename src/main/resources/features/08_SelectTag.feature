@smoke
Feature: F08_SelectTag | logged user could select different tags

  Scenario: user could hover categories
    Given user open browser to select tag
    And user navigate to website to select tag
    And user login to select tag

    When user select any category
    And user select any tag

    Then page title should contain this tag