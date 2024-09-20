package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		log.println("hello ");
		 req=new RequestSpecBuilder()
				.setBaseUri(getPropertyValue("baseUrl"))
				.addQueryParam("key" ,"qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return req;
}
	public static String getPropertyValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src/test//java//resources//global.properties");
		System.out.println(file);
		prop.load(file);
		return prop.getProperty(key);
		
		
	}
	public String getJsonPath(Response response, String key) {
		
		String res=response.asString();
		JsonPath js=new JsonPath(res);
		return js.get(key).toString();
	}
}
