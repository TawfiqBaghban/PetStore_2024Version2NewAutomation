package api.endpoints;

/* 
	Swagger URI --> https://petstore.swagger.io

	Create user(Post) : https://petstore.swagger.io/v2/user
	Get user (Get): https://petstore.swagger.io/v2/user/{username}
	Update user (Put) : https://petstore.swagger.io/v2/user/{username}
	Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
*/

/*		in the Routes class we keep all the url for all the models.
 	-	we create a base url, which is common in all other model urls.
 	-	in the post url, since we have a common url (base url) we don't need to specify it again, but we 
 		concatenate it with the end points and we will do it for rest of urls.
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";	// common swagger url for all the models
	
//	Following are the urls for User model.
	public static String post_url = base_url + "/user";
	public static String get_url = base_url+"/user/{username}";		//	passing username as a path parameter.
	public static String put_url = base_url+"/user/{username}";		//	passing username as a path parameter.
	public static String delete_url = base_url+"/user/{username}";	//	passing username as a path parameter.

//	in the future if we need to add urls for other models, we write and store them in this class.
	
//	Pet model urls

// 	store model urls
	
}
