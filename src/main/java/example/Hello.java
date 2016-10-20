package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class Hello implements RequestHandler<String, String> {

	static AmazonDynamoDBClient dynamoDB;
	
    private static void initDynamoDB() throws Exception {
        /*
         * The ProfileCredentialsProvider will return your [zzhenli]
         * credential profile by reading from the credentials file located at
         * (/Users/derrick/.aws/credentials).
         */
//        AWSCredentials credentials = null;
//        try {
//            credentials = new ProfileCredentialsProvider("zzhenli").getCredentials();
//        } catch (Exception e) {
//            throw new AmazonClientException(
//                    "Cannot load the credentials from the credential profiles file. " +
//                    "Please make sure that your credentials file is at the correct " +
//                    "location (/Users/derrick/.aws/credentials), and is in valid format.",
//                    e);
//        }
        dynamoDB = new AmazonDynamoDBClient();
        Region usEast1 = Region.getRegion(Regions.US_EAST_1);
        dynamoDB.setRegion(usEast1);
    }
    
	
    public String handleRequest(String input, Context context) {
    	try {
    		initDynamoDB();
    	}catch(Exception e) {
    		return e.getMessage();
    	}
    	ScanRequest scanRequest = new ScanRequest("Address");
        ScanResult scanResult = dynamoDB.scan(scanRequest);
//		String output = "Hi, " + input + "!";
		return "Result: " + scanResult;
    }
}