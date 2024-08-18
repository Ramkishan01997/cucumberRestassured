package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.addPlace;
import resources.testDataBuild;
import resources.utils;
public class stepDefination extends utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    testDataBuild data=new testDataBuild();
    
	@Given("Add place payload {string} {string} {string}")
	public void add_Place_Payload(String name,String language,String address) throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		addPlace p=new addPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 9867456778");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(name);
		List<String>myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		Location l=new Location();
		l.setLat(-39.383494);
		l.setLng(33.427362);
//		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		resspec=new ResponseSpecBuilder().expectStatusCode(200)
				.build();
		res=given().spec(requestSpecification()).body(p);
	}
	
	@When("user calls {string} with post request")
	public void user_call_With_post_httpRequest() {
		 response=res.when().post("/maps/api/place/add/json")
				.then().spec(resspec).extract().response();
		System.out.println(response);
	}
	
	@Then("Api call got sucess with status code {int}")
	public void the_API_call_got_success_with_status_code() {
     assertEquals(response.getStatusCode(),200); 

	}
	
	@Then("{string} in response body is {string}")
	public void status_in_response_body_is(String status, String code) {
		System.out.println("test case is running");
		JsonPath js =new JsonPath(response.asString());
		js.get(status);
		assertEquals(js.get(status).toString(),code);
	}
	
	@Then("string in response body is {string}")
	public void in_response_body_is(String status, String scope) {
		
	}
	
	
}