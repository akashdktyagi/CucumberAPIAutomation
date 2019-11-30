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

@put
	Scenario: Put a product
    	Given Best Buy API is up and running
 			When I set headers and updated json request Body 
    		And I set PUT products api endpoint with id 9999682
		  Then API returns the response with status code as 200
    		
