package in.hocg.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hocgin on 16-12-17.
 */
public abstract class BaseController {
	
	public Map<String, Object> json_success(final String message, final Object result) {
		return new HashMap<String, Object>(){{
			put("code", 200);
			put("message", message);
			put("result", result);
		}};
	}
	
	public Map<String, Object> json_success() {
		return json_success("SUCCESS", null);
	}
	
	
	public Map<String, Object> json_fail(final int code, final String message) {
		return new HashMap<String, Object>(){{
			put("code", code);
			put("message", message);
			put("result", null);
		}};
	}
	
}
