package api.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostuser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone)
	
	{
		
		
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UserName);
		userpayload.setFirstName(FirstName);
		userpayload.setLastName(LastName);
		userpayload.setEmail(Email);
		userpayload.setPassword(Password);
		userpayload.setPhone(Phone);
		
		Response response= UserEndPoints.createuser(userpayload);

		AssertJUnit.assertEquals(response.statusCode(), 200);
		
	}
	
	
	@Test(priority=2, dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeletebyuserName(String UserName)
	
	{
		

		
		Response response= UserEndPoints.deleteuser(UserName);

		AssertJUnit.assertEquals(response.statusCode(), 200);
		
	}


}
