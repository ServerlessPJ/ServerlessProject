package dataObject;

import java.util.List;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;


public class ContentDAO {
	private AmazonDynamoDBClient dynamoDB;
	private DynamoDBMapper mapper;
	
    public void init() {
        dynamoDB = new AmazonDynamoDBClient();
        Region region = Region.getRegion(Regions.US_EAST_1);
        dynamoDB.setRegion(region);
        mapper = new DynamoDBMapper(dynamoDB);
    }
    
    public List<ContentItem> scan() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<ContentItem> scanResult = mapper.scan(ContentItem.class, scanExpression);
        return scanResult;
    }
    
    public ContentItem query(String contentId){
    	return mapper.load(ContentItem.class, contentId);
    }
    
    public boolean createContent(ContentItem newItem) {
    	if (query(newItem.getContentId()) == null){
    		this.mapper.save(newItem);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean updateContent(ContentItem newItem) {
    	if (query(newItem.getContentId()) == null){
    		return false;
    	}
    	else {
    		this.mapper.save(newItem);
    		return true;
    	}
    }
}
