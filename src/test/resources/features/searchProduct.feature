// Gherkin format to the Product Search functionality
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
        Then "<number_of_product>" are displayed
        Examples:
          | product       | number_of_product  |
          | alpro         | 45                 |
          | Alpro kokusz  | 2                  |

    @TC_ProductSearch_NOK
    Rule: Searching for a product unavailable in the catalogue
      Scenario Outline: Search with a product name consisting of only one word unavailable in the catalogue
        When when searching for unavailable "<product>"
        Then message is displayed with "Sajnos nem található olyan termék, amely a “<unavailable_product>” keresési feltételnek megfelelne."
        Examples:
          | product         | unavailable_product |
          | cocomas         | cocomas             |
          | mandula joghurt | mandula joghurt     |


    """
    Rule: Searching for a product available in the catalogue
      Scenario: Search with product name consisting of multiple words available in the catalogue
        When searching for existing <product_first product_second>
        Then products containing <product_first product_second> name are displayed

    Rule: Searching for a product unavailable in the catalogue
        When when searching for unavailable <product>
        Then message is displayed with "Sajnos nem található olyan termék, amely a “<product>” keresési feltételnek megfelelne."

    Rule: Searching for a product unavailable in the catalogue
        When when searching for unavailable <product_first product_second>
        Then message is displayed with "Sajnos nem található olyan termék, amely a “<product_first product_second>” keresési feltételnek megfelelne."

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name only consisting of uppercase letters
        When searching for existing <PRODUCT_FIRST PRODUCT_SECOND>
        Then products containing <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name are displayed

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name consisting of uppercase and lowercase letters
        When searching for existing <PRODUCT_FIRST product_second>
        Then products containing <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name are displayed

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name only consisting of lowercase letters
        When searching for existing <product_first product_second>
        Then products containing <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name are displayed

    Rule: Searching only with special characters
      Scenario: Search with special character "*"
        When searching with "*"
        Then message is displayed saying "Sajnos nem található olyan termék, amely a “*” keresési feltételnek megfelelne."

    Rule: Searching only with special characters
      Scenario: Search with special character "?"
        When searching with "?"
        Then message is displayed with "Sajnos nem található olyan termék, amely a “?” keresési feltételnek megfelelne."

    Rule: Searching only with special characters
      Scenario: Search with special character " "
        When searching with " "
        Then message is displayed with "Sajnos nem található olyan termék, amely a “ ” keresési feltételnek megfelelne."


