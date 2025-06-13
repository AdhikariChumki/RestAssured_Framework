package api.test;

import javax.mail.Folder;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.SSL_verification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import com.github.javafaker.Faker;
public class UserTests {
	
	
	//Faker faker;
	Faker faker = new Faker();
	 User userpayload = new User();; //create var for user class
	//userpayload = new User();
	
	@BeforeClass
	public void setuppData()
	{
		//====================================
		SSL_verification SLVerify = new SSL_verification();
		SLVerify.SSL();
		//=====================================
		//User userpayload=new User(); // create object for user class
		
		 userpayload.setId(faker.idNumber().hashCode()); //hashcode wil generate random number
	
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	@Test(priority=1)
	public void testPostUser() {
		
		//====================================
				SSL_verification SLVerify = new SSL_verification();
				SLVerify.SSL();
	    //=====================================
		
		Response response = UserEndPoints.createUser(this.userpayload); //here calling createuser method from UserEndPoints to create user and taking all the data from userpayload, see above
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		
		//====================================
				SSL_verification SLVerify = new SSL_verification();
				SLVerify.SSL();
		//=====================================
		
		Response response = UserEndPoints.ReadUser(this.userpayload.getUsername());
		response.then().log().all();
		//response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	
	public void testUpdateUserByName() {
		//====================================
		SSL_verification SLVerify = new SSL_verification();
		SLVerify.SSL();
		//=====================================
				//===================================
				//updating the below data using payload
				userpayload.setFirstName(faker.name().firstName());
				userpayload.setLastName(faker.name().lastName());
				userpayload.setEmail(faker.internet().safeEmailAddress());
				
				
				Response response = UserEndPoints.UpdateUser(this.userpayload.getUsername(),userpayload);//we are taking the name which genearted at the 1st time(getUsername()) 7 updating 1st, last name, email  by calling userpayload
																										//this.userpayload.getUsername()->this will pass existing user name, along with userpayload will update those 3 data
				//response.then().log().body().statusCode(200); //this is call chai assertion, this actually come with rest assured
				response.then().log().body();
				Assert.assertEquals(response.getStatusCode(), 200); //this is call Testng assertion both are same validation
			
				//checking data after update
				Response responseAfterUpdate =  UserEndPoints.ReadUser(this.userpayload.getUsername());// reading the data using same method for get user
				Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUserByname() {
		
		//====================================
		SSL_verification SLVerify = new SSL_verification();
		SLVerify.SSL();
		//=====================================
		Response response = UserEndPoints.DeleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
		
	}


	

