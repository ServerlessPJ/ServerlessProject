package dataObject;

import java.util.List;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class AddressDAO {
	private AmazonDynamoDBClient dynamoDB;
	private DynamoDBMapper mapper;
	
    public void init() {
        dynamoDB = new AmazonDynamoDBClient();
        Region region = Region.getRegion(Regions.US_EAST_1);
        dynamoDB.setRegion(region);
        mapper = new DynamoDBMapper(dynamoDB);
    }
    
    public List<AddressItem> scan() {
    	//ScanRequest scanRequest = new ScanRequest("Address");
        //ScanResult scanResult = dynamoDB.scan(scanRequest);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<AddressItem> scanResult = mapper.scan(AddressItem.class, scanExpression);
        return scanResult;
    }
}
