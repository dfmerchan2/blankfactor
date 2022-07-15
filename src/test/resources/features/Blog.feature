#Autor: Diego Fernando Merchan Jimenez

Feature: View and subscribe to BlankFactor blogs
  As a user of the BlankFactor platform
  I want to watch and subscribe to blogs
  To be able to read each of them

  Scenario: Successfully watch and subscribe to blogs
    Given that 'Juan' accesses the BlankFactor platform
    When he enters the blog 'Why Fintech in Latin America Is Having a Boom' by 'Sofia Gonzalez'
    And you signed up with your email 'TestAutomation%s@yopmail.com'
    Then he should see the message 'Thank you for subscribing! Stay tuned.'
    And he could go back to the main page and generate a log of the blogs found