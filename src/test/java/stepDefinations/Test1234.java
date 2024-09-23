package stepDefinations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.TestDataBuild;

import static io.restassured.RestAssured.*;
public class Test1234 {

	public static void main(String[] args) {
		 RestAssured.baseURI = "https://reqres.in/api";
		 TestDataBuild data=new TestDataBuild();
	//Restasssured.baseUri="";
	 Response response = given()
	            .header("Content-Type", "application/json") // Set content type
	            .body(data.userPayload("ramkishan", "engg")).log().all() // Set the request body
	        .when()
	            .post("/users") // POST request to /users
	        .then()
	            .log().all() // Log the response
	            .statusCode(201) // Assert the response status code
//	            .body("name", equals("cd")) // Assert the name in the response
	            //.body("job", equals("soft")) // Assert the job in the response
	            .extract().response(); 

	}

}
