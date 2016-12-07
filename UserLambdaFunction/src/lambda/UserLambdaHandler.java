package lambda;

import java.lang.reflect.Field;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import dao.UserDAO;
import model.User;

public class UserLambdaHandler implements RequestHandler<HTTPRequest, Object> {
    
    @Override
    public Object handleRequest(HTTPRequest request, Context context) {
        String action = request.getMethod();
        Object result = null;
        switch (action) {
            case "GET":
                result = this.getUserHandler(request, context);
                break;
            case "POST":
                result = this.createUserHandler(request, context);
                break;
            case "PUT":
                result = this.updateUserHanderl(request, context);
                break;
            case "DELETE":
                result = this.deleteUserHandler(request, context);
                break;
            default:
                break;
        }
        
        return result;
    }
    
    private Object deleteUserHandler(HTTPRequest request, Context context) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private Object updateUserHanderl(HTTPRequest request, Context context) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private Object createUserHandler(HTTPRequest request, Context context) {
        
        User newUser = new User();
        
        try {
            Class<?> clazz = newUser.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(newUser, request.getBody().get(field.getName()));
                field.setAccessible(false);
            }
            
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        UserDAO userDAO = new UserDAO();
        return userDAO.createUser(newUser);
        
    }
    
    private Object getUserHandler(HTTPRequest request, Context context) {
        HTTPResponse response = new HTTPResponse();
        if (request.params.containsKey("email")) {
            response.data = new UserDAO()
                    .getByEmail(request.params.get("email"));
        } else {
            response.data = new UserDAO().getAll();
        }
        
        if (null == response.data) {
            response.code = "404";
            response.errorMessage = "Not Found";
        }
        return response;
    }
    
}
