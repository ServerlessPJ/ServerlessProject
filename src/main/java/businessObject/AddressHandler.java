package businessObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import dataObject.AddressDAO;

public class AddressHandler implements RequestHandler<RequestClass, ScanResponseClass> {
	
    public ScanResponseClass handleRequest(RequestClass input, Context context) {
    	AddressDAO addressDAO = new AddressDAO();
    	addressDAO.init();
		return new ScanResponseClass(addressDAO.scan());
    }
}