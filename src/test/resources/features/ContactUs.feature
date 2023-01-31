# NOTE PLEASE DO NOT CLICK ON SUBMIT BUTTON
Feature: Contact Us validation
  Scenario: Validate Input form
    Given User is logged in and on Contact us page
    Then Details should be filled in contact us form
      |Abdul          |salam          |salam@gmail.com    |This is a comment |
      |nick           |allen          |nick@gmail.com     |This is a comment |
      |bread          |crum           |bread@gmail.com    |This is a comment |
      |horse          |man            |horse@gmail.com    |This is a comment |
      |cat            |evil           |cat@gmail.com      |This is a comment |
      |dog            |friend         |dog@gmail.com      |This is a comment |