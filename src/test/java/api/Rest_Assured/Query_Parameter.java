package api.Rest_Assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Query_Parameter {
	
	  @Test
	  public void single_query_parameter() {
		  
		  given()
		  	.baseUri("https://reqres.in")
		  	.queryParam("page", 2).
	  	
	  when()
	  		.get("/api/users").
		  		
		  then()
		  		.log().all()
		  		.statusCode(200);	  		
		  
	  }
	  
	  @Test
	  public void multiple_query_parameter() {
		  
		  HashMap<String, Object> params = new HashMap<String, Object>();
		  params.put("appid", "be9eda1555c7310399b0e7552aa960de");
		  params.put("mode", "xml");
		  params.put("q", "London");
		  
		  given()
		  		.baseUri("https://api.openweathermap.org/data/2.5")
		  		.queryParams(params).
		  
		  when()
		  		.get("/weather").
		  		
		  then()
		  		.log().all()
		  		.statusCode(200);	  		
		  
	  }
	  
	  @Test
	  public void path_parameter() {
		  

		  // Path parameter URL: https://reqres.in/api/users/{page}
		  
		  given()
		  		.baseUri("https://reqres.in")
		  		.pathParam("page", 2).
		  
		  when()
		  		.get("/api/users/{page}").
		  		
		  then()
		  		.log().all()
		  		.statusCode(200);	  		
		  
	  }
	  
	  @Test
	  public void form_parameter() {
		  
		  	given()
		  		.baseUri("https://postman-echo.com")
		  		.contentType("application/x-www-form-urlencoded;charset=UTF-8")
		  		.formParam("First Name", "William")
		  		.formParam("Last Name", "Smith").
		  	
		  	when()
		  		.post("/post").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  
	  }
  
  
}
