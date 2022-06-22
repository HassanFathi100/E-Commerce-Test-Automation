@smoke
Feature: F09_AddToCart | Logged user could add different products to Shopping cart

  Scenario: user can add items to cart
    Given user open browser to add to cart
    And user navigate to website to add to cart
    And user login to add to cart

    When user navigate to product to add to cart
    And user click on Adidas shoes to add to cart
    And user choose size to add to cart
    And user click on add to cart

    Then user should see added to cart successfully