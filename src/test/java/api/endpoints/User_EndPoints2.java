package api.endpoints;
import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_EndPoints2 {

/*		we have the routes.properties file ready, but we have to load that file in our request scripts.
 		by using ResourceBundle java class and its getBundle("name of properties file") method, we load the file in our
 		script and assign it to a variable (routes) of ResourceBundle type and return the object and we make it as static
 		so we can access it and it represents all the urls. this file store the urls in pair of key and value as string type. 
 */
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load properties file
		return routes;			//	returns all of the urls
	}
	
	public static Response createUser(User payload){
	
		String postURL = getURL().getString("post_url"); //	getting the value (url) from key (post_url)
/*		getURL() represents all the urls and from this, using getString("key name") method, we extract the actual url and 
  		store it in a variable (postURL) and then refer it in our Post request. this is done for all other requests too.
 */
		Response res = given()			
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)				
		
		.when()
			.post(postURL);		// referring to url, we got from properties file
		return res;						
		
	}
	
	public static Response readUser(String userNameValue){	
		
		String getURL = getURL().getString("get_url"); //	getting the value (url) from key (get_url)
		Response res = given()			
			.pathParam("username", userNameValue)
		
		.when()
			.get(getURL);			
		
		return res;						
	}
	
	
	public static Response updateUser(String userName, User payload){	
		
		String putURL = getURL().getString("update_url");
		Response res = given()					
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)	
			.body(payload)					
		
		.when()
			.put(putURL);			
		
		return res;
	}
	
	public static Response deleteUser(String userNameValue){	
		
		String deleteURL = getURL().getString("delete_url");
		Response res = given()			
			.pathParam("username", userNameValue)	
		
		.when()
			.delete(deleteURL);				
		
		return res;						
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
