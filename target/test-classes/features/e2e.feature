Feature: End to End E comerce website verification

  Scenario: Add to cart verification
    Given I open the website url "https://rahulshettyacademy.com/loginpagePractise/"
    When I enter username "rahulshettyacademy" and password "learning" and login
    Then I verify  "Shop Name"
    And added all products to cart
    Then I validate the "Checkout"
     
