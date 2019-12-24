package product.bestbuyapi.stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


public class Tc_goRestAPI {

	private String baseURI = "https://gorest.co.in/";
	private String validAccessToken = "P3nOCsvL-hvERYAJHktd9ZgSoH8QDzBgiTZl";
	private String invalidToken = "InvalidToken";

	@Test(enabled=false)
	public void tc_01_get_request_valid_token() {
		RequestSpecification  request  = RestAssured.given().baseUri(baseURI);
		Response   responce =	request.auth().oauth2(validAccessToken).when().get("/public-api/users");
		ValidatableResponse validresp  = responce.then().assertThat().statusCode(200);
		Reporter.log("http status code" + responce.getStatusCode() + responce.getBody().asString());
		System.out.println("\nhttp status code" + responce.getStatusCode() + responce.getBody().asString());	
		int statuscode   = responce.jsonPath().getInt("_meta.code");
		Assert.assertEquals(statuscode,200,"Valid Token Test case. Status code should come as 200");

		// to get First_name inside the Json 
		List<String>   userFirstName = responce.jsonPath().getList("result.first_name");
		System.out.println("get responce firstName"+responce.asString());


		// to get last_name inside the result object.  		
		List<String>   userLastName = responce.jsonPath().getList("result.last_name");
		System.out.println("\n list of all user last name" +userLastName.toString());


	}
	@Test(enabled=false)
	public void tc_02_get_request_invalid_token() {
		RequestSpecification  invalidtoken  =  RestAssured.given().baseUri(baseURI);
		Response  getresponce = invalidtoken.auth().oauth2(invalidToken).when().get("/public-api/users").thenReturn();	  
		System.out.println("\n ::>>http status code" + getresponce.getStatusCode() + getresponce.getBody().asString());	
		Reporter.log("\n ::>>http status code" + getresponce.getStatusCode() + getresponce.getBody().asString());

	}

	
	
	@Test(enabled=false)
	public void tc_03_validate_status_code() {
		RestAssured.given().baseUri(baseURI).
		auth().oauth2(validAccessToken).
		when().get("/public-api/users").
		then().assertThat().body("_meta.code", equalTo(200));

	}
	//Post http call

	@Test(enabled=false)
	public void tc_04_create_user_credential() {
		//header
		Map<String, String>  storeheader = new HashMap<>();
		storeheader.put("Content-Type", "application/json");


		//body
		JSONObject json_body = new JSONObject();
		json_body.put("first_name", "Ravi");
		json_body.put("last_name", "kanherkar");
		json_body.put("gender", "male");
		json_body.put("email", "kanherkarravi@gmail.com");



		String   alluserdata   = json_body.toJSONString();
		Response responce =	RestAssured.given().baseUri(baseURI).
				body(json_body).headers(storeheader).
				auth().oauth2(validAccessToken).post("/public-api/users").thenReturn();
		System.out.println("\nto get responce:::::"+responce.getStatusCode() + responce.getBody().asString());

		String expected_message ="A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."	;             
		String  actual_result   = responce.jsonPath().getString("_meta.message"); 

		Assert.assertEquals(actual_result, expected_message,  "message display succesfully");

		String id  = responce.jsonPath().getString("result.id");
		Reporter.log("new id genrated on server::>>>"+id);

		// to heat the new created id 

		Response   responce2 = RestAssured.given().baseUri(baseURI).
				auth().oauth2(validAccessToken).
				when().get("/public-api/users" + id ).thenReturn();

		Reporter.log("responce fetch the new user data>>>>>"+responce2.getStatusCode() + responce2.getBody().asString(), true);            

	}
	@Test(enabled=true)
	public void tc_05_user_email_address() {
	RequestSpecification request = RestAssured.given().baseUri(baseURI);
	Response  responce  = request.auth().oauth2(validAccessToken).when().get("/public-api/users");
	ValidatableResponse   validResponce =responce.then().assertThat().statusCode(200);
	 List<String>  mailid = responce.jsonPath().getList("result.email");
	 
	 Reporter.log("list of mail id all user" +mailid.toString());
	 System.out.println("list of mailid >>>" + mailid.toString() );	
	}

	


























	//To get random Key
	public String GetRandomString(int n) {
		// lower limit for LowerCase Letters 
		int lowerLimit = 97; 
		// lower limit for LowerCase Letters 
		int upperLimit = 122; 
		Random random = new Random(); 
		// Create a StringBuffer to store the result 
		StringBuffer r = new StringBuffer(n); 
		for (int i = 0; i < n; i++) { 
			// take a random value between 97 and 122 
			int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1)); 
			// append a character at the end of bs 
			r.append((char)nextRandomChar); 
		} 
		// return the resultant string 
		return r.toString(); 
	} 




}
