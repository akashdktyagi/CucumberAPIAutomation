package product.bestbuyapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * Hamcrest Matcher Methods
 * equalTo, containsString, hasItem etc
 */
public class StepDefs_GetRequest {
	RequestSpecification _REQUEST_SPEC;
	Response _RESP;
	Scenario scn;
	
	//Hooks
	@Before
	public void beforeHook(Scenario s) {
		this.scn = s;
	}
	
	
	//*********************************************************
	//*********************GIVEN*******************************
	//*********************************************************
	@Given("Best Buy API is up and running")
	public void best_Buy_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri("http://localhost:3030");
	}
	
	

	//*********************************************************
	//*******************WHEN**********************************
	//*********************************************************
	@When("I hit health check url")
	public void hit_health_check_url() {
		_RESP = _REQUEST_SPEC.get("/healthcheck");
	}
	
	
	@When("I hit url with query parameter as {string}")
	public void i_hit_url_with_query_parameter_as(String string) {

		_RESP = _REQUEST_SPEC.get("/products/" + string);
	}

	//**************************************************************
	//*********************THEN*************************************
	//**************************************************************
	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer int1) {
		_RESP.then().assertThat().statusCode(200);

	}

	@Then("all the products will be returned")
	public void all_the_products_will_be_returned() {
		_RESP.then().assertThat().body("total", equalTo(51960));
		scn.write("Response:"+ _RESP.asString());
		scn.write("Scn Name:" + scn.getName());
	}

	@Then("{int} number of product will be returned")
	public void number_of_product_will_be_returned(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("products prices will be returned in descending order")
	public void products_prices_will_be_returned_in_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("products prices will be returned in ascending order")
	public void products_prices_will_be_returned_in_ascending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
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
	
}
