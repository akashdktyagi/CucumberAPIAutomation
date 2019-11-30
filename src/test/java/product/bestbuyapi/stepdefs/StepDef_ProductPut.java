package product.bestbuyapi.stepdefs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import product.bestbuyapi.utils.BaseClass;

public class StepDef_ProductPut extends BaseClass{
	


	String updated_product_name ; 
	String updated_product_type; 
	String updated_product_upc ; 
	String updated_product_description ; 
	String updated_product_model ; 


	@When("I set headers and updated json request Body")
	public void i_set_headers_and_updated_json_request_Body() {

		//Set Header content type as Json without this record will not be created
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");

		//Create a JSON Object
		//Check the dependency in Pom xml for this Object
		JSONObject param = new JSONObject();
		updated_product_name = GetRandomString(5); 
		updated_product_type = GetRandomString(4); 
		updated_product_upc = GetRandomString(2); 
		updated_product_description = GetRandomString(10)+" "+ GetRandomString(20); 
		updated_product_model = GetRandomString(1); 
		param.put("name", updated_product_name);
		param.put("type", updated_product_type);
		param.put("upc", updated_product_upc);
		param.put("description", updated_product_description);
		param.put("model", updated_product_model);
		//Get the Json String
		String req_body = param.toJSONString();

		_REQUEST_SPEC.when().body(req_body).headers(headers);
		scn.write("Headers set as: "+headers+"\nJson Req Body: " + req_body);
	}

	@When("I set PUT products api endpoint with id {int}")
	public void i_set_PUT_products_api_endpoint_with_id(Integer arg) {
		_RESP = _REQUEST_SPEC.when().put("/products/"+arg);
		scn.write("End Point for put: /products/"+arg);
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
