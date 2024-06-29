package api.tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import  static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;
public class UserTests2 {
	
	Faker faker;
	
	User UserPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void beforetest()
	
	{
		faker= new Faker();
		UserPayload= new User();
		
		UserPayload.setId(faker.idNumber().hashCode());
		UserPayload.setUsername(faker.name().username());
		UserPayload.setFirstName(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().emailAddress());
		UserPayload.setPassword(faker.internet().password());
		UserPayload.setPhone(faker.phoneNumber().cellPhone());
		

		logger= LogManager.getLogger(this.getClass());
		
	}

	
	
@Test (priority=1)
public void TestPostUser()
{
	logger.info("*****Creating User*******");
 Response response= UserEndPoints2.createuser(UserPayload);
 response.then().log().all();

  AssertJUnit.assertEquals(response.statusCode(), 200);
  logger.info("*****User is Created*******");

}


@Test (priority=2)
public void TestgetUser()
{
	
	
	logger.info("*****getting User info*******");
	
 Response response= UserEndPoints2.getuser(this.UserPayload.getUsername());
 response.then().log().all();

  AssertJUnit.assertEquals(response.statusCode(), 200);
  
  logger.info("*****User info fetched*******");

}




@Test (priority=3)
public void TestupdateUser()
{
	logger.info("*****Updating User*******");
	logger.debug("Debug message: Starting TestPostUser...");
	
	UserPayload.setFirstName(faker.name().firstName());
	UserPayload.setLastName(faker.name().lastName());
	UserPayload.setEmail(faker.internet().emailAddress());
	
 Response response= UserEndPoints2.updateuser(UserPayload, this.UserPayload.getUsername());
 response.then().log().all();

  AssertJUnit.assertEquals(response.statusCode(), 200);
  
  Response responseafterupdate= UserEndPoints2.getuser(this.UserPayload.getUsername());
  AssertJUnit.assertEquals(responseafterupdate.statusCode(), 200);

  logger.info("*****User is updated*******");
  

}


@Test (priority=4)
public void TestdeleteeUser()
{
	
	logger.info("*****deleting User*******");
 Response response= UserEndPoints2.deleteuser(this.UserPayload.getUsername());
 response.then().log().body();

  AssertJUnit.assertEquals(response.statusCode(), 200);
  
  logger.info("****User is deleted*******");

}

}