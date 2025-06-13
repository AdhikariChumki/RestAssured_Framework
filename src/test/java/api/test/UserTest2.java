package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		
		userpayload = new User();

		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	@Test(priority=1)
	public void testPostUser() {
		Response response = UserEndPoints.createUser(userpayload); //here calling createuser method from UserEndPoints to create user and taking all the data from userpayload, see above
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetUsrByName() {
		Response response = UserEndPoints.ReadUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
}
