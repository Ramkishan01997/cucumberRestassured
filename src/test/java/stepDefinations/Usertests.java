package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Usertests extends Utils {
	RequestSpecification res;
	TestDataBuild data=new TestDataBuild();
    Response response;
@Given("add user payload with {string} and {string}")
public void add_user_payload_with_and(String name, String job) throws IOException {
//	assertEquals(200, 200);
	res=given().spec(userreq()).body("{\"name\":\"ram\",\"job\":\"soft\"}");
}

@When("user call {string} api with {string} request")
public void user_call_api_with_request(String endUrl, String reqtype) {
//	assertEquals(201, 200);
	APIResources apiresource=APIResources.valueOf(endUrl);
	
	response=res.when().post(apiresource.getResource());
}

@Then("the api call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer statuscode) {

   assertEquals(response.getStatusCode(), 201);
}

@Then("verify that response having {string} , {string} and id")
public void verify_that_response_having_and_id(String name, String job) {
   // String nameres=getJsonPath(response,"name");
  //  String resjob=getJsonPath(response,"job");
	//assertEquals(nameres,name);
	//assertEquals(resjob,job);
}


}
