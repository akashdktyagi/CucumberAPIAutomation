Feature: Best Buy API Get Product Info
  This feature is to validate all the Get Requests for Products

	@get
  Scenario: Get product based on ID and validate type, category
    Given Best Buy API is up and running
    When I search product with id as 185267
    Then API returns the response with status code as 200
    And validate id is displayed as 185267
    And validate type is displayed as "HardGood"
    And validate category is displayed as "Alkaline Batteries"

	@get
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
      
      



      
