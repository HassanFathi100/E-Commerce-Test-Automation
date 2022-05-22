@smoke
Feature: F10_AddToWishList | Logged user could add different products to Wish List

  Scenario: user can add items to wishlist
    Given user open browser to add to wishlist
    And user navigate to website to add to wishlist
    And user login to add to cart

    When user navigate to product to add to wishlist
    And user click on Adidas shoes to add to wishlist
    And user choose size to add to wishlist
    And user click on add to wishlist

    Then user should see added to wishlist successfully