package product.bestbuyapi.stepdefs;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class DemoGetPost {

	
	@Test
	public void useconstr() {
		
		
	}
	
	
	
	@Test
	public void verifyNameStructured() {
		
		RestAssured.baseURI="http://localhost:3030";
		RestAssured.given().when().get("/healthcheck").then().body("name", equalTo("ravi"))
		.body("info.status", equalTo("open"));
		
	}
	@Test
	public void aCarGoesIntoGarage() {//post call : we need to create json request
		RestAssured.baseURI="http://localhost:3030";		
		Map<String, String>  car = new HashMap<String, String>();
		car.put("plateName", "xyz123");
		car.put("brand", "audi");
		car.put("colour", "pink");
	    RequestSpecification request   =	RestAssured.given();
	    request.contentType("application/json").body(car)
	    .when().post("/garage/status").then().statusCode(200);
	    //JSONObject jsonobject = new JSONObject();//we send the post request we can use jsonobject;

	    
	    
	    

		
		
		
	}
	

}
