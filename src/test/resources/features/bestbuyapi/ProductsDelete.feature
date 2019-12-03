@Products
Feature: Delete Request Feature
  I want to delete a product and findout wheather it get deleted or not

  @delete
  Scenario: Delete a product 
    Given Best Buy API is up and running
    When I set DELETE request with product id as 9999681
		Then API returns the response with status code as 200

