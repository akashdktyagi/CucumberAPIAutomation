package product.bestbuyapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import product.bestbuyapi.ContextDI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;

public class StepDefs_PostRequest {

	RequestSpecification _REQ_SPEC;
	Response _RESP;
	String unique_cat_name;
	String unique_cat_id;
	Scenario scn;
	ContextDI _CNTXT;
	
	public StepDefs_PostRequest(ContextDI cntxt) {
		this._CNTXT = cntxt;
	}
	
	@Before
	public void beforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		scn.write("Response: " + _RESP.asString());
	}
/*
	@Given("Best Buy API is up and running")
	public void best_Buy_API_is_up_and_running() {
		String base = "http://localhost:3030/";
		_REQ_SPEC = given().baseUri(base);
		scn.write("Base Uri is : " + base);
	}
	*/
	

	@When("I submit categories post request with unique name and id")
	public void i_submit_categories_post_request_with_unique_name_and_id() {
		//Body
		JSONObject body_json = new JSONObject();
		unique_cat_name = GetRandomString(5); 
		unique_cat_id = GetRandomString(4); 
		body_json.put("id", unique_cat_id);
		body_json.put("name", unique_cat_name);
		
		scn.write("body as " + body_json.toJSONString());
		
		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		scn.write("Header as " + headers.toString());
		
		_RESP = _REQ_SPEC.headers(headers).body(body_json).when().post("/categories");
	}

	/*
	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer int1) {
		_RESP.then().statusCode(int1);
		scn.write("Status code: " + int1);

	}
*/
	@Then("new cateogry is created in the system")
	public void new_cateogry_is_created_in_the_system() {
		_RESP.then().assertThat().body("id", equalTo(unique_cat_id));
		_RESP.then().assertThat().body("name", equalTo(unique_cat_name));
		scn.write("Id and name is correctly coming");
	}

	@When("I submit categories post request with existing name and unique id")
	public void i_submit_categories_post_request_with_existing_name_and_unique_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I submit post request with {string}")
	public void i_submit_post_request_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("reponse should have bad request error message as {string}")
	public void reponse_should_have_bad_request_error_message_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
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
			int nextRandomChar = lowerLimit 
					+ (int)(random.nextFloat() 
							* (upperLimit - lowerLimit + 1)); 

			// append a character at the end of bs 
			r.append((char)nextRandomChar); 
		} 

		// return the resultant string 
		return r.toString(); 
	} 

}
