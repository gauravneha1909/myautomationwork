package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;


//Capture all the methods that we can do on userendpoints CRUD methods from swagger UI


public class UserEndPoints2 {
	
	static ResourceBundle getURL() 
	
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createuser(User payload)
	{
		String post_url=getURL().getString("post_url");
		
		
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(post_url)
		;
		
		return response;
		
	}
	
	
	public static Response getuser(String username)
	{
		String get_url=getURL().getString("get_url");
	
		Response response=given()
				.pathParam("username", username)
		.accept("application/json")
		.when()
		.get(get_url)
		;
		
		return response;
		
	}
	
	public static Response updateuser(User payload , String username)
	{
	
		String put_url=getURL().getString("put_url");
		Response response=given()
				.pathParam("username", username)
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.put(put_url)
		;
		
		return response;
		
	}
	
	public static Response deleteuser(String username)
	{
	
		String delete_url=getURL().getString("delete_url");
		Response response=given()
				.pathParam("username", username)
		.accept("application/json")
		.when()
		.delete(delete_url)
		;
		
		return response;
		
	}
	

}
