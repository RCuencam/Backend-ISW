Feature: Postulant functionality


  Scenario Outline: As a Postulant i want to see a error if the email is in use.

    Given I am in the register seccion
    And register a repeat email
    Then I should see a message <errors>
    Examples:
     |errors|
     |"El email ya esta en uso"|