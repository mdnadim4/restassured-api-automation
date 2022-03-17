package api.Rest_Assured;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_Request {
	
	@Test
	public void verify_status_code() {
		
		given()
			.baseUri("https://reqres.in").		
		when()
			.get("/api/users?page=2").
		then()
			.statusCode(200);
		
	}
	
	@Test
	public void validate_json_response() {
		
		given()
			.baseUri("https://reqres.in")
			.queryParam("page", "2").		
		when()
			.get("/api/users").
		then()
			.statusCode(200)
			.body(
				"data[0].id", equalTo(7),
				"data[0].email", equalTo("michael.lawson@reqres.in"),
				"data[0].first_name", equalTo("Michael"),
				"data[0].last_name", equalTo("Lawson"),
				"data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg")	
			);
	}
	
	@Test
	public void validate_xml_response() {
		
		given()
			.baseUri("https://api.openweathermap.org/data/2.5")
			.queryParam("q", "London")
			.queryParam("appid", "be9eda1555c7310399b0e7552aa960de")
			.queryParam("mode", "xml").		
		when()
			.get("/weather").
		then()
			.statusCode(200)
			.body(
				"current.city.@name", equalTo("London"),
				"current.city.@id", equalTo("2643743"),
				"current.city.country", equalTo("GB")
			);
	}
	
	@Test
	public void extract_response_data() {
		
		Response res = given()
			.baseUri("https://reqres.in").	
		when()
			.get("/api/users?page=2").
		then()
			.extract().response();
		
		System.out.println(res.asString());
	}
	
	@Test
	public void extract_single_value() {
		
		String unit = given()
			.baseUri("https://api.openweathermap.org/data/2.5")
			.queryParam("q", "London")
			.queryParam("appid", "be9eda1555c7310399b0e7552aa960de")
			.queryParam("mode", "xml").		
		when()
			.get("/weather").
		then()
			.statusCode(200)
			.body(
				"current.city.@name", equalTo("London"),
				"current.city.@id", equalTo("2643743"),
				"current.city.country", equalTo("GB")
			)
			.extract().path("current.temperature.@unit");
		
		System.out.println(unit);
	}
	
	@Test
	public void verify_status_line() {
		
		given()
			.baseUri("https://api.printful.com").
		when()
			.get("/variant/1").
		then()
			.statusCode(404)
			.statusLine("HTTP/1.1 404 Not Found");
		
	}
	

}
