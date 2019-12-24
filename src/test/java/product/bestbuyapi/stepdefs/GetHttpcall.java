package product.bestbuyapi.stepdefs;

import org.junit.Test;

import io.restassured.RestAssured;
import  io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetHttpcall {
	
	@Test
	public void verifyproductID() {
		
		String baseURI = "http://localhost:3030";
	    RequestSpecification request  =  RestAssured.given().baseUri(baseURI);
	    Response resp = request.when().get("/products/9132294");
	    ValidatableResponse validresp  = resp.then().assertThat().statusCode(200);
	    System.out.println(resp.getBody().asString());
	    
		
		
		
		
		
		
	}
	
	
	

}
