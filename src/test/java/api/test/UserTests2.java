package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.User_EndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {		//	api.test package --> UsertTests class.

		Faker faker;			// 	Creating global variable of Faker class
		User userPayload;		//	Creating global variable of User class (POJO class).
		
	@BeforeClass
	public void setData() {
		
		faker = new Faker();		//	creating object of Faker class.
		userPayload = new User();	//	creating object of User class and now this POJO User class object has data
									//	now this userPayload we have to pass in every request.
		
		userPayload.setId(faker.idNumber().hashCode());		//	generating fake data and assigning to object of User class (userPayload).
		userPayload.setUsername(faker.name().username());	//	generating fake data and assigning to (userPayload) --> POJO class.
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());	
	}
	
	@Test(priority=1)
	public void testPostUser(){
		
		Response response = User_EndPoints2.createUser(userPayload); 	//	passing whole data here
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
/*		by calling User_EndPoints class and it's readUser() method we read the data
 		by using (this) keyword we are referring to the current class and since the userPayload contains the whole
  		data and from this, we use getUsername() method to extract the specific field and then store it in a variable.
 */
	@Test(priority=2)
	public void getUserByName() {
		
		Response response = User_EndPoints2.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void updateUserByName() {
		
//		Regenerating data to update. calling these methods will regenerate the fake data. just updating the following
//		data fields (firstname, lastname and email address).
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
//		by calling User_EndPoints class and it's updateUser() method, we want to update the user with new data.
//		since the updateUser(String userName, User payload) method takes two parameters, we have to extract the 
//		userName from the userPayload using getUsername() method and pass it as first parameter to updateUser() method and
//		then add the new data that we have regenerated and assigned to userPayload and pass the userPayload as second
//		parameter to updateUser() method.
		
		Response response = User_EndPoints2.updateUser(this.userPayload.getUsername(),userPayload); // updated data
		
																//	Two ways to get status code
		response.then().log().body().statusCode(200);			//	Chia assertions
		Assert.assertEquals(response.getStatusCode(), 200);		//	TestNG assertions

//		Checking to see if the data was updated.
		Response responseAfterUpdate = User_EndPoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
//	In the delete request, we call the User_EndPoints class and its deleteUser() method and just pass the user name.
	@Test(priority=4)
	public void deleteUserByName() {
		
		Response response = User_EndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
// 	20:00
	
	
	
	
	
	
}
