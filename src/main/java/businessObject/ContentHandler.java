package businessObject;

import java.lang.reflect.Field;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dataObject.ContentDAO;
import dataObject.ContentItem;

public class ContentHandler implements RequestHandler<RequestClass, Object> {
	
	private ContentDAO contentDAO = new ContentDAO();
	
    public Object handleRequest(RequestClass input, Context context) {
    	
    	this.initContentDAO();
    	
    	if (input.getMethod().equals("GET"))
    	{
    		return this.getContent(input, context);
    	}
    	else if (input.getMethod().equals("POST")) {
			return this.createContent(input, context);
		}
    	else if (input.getMethod().equals("PUT")){
    		return this.updateContent(input, context);
    	}
    	else if (input.getMethod().equals("DELETE")){
    		
    	}
    	return null;
    }
    
    private void initContentDAO(){
    	contentDAO.init();
    }
    
    private Object getContent(RequestClass input, Context context){
    	ResponseClass response = new ResponseClass();
    	if (input.getParams().containsKey("contentid")){
    		response.setData(contentDAO.query(input.getParams().get("contentid")));
    		if (response.data == null){
    			throw new RuntimeException("404: invalid key");
    		}
    		else {
    			response.setCode("200");
    		}
		}
    	else {
    		response.setCode("200");
    		response.setData(new ScanResponseClass(contentDAO.scan()));
    	}
		return response;
    }
    
    private Object createContent(RequestClass input, Context context){
    	ResponseClass responseClass = new ResponseClass();
        ContentItem newItem = new ContentItem();
        
        try {
            Class<?> clazz = newItem.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(newItem, input.getBody().get(field.getName()));
                field.setAccessible(false);
            }
            
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (contentDAO.createContent(newItem)){
        	responseClass.setCode("200");
        }
        else{
        	throw new RuntimeException("400: item existed already");
        }
        
        return responseClass;
    }
    
    private Object updateContent(RequestClass input, Context context){
    	ResponseClass responseClass = new ResponseClass();
        ContentItem newItem = contentDAO.query(input.getParams().get("contentid"));
        try {
            Class<?> clazz = newItem.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (null != input.getBody().get(field.getName()))
                	field.set(newItem, input.getBody().get(field.getName()));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (contentDAO.updateContent(newItem)){
        	responseClass.setCode("200");
        }
        else{
        	throw new RuntimeException("404: invalid key");
        }
        
        return responseClass;
    }
    
    
}