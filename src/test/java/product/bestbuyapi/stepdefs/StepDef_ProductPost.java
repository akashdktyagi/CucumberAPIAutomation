package product.bestbuyapi.stepdefs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import product.bestbuyapi.utils.BaseClass;
import static org.hamcrest.Matchers.equalTo;

public class StepDef_ProductPost extends BaseClass{
	
	int new_product_id ;
	String new_product_name ; 
	String new_product_type; 
	String new_product_upc ; 
	String new_product_description ; 
	String new_product_model ; 
	
	@When("I set headers and json request Body")
	public void i_set_headers_and_json_request_Body() {
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		
		//Create a JSON Object
		//Check the dependency in Pom xml for this Object
		JSONObject param = new JSONObject();
		new_product_name = GetRandomString(5); 
		new_product_type = GetRandomString(4); 
		new_product_upc = GetRandomString(2); 
		new_product_description = GetRandomString(10)+" "+ GetRandomString(20); 
		new_product_model = GetRandomString(1); 

		param.put("name", new_product_name);
		param.put("type", new_product_type);
		param.put("upc", new_product_upc);
		param.put("description", new_product_description);
		param.put("model", new_product_model);
		//Get the Json String
		String req_body = param.toJSONString();
		
		_REQUEST_SPEC.when().body(req_body).headers(header);
		scn.write("Headers set as: "+header+"\nJson Req Body: " + req_body);
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


	@When("I set POST products api endpoint")
	public void i_set_POST_products_api_endpoint() {
		_RESP = _REQUEST_SPEC.when().post("/products");
		scn.write("I set post products end point");
	}

	@Then("Fetch new generated product id")
	public void fetch_new_generated_product_id() {
		new_product_id = _RESP.jsonPath().getInt("id");
		scn.write("new_product_id display "+ new_product_id);
	}

	@Then("Validate Product by Name")
	public void validate_Product_by_Name() {
	_RESP = _REQUEST_SPEC.when().get("/products?name="+new_product_name);
	_RESP.then().assertThat().statusCode(200);
	_RESP.then().body("name", equalTo(new_product_name));
		scn.write("product found by name");	
	}

}
