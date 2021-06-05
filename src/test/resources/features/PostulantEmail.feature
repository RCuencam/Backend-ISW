Feature: Postulant functionality

  Scenario Outline: As a Postulant i want to register with my email.

    Given I am in the register seccion
    And register with id <id> and email
    Then I should be able to register
    Examples:
      |id  |
      |1  |

  Scenario Outline: As a Postulant i want to see a error if the email is in use.

    Given I am in the register seccion
    And register a repeat email
    Then I should see a message <errors>
    Examples:
     |errors|
     |"El email ya esta en uso"|