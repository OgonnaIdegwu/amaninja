Feature: User Buy Product Journey
  Scenario: User can checkout success
    Given User is on landing page "https://amaninja.co.uk"
    And User clicks on first item on products list
    Then User should be directed to products page
    Then User clicks "Add to Cart" button
    Then Top basket icon count should update to One
    And Dialog should appear showing user "item added to cart"
    And this dialog should have "View my cart" and "checkout" buttons
    Then User clicks "checkout" button
    Then User should be directed to "checkouts" screen

  Scenario: User Can complete checkout
    Given User is on "checkouts" screen
    Then User enters following details on contact information and shipping info
      |email| test@test.com|
      |country| United Kingdom|
      |firstName| testname|
      |secondName| testSecondName|
      |address| test Address|
      |city| manchester|
      |postcode| CW954RE|
    Then User should navigate to "shipping screen"
    Then Contact field should show "test@test.com"
    And Shipping to should show "test Address, manchester, CW95RE, United Kingdom"
    Then User Clicks "Continue Shipping"
    Then User is navigated to "payment page"