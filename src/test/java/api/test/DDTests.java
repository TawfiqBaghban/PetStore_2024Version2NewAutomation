package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.User_EndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
/*	Now, we have the data ready in the DataProvider, now we have to receive the data from it.
 -	To receive the data, we have to specify the data provider name, so inside the @Test, we have to write
 	dataProvider="data provider name", then we have to specify where this data provider is located, if it is in the same
 	class it is enough, but if the data provider is in another package or class, then we have to specify the location by
 	dataProviderClass=data provider class name.class, this is a class that we have to specify and also import that class.
 -	Now, this data provider has the data and will pass the data, so now we have to receive the data into our method. So we
  	have to create multiple parameters in our method based on the Excel sheet and these parameters should be in the same order
  	as the Excel sheet. Now by using these parameters, we create our payload. by using POJO class object and it's setters
  	method, we get the data from the parameters and assign them to userPayload using setters () methods.
 
 */
//	dataProvider="data provider name", by using (class) keyword, we specify that, this is a class.
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostuser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();	// creating POJO class object (userPayload).
		
		userPayload.setId(Integer.parseInt(userID));	// receiving the data, using setter method assigning it to userPayload
		userPayload.setUsername(userName);	// receiving the userName and assigning it to userPayload using setUsername() method of POJO
		userPayload.setFirstname(fname);	// receiving data and assigning to userPayload.
		userPayload.setFirstname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=User_EndPoints.createUser(userPayload);	// calling User_EndPoints class and its createUser() method.
		Assert.assertEquals(response.getStatusCode(),200);			
	}
	
/*	The following method will delete the data, using (UserNames) data provider.
 	the data provider (UserNames) has the data (only user names), and will pass it to our method. now in our method, we should
 	receive the data, so we have to pass it as a parameter in our method. then by using User_EndPoints class and it's 
 	deteleUser() method we delete the data.
*/
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)	//
	{
			Response response=User_EndPoints.deleteUser(userName);
			Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	
	
}
