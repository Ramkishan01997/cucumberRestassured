package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.testDataBuild;

public class stepDefination {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    testDataBuild data=new testDataBuild();
	@Given("Add place payload")
	public void add_Place_Payload() {
		RestAssured.baseURI="";
		RequestSpecification req=new RequestSpecBuilder()
				.setBaseUri("")
				.setContentType(ContentType.JSON).build();
		resspec=new ResponseSpecBuilder().expectStatusCode(200)
				.build();
		res=given().spec(req).body("");
	}
	
	@When("user calls {string} with post request")
	public void user_call_With_post_httpRequest() {
		
	}
	
	@Then("Api call got sucess with status code {int}")
	public void the_API_call_got_success_with_status_code() {
           		
	}
	
	@Then("{string} in response body is {int}")
	public void status_in_response_body_is(String status, int code) {
		System.out.println("test case is running");
	}
	
	@Then("string in response body is {string}")
	public void in_response_body_is(String status, String scope) {
		
	}
	
	
}