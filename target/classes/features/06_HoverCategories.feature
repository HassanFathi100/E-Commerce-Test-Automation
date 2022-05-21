
Feature: F06_hoverCategories | user could hover categories and select sub category

  Scenario: user could hover categories
    Given user open browser to change category
    And user navigate to website to change category
#    And user login to change category

    When user hover category and select subcategory

    Then page title should be as the subcategory title