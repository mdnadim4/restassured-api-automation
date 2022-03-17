package api.Rest_Assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Auth {
	
	
	  @Test
	  public void digest_authentication() {
		  
		  	given()
		  		.baseUri("https://postman-echo.com")
		  		.auth().digest("postman", "password").
		  		
		  	when()
		  		.get("/digest-auth").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  		
		  
	  }
  
  
}
