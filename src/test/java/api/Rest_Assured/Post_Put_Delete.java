package api.Rest_Assured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import org.json.JSONObject;

public class Post_Put_Delete {
	
	  @Test
	  public void post_request() {
		  
		  File file = new File("resources/create_employee.json");
		  
		  String name = given()
		  	.baseUri("https://reqres.in")
		  	.contentType(ContentType.JSON)
		  	.body(file).
		  when()
		  	.post("/api/users").
		  then()
		  	.statusCode(201)
		  	.body("name", equalTo("morpheus"))
		  	.extract().path("name");
		  
		  System.out.println(name);
	  }
	  
	  @Test
	  public void post_request_using_JSON_object() {
		  
		  JSONObject body = new JSONObject(); 
		  body.put("name", "azad10");
		  body.put("job", "react developer");
		  
		  String job = given()
		  	.baseUri("https://reqres.in")
		  	.contentType(ContentType.JSON)
		  	.body(body.toString()).
		  when()
		  	.post("/api/users").
		  then()
		  	.statusCode(201)
		  	.body("name", equalTo("azad10"))
		  	.extract().path("job");
		  
		  System.out.println(job);
	  }
	  
	  @Test
	  public void put_request_by_json() {
		  
		  JSONObject body = new JSONObject();
		  body.put("name", "azad10");
		  body.put("job", "php developer");
		  
		  String job = given()
		  		.baseUri("https://reqres.in")
		  		.contentType(ContentType.JSON)
		  		.body(body.toString()).
		 when()
		 		.put("/api/users/2").
		 then()
		 		.statusCode(200)
		 		.extract().path("job");
		  
		  System.out.println(job);
		  
	  }
	  
	  @Test
	  public void delete_request() {
		  
		 given()
		  		.baseUri("https://reqres.in").

		 when()
		 		.delete("/api/users/2").
		 		
		 then()
		 		.statusCode(204);
		 
	  }

  
}
