@smoke
Feature: F11_AddToCart | Logged user could add different products to compare list

  Scenario: user can add items to compare list
    Given user open browser to add to compare list
    And user navigate to website to add to compare list
    And user login to add to compare list

    When user navigate to product to add to compare list
    And user click on Adidas shoes to add to compare list
    And user choose size to add to compare list
    And user click on add to compare list

    Then user should see added to compare list successfully