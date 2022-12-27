Feature: Best Buy API Get Product Info
  This feature is to validate all the Get Requests for Products

	@get
	Scenario: Get All product
    Given Best Buy API is up and running
    When I hit url with query parameter as "all"
    Then API returns the response with status code as 200
    And all the products will be returned

	@get
   Scenario: Get all products, limit to 1 result
    Given Best Buy API is up and running
    When I hit url with query parameter as "$limit=1"
    Then API returns the response with status code as 200
    And  1 number of product will be returned
   
   @get
   Scenario Outline: Get all products, limit to "<count>" results
    Given Best Buy API is up and running
    When I hit url with query parameter as "<limitVal>"
    Then API returns the response with status code as 200
    And  <count> number of product will be returned
    Examples:
    |limitVal|count|
    |$limit=2|2    |
    |$limit=3|3    |
    |$limit=4|4    |
    |$limit=5|5    |
    |$limit=6|6    |
    |$limit=7|7    |        
    |$limit=8|8    |
        
   @get
   Scenario: Get all products, sort by highest price (descending)
    Given Best Buy API is up and running
    When I hit url with query parameter as "$sort[price]=-1"
    Then API returns the response with status code as 200
    And products prices will be returned in descending order
   
   @get 
   Scenario: Get all products, sort by lowest price (ascending)
    Given Best Buy API is up and running
    When I hit url with query parameter as "$sort[price]=1"
    Then API returns the response with status code as 200
    And products prices will be returned in ascending order
   
   @get 
   Scenario: Get all products, but only show the name and price in the result
    Given Best Buy API is up and running
    When I hit url with query parameter as "$select[]=name&$select[]=price"
    Then API returns the response with status code as 200
    And products list should only contain "name" and "price" in the response
   
   @get 
   Scenario: Get products of type HardGood
    Given Best Buy API is up and running
    When I hit url with query parameter as "type=HardGood"
    Then API returns the response with status code as 200
    And products with only type as "HardGood" will be displayed.
    
   @get     
   Scenario: Get products less than or equal to $1.00
    Given Best Buy API is up and running
    When I hit url with query parameter as "price[$lte]=1"
    Then API returns the response with status code as 200
    And products with price less than or equal to "$1.00" will be displayed 
    
   @get
   Scenario: Get products that have 'star wars' in the name and are under $30
    Given Best Buy API is up and running
    When I hit url with query parameter as "name[$like]=*star+wars*&price[$lt]=30"
    Then API returns the response with status code as 200
    And products that have "star wars" in the name and are under "$30" will be displayed 
    
   @get 
   Scenario: Get products that are either $0.99 or $1.99
    Given Best Buy API is up and running
    When I hit url with query parameter as "price[$in]=0.99&price[$in]=1.99"
    Then API returns the response with status code as 200
    And products that are either "$0.99" or "$1.99" will be displayed     

   Scenario: Get products that are either $5 or $6
    Given Best Buy API is up and running
    When I hit url with query parameter as "price[$in]=5&price[$in]=6"
    Then API returns the response with status code as 200
    And products that are either "$5" or "$6" will be displayed 
       
   @get 
   Scenario: Get products that have a shipping price of more than $10
    Given Best Buy API is up and running
    When I hit url with query parameter as "shipping[$gt]=10"
    Then API returns the response with status code as 200
    And products that have a shipping price of more than "$10" will be displayed   
   
   @get 
   Scenario: Get products that are not HardGood or Software
    Given Best Buy API is up and running
    When I hit url with query parameter as "type[$nin][]=HardGood&type[$nin][]=Software"
    Then API returns the response with status code as 200
    And products that are not "HardGood" or "Software" will be displayed       
   
   @get 
   Scenario: Get products that are in category name "Coffee Pods"
    Given Best Buy API is up and running
    When I hit url with query parameter as "category.name=Coffee Pods"
    Then API returns the response with status code as 200
    And products that are in category name "Coffee Pods" will be displayed      
   
   @get 
   Scenario: Get products that are in category ID "abcat0106004" (TV Mounts)
    Given Best Buy API is up and running
    When I hit url with query parameter as "category.id=abcat0106004"
    Then API returns the response with status code as 200
    And products that are in category ID "abcat0106004" will be displayed         
    
    
    
    
    
    
   