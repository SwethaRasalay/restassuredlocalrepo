//package api.test;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import api.endPoint.UserEndPoints;
//import api.payload.User;
//import io.restassured.response.Response;
//import net.datafaker.Faker;
//
//public class userTests {
//	Faker faker;
//	User userPayload;
//    @BeforeClass
//  	public void setData() {
//		 faker = new Faker();
//		 userPayload = new User();
//		 userPayload.setId(faker.idNumber().hashCode());
//		 userPayload.setUsername(faker.name().username());
//		 userPayload.setFirstName(faker.name().firstName());
//userPayload.setLastName(faker.name().lastName());
//userPayload.setEmail(faker.internet().safeEmailAddress());
//userPayload.setPassword(faker.internet().password(5,10));
//userPayload.setPhone(faker.phoneNumber().cellPhone());
//	}
//    @Test(priority=1)
//    public void testPostUser() {
//    Response response = UserEndPoints.createUser(userPayload);
//    response.then().log().all();
//    Assert.assertEquals(response.getStatusCode(), 200);
//    
//    	
//    }
//    @Test(priority =2)
//    public void getUserByName() {
// Response response =   	UserEndPoints.ReadUser(this.userPayload.getUsername());
//    response.then().log().all();
//    Assert.assertEquals(response.getStatusCode(), 200);
//    }
//
//    @Test(priority=3)
//    public void testUpdateUserByName() {
//    	userPayload.setFirstName(faker.name().firstName());
//    	userPayload.setLastName(faker.name().lastName());
//    	userPayload.setEmail(faker.internet().emailAddress());
//    	Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
//    	response.then().log().body();
//    	Assert.assertEquals(response.getStatusCode(), 200);
//    	
//    	Response responseafterupdate =   	UserEndPoints.ReadUser(this.userPayload.getUsername());
//    	responseafterupdate.then().log().all();
//        Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
//     
//    	
//    }
//    @Test(priority=4)
//    public void deleteUser() {
//    	Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
//    	response.then().log().all();
//    	Assert.assertEquals(response.getStatusCode(), 200);
//    			
//    	
//    	
//    	
//    	
//    	
//    }
//}
