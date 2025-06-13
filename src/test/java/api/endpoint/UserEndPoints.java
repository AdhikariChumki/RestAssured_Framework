package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//created for perform CRUD operation
public class UserEndPoints {
	
	//create 
	public static Response createUser(User payload)
	{
	
		Response response = given()
		.contentType(ContentType.JSON) //both are header
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		
		return response;
	}
	
	// get or retrieve data
	public static Response ReadUser(String Username)
	{
		Response response = given()
		.pathParam("username", Username)
		.when()
		.get(Routes.get_url);
		
		
		return response;
	}
	
	
	//update data
	public static Response UpdateUser(String Username, User payload)
	{
		Response response = given()
				.contentType(ContentType.JSON) //both are header
				.accept(ContentType.JSON)
				.pathParam("username", Username)
				.body(payload)
				.when()
				.put(Routes.update_url);
				
				
				return response;
	}
	
	
	// delete data
		public static Response DeleteUser(String Username)
		{
			Response response = given()
			.pathParam("username", Username)
			.when()
			.delete(Routes.delete_url);
			
			
			return response;
		}
	
	
	
}
