package api.endPoint;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.endPoint.Routes;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {
	public static Logger logger;
	public static ResourceBundle getURL() {
	ResourceBundle routes = ResourceBundle.getBundle("routes");
	return routes;
	}

  public static Response createUser(User payload){
	  logger = LogManager.getLogger(UserEndPoints.class);
	  logger.info("*******8");
	 String post_url =  getURL().getString("post_url");
	Response response = given()
		.contentType(ContentType.JSON)	
		.accept(ContentType.JSON)
		.body(payload)
	.when()
		.post(post_url);
	  logger.info("******get url*******");

	return response;	
	}
  public static Response ReadUser(String userName) {
	  String get_url = getURL().getString("get_url") ;
	Response response =  given()
			             .pathParam("username", userName)
	  
	                   .when()
	                     .get(get_url);
	                     
	                   return response;

  }
  public static Response updateUser(String userName, User payload) {
	  String update_url = getURL().getString("update_url");
	  Response response = given()
			              .contentType(ContentType.JSON)
			              .accept(ContentType.JSON)
			              .pathParam("username",userName)
			              .body(payload)
			            .when()
			            .put(update_url);
			         return response;
  }
  public static Response deleteUser(String userName) {
String delete_url = getURL().getString("delete_url");
Response response = given()
			             .pathParam("username", userName)
                        .when()
                         .delete(delete_url);
	  return response;
  
  
  } 
}
