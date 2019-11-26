package product.bestbuyapi._junk;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class ScnContext {

	private Map<String,String> SCN_DATA  = new HashMap<String,String>();
	private Response _RESP;
	
	public Response get_RESP() {
		return _RESP;
	}

	public void set_RESP(Response _RESP) {
		this._RESP = _RESP;
	}

	public void SetScnData(String key,String value) {
		SCN_DATA.put(key, value);
	}
	
	public String GetScnData(String key) {
		return SCN_DATA.get(key);
	}
	
}
