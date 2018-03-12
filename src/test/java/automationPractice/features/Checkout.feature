@Regression
Feature: I want to add item to cart and  purchase item

    Background:
    Given User is on the home page

  #happy path scenario

  @checkout1 @smoke
  Scenario: Add product to cart
    When I hover on "All Products"
    And I select  "Batteries"
    And I select  "Non-Rechargeable Batteries" Category
    And I select a "AA Batteries" subcategory
    And I select a product"RS Pro Alkaline AA Battery"
    When I select AddToBasket
    And I go to Basket
    Then I should see "RS Pro Alkaline AA Battery" added in my basket
    When I select checkout
    And I provide email address "minpatel78@gmail.com"
    And I select Guestcheckout
    And I add delivery details
    When I select payment
    Then i should see payement page

     @checkout2 @smoke
      Scenario: Add product to cart
        When I hover on "Our Brands"
        And I select brands "ABB"
        And I select category "Junction Boxes"
        And I add product "Steel IP66 Junction Box, RAL 7035" to basket
        When I select AddToBasket
        And I go to Basket
        Then I should see "Steel IP66 Junction Box, RAL 7035" added in my basket
        When I select checkout
        And I provide email address "minpatel78@gmail.com"
        And I select Guestcheckout
        And I add delivery details
        When I select payment
        Then i should see payement page






