@post
Feature: Post requests
 	@post
   Scenario: Create new category with unique name and id
    Given Best Buy API is up and running
    When I submit categories post request with unique name and id
    Then API returns the response with status code as 201
    And  new cateogry is created in the system
    And new category is correctly saved in database
    
   @post
   Scenario: Negative test-new category should not be created if already present
    Given Best Buy API is up and running
    When I submit post request with "id already present"
    Then API returns the response with status code as 400
    And  reponse should have bad request error message as "id must be unique"
    
   @post
   Scenario: Negative test-new category should not be created if extra tag is added in the post body request
    Given Best Buy API is up and running
    When I submit post request with "incorrect tags in the request body"
    Then API returns the response with status code as 400
    And  reponse should have bad request error message as "should NOT have additional properties"  
    
    
    
    
    
      