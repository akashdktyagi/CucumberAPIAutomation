#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Best Buy API Get Product Info
  This feature is to validate all the Get Requests for Products

  @get
  Scenario: Get product info based on ID
    Given Best Buy API is up and running
    When I search product with id as 185267
    Then API returns the response with status code as 200
    And validate id is displayed as 185267
    And validate type is displayed as "HardGood"
    And validate category is displayed as "Alkaline Batteries"


  Scenario Outline: Title of your scenario outline
    Given Best Buy API is up and running
    When I search product with id as 185267
    Then API returns the response with status code as 200
    And validate id is displayed as 185267
    And validate type is displayed as "HardGood"
    And validate category is displayed as "Alkaline Batteries"

   Examples: 
      |ID      | STATUS | TYPE     | CATEGORY            |
      | 185267 | 200    | HardGood | Alkaline Batteries  |
      | 3041141 | 200    | HardGood | TV & Home Theater  |