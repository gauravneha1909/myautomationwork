package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.response.Response;


//Capture all the methods that we can do on userendpoints CRUD methods from swagger UI


public class UserEndPoints {
	
	public static Response createuser(User payload)
	{
	
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(Routes.post_url)
		;
		
		return response;
		
	}
	
	
	public static Response getuser(String username)
	{
	
		Response response=given()
				.pathParam("username", username)
		.accept("application/json")
		.when()
		.get(Routes.get_url)
		;
		
		return response;
		
	}
	
	public static Response updateuser(User payload , String username)
	{
	
		Response response=given()
				.pathParam("username", username)
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.put(Routes.put_url)
		;
		
		return response;
		
	}
	
	public static Response deleteuser(String username)
	{
	
		Response response=given()
				.pathParam("username", username)
		.accept("application/json")
		.when()
		.delete(Routes.delete_url)
		;
		
		return response;
		
	}
	

}
