// Gherkin format to the Product Search functionality


  Feature: As a customer, I want to have a Search functionality for the products to the Tesco online food shopping so that I am able to ease the finding of the desired items.

    Rule: Searching for a product available in the catalogue
      Scenario: Search with a product name consisting of only one word available in the catalogue
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <product> available in the product catalogue
        Then all products that contain that exact <product> name displayed in the search list

    Rule: Searching for a product available in the catalogue
      Scenario: Search with product name consisting of multiple words available in the catalogue
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <product_first product_second> available in the product catalogue
        Then all products that contain that exact <product_first product_second> name displayed in the search list

    Rule: Searching for a product unavailable in the catalogue
      Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <product> available in the product catalogue
        Then a warning message is displayed saying "Sajnos nem található olyan termék, amely a “<product>” keresési feltételnek megfelelne."

    Rule: Searching for a product unavailable in the catalogue
      Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <product_first product_second> unavailable in the product catalogue
        Then a warning message is displayed saying "Sajnos nem található olyan termék, amely a “<product_first product_second>” keresési feltételnek megfelelne."

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name only consisting of uppercase letters
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <PRODUCT_FIRST PRODUCT_SECOND> available in the product catalogue
        Then all products that contain <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name displayed in the search list

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name only consisting of uppercase letters
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <PRODUCT_FIRST product_second> available in the product catalogue
        Then all products that contain <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name displayed in the search list

    Rule: Searching with case-sensitive search words
      Scenario: Search with existing product name only consisting of uppercase letters
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with the exact product name <product_first product_second> available in the product catalogue
        Then all products that contain <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name displayed in the search list

    Rule: Searching only with special characters
      Scenario: Search with special character "*"
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with special character "*"
        Then a warning message is given saying "Sajnos nem található olyan termék, amely a “*” keresési feltételnek megfelelne."

    Rule: Searching only with special characters
      Scenario: Search with special character "?"
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with special character "?"
        Then a warning message is given saying "Sajnos nem található olyan termék, amely a “?” keresési feltételnek megfelelne."

    Rule: Searching only with special characters
      Scenario: Search with special character " "
        Given customer is on the home page
        And all cookies are accepted
        And language is set to Magyar
        When customer searches with special character " "
        Then a warning message is given saying "Sajnos nem található olyan termék, amely a “ ” keresési feltételnek megfelelne."


