package api.endpoint;

/*
 Swagger URI - https://petstore.swagger.io
 
create User (Post) : https://petstore.swagger.io/v2/user
Get User (Get)   : https://petstore.swagger.io/v2/user/{username}
Update user(Put) : https://petstore.swagger.io/v2/user/{username}
Update user(Delete) : https://petstore.swagger.io/v2/user/{username}
 */


public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";

	//user model
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}"; //{here username pathparameter}
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";

}
