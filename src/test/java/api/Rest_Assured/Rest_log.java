package api.Rest_Assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class Rest_log {
	
	  @Test
	  public void log_all_details() {
		  
			  given()
				  	.baseUri("https://reqres.in")
				  	.queryParam("page", 2).
			  	
			  when()
			  		.get("/api/users").
			  		
			  then()
			  		.log().all();  		
//			  		.log().everything();			// log all & everything methods are similar
		  
	  }
	  
	  @Test
	  public void log_body() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api/users").
			  		
			  	then()
			  		.log().body();
		  			
	  }
	  
	  @Test
	  public void log_header() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api/users").
			  		
			  	then()
			  		.log().headers();
		  			
	  }
	  
	  @Test
	  public void log_cookie() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api/users").
			  		
			  	then()
			  		.log().cookies();		
		  		
	  }
	  
	  @Test
	  public void log_status() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api/users").
			  		
			  	then()
			  		.log().status();
		  			
	  }
	  
	  @Test
	  public void log_if_error() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api2/users").
			  		
			  	then()
			  		.log().ifError();
			  		  			
	  }
	  
	  @Test
	  public void log_if_validation_fails() {
		  
		  		given()
		  			.baseUri("https://reqres.in")
		  			.queryParam("page", 2).
		  			
		  		when()
			  		.get("/api/users").
			  		
			  	then()
			  		.log().ifValidationFails()
			  		.statusCode(202);
			  		  			
	  }
}
