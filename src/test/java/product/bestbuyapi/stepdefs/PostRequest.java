package product.bestbuyapi.stepdefs;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void RegistrationSuccessful( String all)
	{
		
		
		
	RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	    Response responce =	request.when().get("/products/");
        ValidatableResponse validresponce =	responce.then().assertThat().statusCode(200);
	    System.out.println(" valid responce will be display"+validresponce.toString());

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		response.then().assertThat().statusCode(201);
		

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}
