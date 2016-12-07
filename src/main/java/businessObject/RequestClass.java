package businessObject;

import java.util.Map;

public class RequestClass {
	Map<String, String> body;
    Map<String, String> params;
    String method;
    Map<String, String> headers;
    Map<String, String> query;
    
    public Map<String, String> getBody() {
        return body;
    }
    
    public void setBody(Map<String, String> body) {
        this.body = body;
    }
    
    public Map<String, String> getParams() {
        return params;
    }
    
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public Map<String, String> getHeaders() {
        return headers;
    }
    
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    public Map<String, String> getQuery() {
        return query;
    }
    
    public void setQuery(Map<String, String> query) {
        this.query = query;
    }
    
}
