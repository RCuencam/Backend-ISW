Feature: Postulant functionality

  Scenario Outline: As a Postulant i want to register my email.

    Given I am in the register seccion
    And register with email
    Then I should be able to register
    Examples:
      |email  |
    |s      |

  Scenario Outline: As a Postulant i want to see a error if the email is in use.

    Given I am in the register seccion
    And register a repeat email
    Then I should see a message error <error>
    Examples:
      |error|
      |El email ya esta en uso|