package lab2_JSON.ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class EncodeJson {
	public JsonObject addressToJson(Address a) {
		return Json.createObjectBuilder().add("streetAddress", a.getStreetAddress()).add("city", a.getCity())
				.add("state", a.getCity()).add("postalCode", a.getPostalCode()).build();
	}

	public JsonObject phoneNumberToJson(PhoneNumber pn) {
		return Json.createObjectBuilder().add("type", pn.getType()).add("number", pn.getNumber()).build();
	}

	public JsonObject userToJson(User user) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("firstName", user.getFirstName());
		builder.add("lastName", user.getLastName());
		builder.add("age", user.getAge());
		builder.add("address", addressToJson(user.getAddress()));

		JsonArrayBuilder phoneNumesBuilder = Json.createArrayBuilder();
		Arrays.asList(user.getPhoneNumbers()).forEach((phoneNumber) -> {
			phoneNumesBuilder.add(phoneNumberToJson(phoneNumber));
		});
		
		builder.add("phoneNumbers", phoneNumesBuilder.build());
		return builder.build();
	}
	
	public JsonArray listUserToJson(ArrayList<User> users) {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		users.forEach((user) -> {
			builder.add(userToJson(user));
		});
		return builder.build();
	}
	
	public void export(String filePath, String json) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new FileOutputStream(filePath), true);
		out.print(json);
		out.close();
	}
}
