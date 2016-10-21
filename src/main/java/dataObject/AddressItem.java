package dataObject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Address")
public class AddressItem {
	String country; 
	String city;
	String addressId;
	String state;
	String zipCode;
	String street;
	
	@DynamoDBHashKey(attributeName="address_id")  
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	@DynamoDBAttribute(attributeName="country") 
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@DynamoDBAttribute(attributeName="city") 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@DynamoDBAttribute(attributeName="state") 
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@DynamoDBAttribute(attributeName="zip_code") 
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@DynamoDBAttribute(attributeName="street") 
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public AddressItem(String country, String city, String addressId, String state, String zipCode, String street) {
		this.country = country;
		this.city = city;
		this.addressId = addressId;
		this.state = state;
		this.zipCode = zipCode;
		this.street = street;
	}
	public AddressItem(){
		
	}

}
