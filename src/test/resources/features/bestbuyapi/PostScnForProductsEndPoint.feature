
Feature: Post Request fr Products End Point
  I want to test Post requests for Products end point
 	@wip
   Scenario: Create new product
    Given Best Buy API is up and running
    When I submit product post request with unique name
    Then API returns the response with status code as 201
    And  new product is created in the system
    And new product is correctly saved in database