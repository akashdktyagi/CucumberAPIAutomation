package product.bestbuyapi;

import java.util.HashMap;
import java.util.Map;

public class ScnContext {

	private Map<String,String> SCN_DATA  = new HashMap<String,String>();
	
	public void SetScnData(String key,String value) {
		SCN_DATA.put(key, value);
	}
	
	public String GetScnData(String key) {
		return SCN_DATA.get(key);
	}
	
}
