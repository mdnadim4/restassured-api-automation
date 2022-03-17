package api.Rest_Assured;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Header_Cookies {
	
	  @Test
	  public void sending_request_header() {
		  
		  	given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD")
		  		.header("If-None-Match", "1872ade88f3013edeb33decd74a4f947")
		  		.header("If-Modified-Since", "Fri, 10 Apr 2015 12:10:04 GMT").
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  		
	  }
	  
	  @Test
	  public void sending_header_request_object() {
		  
		  HashMap<String, Object> headers = new HashMap<String, Object>();
		  headers.put("If-None-Match", "1872ade88f3013edeb33decd74a4f947");
		  headers.put("If-Modified-Since", "Fri, 10 Apr 2015 12:10:04 GMT");
		  
		  	given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD")
		  		.headers(headers).
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  		
	  }
	  
	  @Test
	  public void sending_cookie_request() {
		  
		  	given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD")
		  		.cookie("user", "admin", "moderator", "patient").			// Set the multiple cookies
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  		
	  }
	  
	  @Test
	  public void sending_cookies_using_builder() {
		  
		  Cookie cookie = new Cookie.Builder("userType", "string").setSecured(true).setComment("Test Cookie Comment").build();
		  
		  	given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD")
		  		.cookie(cookie).		// Set the multiple cookies
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200);
		  		
	  }
	  
	  @Test
	  public void validate_response_header() {
		  
		  	given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD").
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200)
		  		.header("content-type", "application/json; Charset=UTF-8")
		  		.header("etag", "cd88b7bed603f30adc006fd86f059fcf");
		  		
	  }
	  
	  @Test
	  public void extract_response_headers() {
		  
		  	Headers headers = given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD").
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200)
		  		.extract().headers();
		  	
		  	System.out.println(headers.getValue("content-type"));
		  	System.out.println(headers.getValue("transfer-encoding"));
		  	System.out.println(headers.getValue("date"));
		  		
	  }
	  
	  @Test
	  public void extract_response_cookies() {
		  
		  	Map<String, String> cookies = given()
		  		.baseUri("http://data.fixer.io/api")
		  		.queryParam("access_key", "e32fe77d24b0cfcb200b5787a2e27247")
		  		.queryParam("symbols", "USD").
		  		
		  	when()
		  		.get("/latest").
		  		
		  	then()
		  		.log().all()
		  		.statusCode(200)
		  		.extract().cookies();
		  	
		  	System.out.println(cookies.get("__cfduid"));
		  		
	  }
  
}
