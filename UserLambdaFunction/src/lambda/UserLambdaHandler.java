package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UserLambdaHandler implements RequestHandler<HTTPRequest, Object> {
    
    @Override
    public Object handleRequest(HTTPRequest input, Context context) {
        
        if (input.method.equals("GET")) {
            if (input.getParams().containsKey("email"))
                return input.getParams().get("email");
            return "GET";
        }
        return "Hello World";
        // UserDAO userDao = new UserDAO();
        // return userDao.getAll();
        // return "Hello World";
    }
    
}
