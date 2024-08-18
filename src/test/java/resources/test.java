package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class test {
	RequestSpecification req;
	
	public RequestSpecification requestSpecification() {
		 req=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		
		return req;
	}
	

}
