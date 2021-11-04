Feature: Post Job Functionality



  Scenario Outline: As a postulant i dont want postulate a jobs with low minimum salary
    Given I want a new job
    And The job offer have a low minimum <salary>
    Then I should be able to see <error>
    Examples:
      | salary | error                                     |
      | 910    | "El salario debe ser mayor o igual a 930" |