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
#------------------------------------------------------------------------------------------------------------------------------

#Author: Vaibhav

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
    		
