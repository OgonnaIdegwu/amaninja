Feature: HomeScreen User Journey
    Scenario: Home page recycler items validation
        Given User is logged in and on home Screen
        Then User should be able to see 4 Product items
        Then product items should have the following components
        |image|
        |description|
        |price|
        |statusbar|
        |chooseOptionButton|
