package product.bestbuyapi.stepdefs;

import cucumber.api.java.en.When;
import product.bestbuyapi.utils.BaseClass;

public class StepDef_ProductsDelete extends BaseClass{
	
		
	@When("I set DELETE request with product id as {int}")
	public void i_set_DELETE_request_with_product_id_as(Integer id) {
		_RESP = _REQUEST_SPEC.when().delete("/products/"+id);
		scn.write("End Point: /products/" + id);
	}

}
