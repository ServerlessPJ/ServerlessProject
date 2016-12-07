package dao;

import java.util.List;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import model.User;

public class UserDAO {
    
    private AmazonDynamoDBClient dynamoDB;
    private DynamoDBMapper mapper;
    
    public UserDAO() {
        this.init();
    }
    
    public void init() {
        dynamoDB = new AmazonDynamoDBClient();
        Region region = Region.getRegion(Regions.US_EAST_1);
        dynamoDB.setRegion(region);
        mapper = new DynamoDBMapper(dynamoDB);
    }
    
    public List<User> getAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<User> result = mapper.scan(User.class, scanExpression);
        return result;
    }
    
    public User getByEmail(String email) {
        return this.mapper.load(User.class, email);
    }
    
    public User createUser(User newUser) {
        this.mapper.save(newUser);
        return this.mapper.load(User.class, newUser.getEmail());
    }
}
