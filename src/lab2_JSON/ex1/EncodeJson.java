package lab2_JSON.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class EncodeJson {
	public String genjson(Employee e) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", e.getId());
		builder.add("name", e.getName());
		builder.add("salary", e.getSalary());
		JsonObject  jo = builder.build();
		return jo.toString();
	}
	
	public void export(String filePath, String json) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new FileOutputStream(filePath), true);
		out.print(json);
		out.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		EncodeJson ej = new EncodeJson();
		Employee employee = new Employee(10010, "Nguyen Van B", 10000);
		String js = ej.genjson(employee);
		ej.export("json/emp.json", js);
	}
}
