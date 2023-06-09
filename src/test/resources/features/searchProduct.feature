# Gherkin format to the Product Search functionality
@TC_All
Feature: As a customer, I want to have a Search functionality for the products to the Tesco online food shopping so that I am able to ease the finding of the desired items.

    Background:
      Given customer is on the home page
      And all cookies are accepted
      And language is set to "magyar"

    @TC_ProductSearch_OK
    Rule: Searching for a product available in the catalogue
      Scenario Outline: Search with a product name available in the catalogue
        When searching for existing "<product>"
        Then "<numberOfProduct>" are displayed
        Examples:
          | product       | numberOfProduct  |
          | alpro         | 45               |
          | Alpro kokusz  | 2                |

    @TC_ProductSearch_NOK
    Rule: Searching for a product unavailable in the catalogue
      Scenario Outline: Search with a product name consisting of only one word unavailable in the catalogue
        When when searching for unavailable "<product>"
        Then message is displayed with "Sajnos nem található olyan termék, amely a “<unavailableProduct>” keresési feltételnek megfelelne."
        Examples:
          | product         | unavailableProduct  |
          | cocomas         | cocomas             |
          | mandula joghurt | mandula joghurt     |




