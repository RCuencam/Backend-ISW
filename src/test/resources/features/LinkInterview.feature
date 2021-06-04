Feature: Validate Link Interview
  Scenario Outline: As a postulant i want to access a interview through the link
    Given I am in the interview section
    And I register the interview link <link>
    Then I want to see the <message>
    Examples:
      | link                                                                         | message                             |
      | "https://us04web.zoom.us/j" | "successful access to the platform" |



