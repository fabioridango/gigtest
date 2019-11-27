@UITest
Feature: Shopping cart

  As an user of the e-commerce website
  I want to be able to add to cart an item
  so that I can see the item in the shopping cart and manage the purchase

  Scenario: Successful proceed to checkout in the shopping cart
    Given I navigate on home page
    When I add on shopping cart the first and second item in the product list of the product category "black dress"
    And I change the quantity to 2 of the second item in the cart
    And I remove the first item
    And I proceed to checkout in the my cart
    Then I should be redirected on authentication page



























