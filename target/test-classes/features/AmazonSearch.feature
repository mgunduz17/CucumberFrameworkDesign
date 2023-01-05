Feature: Amazon Search

  @amazonSearchTest
  Scenario Outline: Search items on amazon
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And I click on the search button
    Then I should see the search item "<items>" on search results page

    Examples: 
      | items             |
      | coffee mug        |
      | gold coffee mug   |
      | pink coffee mug   |
      | travel coffee mug |
