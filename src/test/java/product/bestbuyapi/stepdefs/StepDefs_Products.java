package product.bestbuyapi.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import product.bestbuyapi.utils.BaseClass;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class StepDefs_Products extends BaseClass {

	String product_name;
	@When("I submit product post request with unique name")
	public void i_submit_product_post_request_with_unique_name() {

		//Body
		JSONObject body_json = new JSONObject();
		product_name = GetRandomString(5); 

		body_json.put("name", product_name);
		body_json.put("type", "Hard Good");
		body_json.put("upc", "12345676");
		body_json.put("price", 1000);
		body_json.put("description", "Good Product");
		body_json.put("model", "fdsff4");

		scn.write("Product body as " + body_json.toJSONString());

		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		scn.write("Header as " + headers.toString());
		
		_RESP = _REQUEST_SPEC.headers(headers).body(body_json).when().post("/products");
		scn.write("Response: " + _RESP.asString());

		
	}

	@Then("new product is created in the system")
	public void new_product_is_created_in_the_system() {
		_REQUEST_SPEC.get("/products?name=" + product_name).then().assertThat().statusCode(200);
		_REQUEST_SPEC.get("/products?name=" + product_name).then().assertThat().body("data[0].name", equalTo(product_name));
	}

	@Then("new product is correctly saved in database")
	public void new_product_is_correctly_saved_in_database() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	
}
