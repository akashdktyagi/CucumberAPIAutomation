package product.bestbuyapi._junk;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.equalTo;
public class SampleIgnore_StepDef_FetchProducts {
//list.stream().sorted().collect(Collectors.toList()).equals(list);
	
	/*
	private ScnContext SCN_CONTEXT = null;
	RequestSpecification _RESP_SPEC;
	Response _RESPONSE;
	Scenario _SCN;
	
	//Local variable
	int _product_id;

	//DI constructor
	public SampleIgnore_StepDef_FetchProducts(ScnContext scn_context) {
		this.SCN_CONTEXT = scn_context;
	}
	
	
	//Hooks
	@Before
	public void SetUp(Scenario s) {
		this._SCN = s;
		_SCN.write("Scn started: " + _SCN.getName());
		
	}

	@Given("Best Buy API is up and running")
	public void best_Buy_API_is_up_and_running() {
		try {
			Properties prop = new Properties();
			FileInputStream input;
			input = new FileInputStream("src/test/resources/config.properties");
			prop.load(input);
			String baseUri = prop.getProperty("best_buy_base_uri");
			_RESP_SPEC = given().baseUri(baseUri);
			_SCN.write("API base URI: " + baseUri );
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@When("I search product with id as {int}")
	public void i_search_product_with_id_as(Integer int1) {

		_RESPONSE = _RESP_SPEC.when().get("/products/" + int1);
		//Save product Id in Instance Variable
		_product_id=int1;
		_SCN.write("When API base Get for product id: " + int1 );
	}

	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer status_code) {
		_RESPONSE.then().assertThat().statusCode(status_code);
		_SCN.write("Status code is validated. Code returned successfully as : " + status_code);
	}
    
    
	@Then("validate id is displayed as {int}")
	public void validate_id_is_displayed_as(Integer int1) {
		//Check the right ID data and its type
		_RESPONSE.then().body("id",equalTo(_product_id));
		_SCN.write("Product id is validated.");

	}
    
	@Then("validate type is displayed as {string}")
	public void validate_type_is_displayed_as(String typeValue) {
		//Check the right ID data and its type
		_RESPONSE.then().body("type",equalTo(typeValue));
		_SCN.write("type is coorectl displayed as: " + typeValue);

	}
	
	@Then("validate category is displayed as {string}")
	public void validate_category_is_displayed_as(String strCat) {
		//Check the right ID data and its category
		_RESPONSE.then().body("categories.name[0]",equalTo(strCat));
		_SCN.write("Category is correctly displayed as :" + strCat);

	}
	
	

	@When("^I hit health check url$")
	public void i_hit_the_health_check_url() throws IOException {
		Properties prop = new Properties();
		FileInputStream input;
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);
		String baseUri = prop.getProperty("best_buy_base_uri");
		//_RESP_SPEC = given().baseUri(baseUri).get("/healthcheck");
	}
*/
	
	

}
