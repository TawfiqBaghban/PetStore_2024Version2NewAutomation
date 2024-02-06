package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*		In the User model EndPoints, we will be using the Routes class.
 		Created to perform CRUD operations on the User API.
 	-	in the swagger document, we will get the specification that what type of content type, accept and data/ body 
 		should be part of our request header. in the body() section, we will get the payload and pass it here.
 	-	since we made the Routes.java class as public static, now we will be able to access the post url directly just
 		by mentioning the class name in the when() section.
 		
 */
public class User_EndPoints {

	public static Response createUser(User payload){	//	the return type this method is response type.
	
		Response res = given()			//	storing the entire response in a variable.
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)				//	getting payload from api.payload package
		
		.when()
			.post(Routes.post_url);		//	getting the post url using the Routes class.
		
		return res;						// returning the entire response and the return type is Response.
		
//		This implementation of create user method, will get the payload, send the request and return the response
//		once we get the Response then we will be able to do validations in test (api.test) section just by calling
//		this method and passing pay load.
	}
	
	public static Response readUser(String userNameValue){	//	receiving the path parameter value from a POJO class.
		
		Response res = given()			
			.pathParam("username", userNameValue)	//	assigning path parameter value to a path parameter variable (username)
		
		.when()
			.get(Routes.get_url);					//	getting the get url from the Routes class.
		
		return res;						
	}
	
//	The following updateUser() method takes two parameters to receive the data.
//	one to receive value of path parameter and second receiving pay load from POJO class, because we are updating the user.
//	so we have to know which user should be updated and with what data.
	
	public static Response updateUser(String userName, User payload){	//	the return type this method is response type.
		
		Response res = given()					//	storing the entire response in a variable.
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)	//	getting value of path parameter (userName) and storing in(username) variable.
			.body(payload)					//	getting payload from api.payload package
		
		.when()
			.put(Routes.put_url);				//	getting the put url using the Routes class.
		
		return res;
	}
	
//		in the delete request, we have to specify which user we want to delete
	public static Response deleteUser(String userNameValue){	//	receiving the path parameter value from a POJO class.
		
		Response res = given()			
			.pathParam("username", userNameValue)		//	assigning path parameter value to a path parameter variable (username)
		
		.when()
			.delete(Routes.delete_url);					//	getting the delete url from the Routes class.
		
		return res;						
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
