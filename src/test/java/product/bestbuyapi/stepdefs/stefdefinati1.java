package product.bestbuyapi.stepdefs;
 import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class stefdefinati1 {

	public static void main(String[] args) {
		
		String baseuri = "http://localhost:3030";
		
		given().baseUri("baseuri").
		when().get("/products/913294").
		then().assertThat().statusCode(200);
		
		
		
		
		//doing another approch 
		
		RequestSpecification req_spec = given().baseUri(baseuri);
		 Response resp   = req_spec.when().get("/products/913294");
		    ValidatableResponse valid_resp  = resp.then();
		    valid_resp.assertThat().body("id", equalTo("919234"));
	}

}
