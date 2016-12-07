package dataObject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="content")
public class ContentItem {
	String ContentId; 
	String property;
	String type;
	String episode;
	String franchise;
	String series;
	
	@DynamoDBHashKey(attributeName="ContentId")  
	public String getContentId() {
		return ContentId;
	}
	public void setContentId(String ContentId) {
		this.ContentId = ContentId;
	}
	
	@DynamoDBAttribute(attributeName="property") 
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	@DynamoDBAttribute(attributeName="type") 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@DynamoDBAttribute(attributeName="episode") 
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	
	@DynamoDBAttribute(attributeName="franchise") 
	public String getFranchise() {
		return franchise;
	}
	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}
	
	@DynamoDBAttribute(attributeName="series") 
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	
	public ContentItem(String ContentId, String type, String property, String franchise, String series, String episode) {
		this.ContentId = ContentId;
		this.type = type;
		this.property = property;
		this.franchise = franchise;
		this.series = series;
		this.episode = episode;
	}
	public ContentItem(){
		
	}

}
