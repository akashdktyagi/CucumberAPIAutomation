@Products
Feature: Post Request Feature
  I want to create a product and findout wheather it get created or not

@post @e2e
	Scenario: Post a product
    	Given Best Buy API is up and running
 			When I set headers and json request Body 
    		And I set POST products api endpoint
		 Then API returns the response with status code as 201
    		And Fetch new generated product id
    		And Validate Product by Name
    		
