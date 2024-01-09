package lab2_JSON.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		DecodeJson decode = new DecodeJson();
		EncodeJson encode = new EncodeJson();

//		Đối với 1 đối tượng

		JsonObject jo = decode.readFile("json/info.json").readObject();
		User user = decode.decodeObject(jo);
		System.out.println("Json to objec: " + user);

		String oj = encode.userToJson(user).toString();
		encode.export("json/user.json", oj);

//		Đối với danh sách đối tượng
		ArrayList<User> listUser = new ArrayList<>();
		listUser.add(new User("Nguyễn Thành", "Tín", 21,
				new Address(10011, "114/2 Vườn Lài, An Phú Đông", "Hồ Chí Minh", "HCM"),
				new PhoneNumber[] { new PhoneNumber("Home", "0334122797") }));
		listUser.add(new User("Đỗ Văn", "Tý", 22, new Address(10011, "134 Vườn Lài, An Phú Đông", "Hồ Chí Minh", "HCM"),
				new PhoneNumber[] { new PhoneNumber("Home", "0334134597") }));

		String js = encode.listUserToJson(listUser).toString();
		encode.export("json/listUser.json", js);

		JsonArray jsonArray = decode.readFile("json/listUser.json").readArray();
		ArrayList<User> users = decode.decodeArray(jsonArray);
		System.out.println("Json to array: ");
		users.forEach((u) -> System.out.println(u.toString()));

	}
}
