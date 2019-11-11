package product.bestbuyapi;

import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContextDI {

	private RequestSpecification _REQUEST_SPEC;
	private Response _RESP;
	
	
	public RequestSpecification get_REQUEST_SPEC() {
		return _REQUEST_SPEC;
	}
	public void set_REQUEST_SPEC(RequestSpecification _REQUEST_SPEC) {
		this._REQUEST_SPEC = _REQUEST_SPEC;
	}
	public Response get_RESP() {
		return _RESP;
	}
	public void set_RESP(Response _RESP) {
		this._RESP = _RESP;
	}
	public Scenario get_SCN() {
		return _SCN;
	}
	public void set_SCN(Scenario _SCN) {
		this._SCN = _SCN;
	}
	private Scenario _SCN;
}
