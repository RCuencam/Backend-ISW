Feature: Register a new Employeer

  Scenario Outline: As a Employeer i want to see a error if the number is in use.

    Given I am in the register seccion
    And register a repeated number
    Then I should see a error message <error>
    Examples:
      |error                     |
      |"El numero ya esta en uso"|