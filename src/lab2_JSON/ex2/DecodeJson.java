package lab2_JSON.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class DecodeJson {
	public User decodeObject(JsonObject jo) {
		String firstName = jo.getString("firstName");
		String lastName = jo.getString("lastName");
		int age = jo.getInt("age");
		
		JsonObject addressObject = jo.getJsonObject("address");
		String streetAddress = addressObject.getString("streetAddress");
		String city = addressObject.getString("city");
		String state = addressObject.getString("state");
		long postalCode = addressObject.getInt("postalCode");
		Address address = new Address(postalCode, streetAddress, city, state);

		JsonArray phoneNumberArray = jo.getJsonArray("phoneNumbers");
		ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
		for(int i = 0; i < phoneNumberArray.size(); i++) {
			JsonObject phoneNumberObject = phoneNumberArray.getJsonObject(i);
			String type = phoneNumberObject.getString("type");
			String number = phoneNumberObject.getString("number");
			PhoneNumber phoneNumber = new PhoneNumber(type, number);
			phoneNumbers.add(phoneNumber);
		}
		User user = new User(
				firstName, 
				lastName, 
				age, 
				address, 
				phoneNumbers.toArray(new PhoneNumber[0])
			);
		return user;
	}

	public ArrayList<User> decodeArray(JsonArray jsonArray) {
		ArrayList<User> users = new ArrayList<>();
		
		for(JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
			users.add(decodeObject(jsonObject));
		};
	
		return users;
	}
	
	public JsonReader readFile(String filePath) throws FileNotFoundException {
		InputStream in= new FileInputStream(filePath);
		JsonReader reader = Json.createReader(in);
		return reader;
	}
}
