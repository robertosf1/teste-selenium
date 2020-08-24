@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background: Given I want to write a step with "JJeff"

  @tag1
  Scenario Outline: Title of your scenario outline
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | value | status  |
      |     5 | success |
      |     7 | Fail    |
