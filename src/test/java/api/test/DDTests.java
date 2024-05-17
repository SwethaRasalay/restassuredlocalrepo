package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endPoint.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DDTests {
public Logger logger;
	@Test(priority=1,dataProvider ="Data",dataProviderClass =DataProviders.class)
	public void testPostUser(String userId,String userName,String firstName,String lastName,String Email,String password,String cellnum) {
		logger = LogManager.getLogger(this.getClass());

	User userPayload = new User();	
	userPayload.setId(Integer.parseInt(userId));
	userPayload.setUsername(userName);
	userPayload.setFirstName(firstName);
	userPayload.setLastName(lastName);
	userPayload.setEmail(Email);
	userPayload.setPassword(password);
	userPayload.setPhone(cellnum);
	logger.info("*************method called****");
  Response response = UserEndPoints.createUser(userPayload);
  Assert.assertEquals(response.getStatusCode(), 200);
  logger.info("******8user info********8");
	}
	@Test(priority =2, dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUserbyName(String username) {
logger.info("*8delete method");		
		Response res = UserEndPoints.deleteUser(username);
		System.out.println(res);

		//Assert.assertEquals(res.getStatusCode(), 200);
		
	}
}
