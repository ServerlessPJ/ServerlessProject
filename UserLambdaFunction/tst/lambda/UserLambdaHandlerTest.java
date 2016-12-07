package lambda;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class UserLambdaHandlerTest {
    
    private static HTTPRequest input;
    
    @BeforeClass
    public static void createInput() throws IOException {
        input = new HTTPRequest();
        // .parse("s3-event.put.json", S3Event.class);
    }
    
    private Context createContext() {
        TestContext ctx = new TestContext();
        
        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");
        
        return ctx;
    }
    
    @Test
    public void testUserLambdaHandler() {
        UserLambdaHandler handler = new UserLambdaHandler();
        Context ctx = createContext();
        
        Object output = handler.handleRequest(input, ctx);
        
        // TODO: validate output here if needed.
        if (output != null) {
            System.out.println(output.toString());
        }
    }
}
