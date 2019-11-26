package product.bestbuyapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import product.bestbuyapi.utils.BaseClass;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

/*
 * Hamcrest Matcher Methods
 * equalTo, containsString, hasItem. hasSize etc
 * full list:
 * http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
 */
public class StepDefs_PostRequests extends BaseClass {

	/*
	private RequestSpecification _REQUEST_SPEC;
	private Response _RESP;
	String unique_cat_name;
	String unique_cat_id;
	*/
	//Scenario scn;

	/*
	ContextDI _CNTXT;

	public StepDefs_GetRequest(ContextDI cntxt) {
		this._CNTXT = cntxt;
	}
	 */

	//Hooks
	@Before
	public void beforeHook(Scenario s) {
		this.scn = s;
	}

	@After
	public void afterHook(Scenario s){
		this.scn = s;
		if (_RESP==null) {
			scn.write("Response: No response received.");
		}else {
			scn.write("Response: " + _RESP.asString());
		}
	}

/*
	//*********************************************************
	//*********************GIVEN*******************************
	//*********************************************************
	@Given("Best Buy API is up and running")
	public void best_Buy_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri("http://localhost:3030");
		scn.write("Base URL: http://localhost:3030");

	}


	//*********************************************************
	//*******************WHEN**********************************
	//*********************************************************
	@When("I hit health check url")
	public void hit_health_check_url() {
		_RESP = _REQUEST_SPEC.when().get("/healthcheck");

	}


	@When("I hit url with query parameter as {string}")
	public void i_hit_url_with_query_parameter_as(String arg) {

		if (arg.equalsIgnoreCase("all")){
			_RESP = _REQUEST_SPEC.get("/products/");
			scn.write("End Point for all products: /products");
		}else {
			_RESP = _REQUEST_SPEC.get("/products?" +arg);
			scn.write("End Point: /products?" + arg);
		}
	}

	//**************************************************************
	//*********************THEN*************************************
	//**************************************************************
	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer int1) {
		_RESP.then().assertThat().statusCode(int1);
		scn.write("Status code appearing as: " + int1);

	}

	@Then("all the products will be returned")
	public void all_the_products_will_be_returned() {
		_RESP.then().assertThat().body("total", equalTo(51960));
		scn.write("Scn Ended:" + scn.getName());
	}

	@Then("{int} number of product will be returned")
	public void number_of_product_will_be_returned(Integer count) {
		scn.write("Checking limit key in body has value as " + count);
		_RESP.then().assertThat().body("limit", equalTo(count));

		scn.write("Checking total number of products returned as: " + count);
		_RESP.then().assertThat().body("data",hasSize(count));
	}

	@Then("products prices will be returned in descending order")
	public void products_prices_will_be_returned_in_descending_order() {
		List<Float> list = _RESP.jsonPath().getList("data.price");
		scn.write("prices returned: " + list.toString());

		//Check list is sorted
		boolean isSortedDescending=true;
		for(int i=1;i < list.size();i++){
			if(list.get(i-1).compareTo(list.get(i)) < 0){
				isSortedDescending= false;
				break;
			}
		}

		if (isSortedDescending) {
			scn.write("Price is returned in sorted in descending order");
			org.hamcrest.MatcherAssert.assertThat(true, is(true));
		}else {
			scn.write("Price is not returned in descending order");
			org.hamcrest.MatcherAssert.assertThat(false, is(true));
		}
	}

	@Then("products prices will be returned in ascending order")
	public void products_prices_will_be_returned_in_ascending_order() {
		List<Float> list = _RESP.jsonPath().getList("data.price");
		scn.write("prices returned: " + list.toString());

		//Check list is sorted
		boolean isSortedAscending=true;
		for(int i=1;i < list.size();i++){
			if(list.get(i-1).compareTo(list.get(i)) > 0){
				isSortedAscending= false;
				break;
			}
		}

		if (isSortedAscending) {
			scn.write("Price is returned in sorted ascending order");
			org.hamcrest.MatcherAssert.assertThat(true, is(true));
		}else {
			scn.write("Price is not returned in sorted ascending order");
			org.hamcrest.MatcherAssert.assertThat(false, is(true));
		}
	}

	@Then("products list should only contain {string} and {string} in the response")
	public void products_list_should_only_contain_name_and_price_in_the_response(String arg1, String arg2) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products with only type as {string} will be displayed.")
	public void products_with_only_type_as_will_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products with price less than or equal to {string} will be displayed")
	public void products_with_price_less_than_or_equal_to_will_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that have {string} in the name and are under {string} will be displayed")
	public void products_that_have_in_the_name_and_are_under_will_be_displayed(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that are either {string} or {string} will be displayed")
	public void products_that_are_either_or_will_be_displayed(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that have a shipping price of more than {string} will be displayed")
	public void products_that_have_a_shipping_price_of_more_than_will_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that are not {string} or {string} will be displayed")
	public void products_that_are_not_or_will_be_displayed(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that are in category name {string} will be displayed")
	public void products_that_are_in_category_name_will_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("products that are in category ID {string} will be displayed")
	public void products_that_are_in_category_ID_will_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
*/
	//***************************************************
	//***********************POST************************
	//***************************************************

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

		_RESP = _REQUEST_SPEC.headers(headers).body(body_json).when().post("/categories");
	}

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


	//*************************UTILS**************************
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
