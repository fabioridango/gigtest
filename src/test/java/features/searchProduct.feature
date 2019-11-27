@UITest
Feature: Search

  As an user
  I want to be able to search a product category
  so I can check its availability on website

  Scenario Outline: Successful search in case of available product category
    Given I am on home page
    When I search by product category "<product category>"
    Then I should see the search result page with the product list

    Examples:
      | product category |
      | black dress      |

  Scenario Outline: Unsuccessful search in case of unavailable product category
    Given I am on home page
    When I search by product category "<product category>"
    Then I should see the message "No results were found for your search" "<product category>"

    Examples:
      | product category |
      | unavailable      |

  Scenario: Unsuccessful search in case of blank search input
    Given I am on home page
    When I search with blank search input
    Then I should see the message "Please enter a search keyword"



