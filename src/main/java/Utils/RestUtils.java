package Utils;

import java.io.File;
import java.util.HashMap;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class RestUtils {

	//public static void main(String[] args) {
		/*Response loginRes=RestAssured.given().headers("Content-Type","application/json")
				.when().body("{\"username\": \"swapna.boddula.09@tekarch.com\",\"password\": \"Admin123\"}")
				.post();*/
		
    public static Response postRequestLogin(HashMap<String,String> headers,Object payLoad,String path) {
    	
    	Response loginRes=RestAssured.given().headers(headers)
    			.when().body(payLoad).post(path)
    			.then().statusCode(201).extract().response();
		return loginRes;
    }
	
    public static Response getUserData(HashMap<String,String> header,String path) {
    	
      	Response getUserData=RestAssured.given().headers(header)
         .when().get(path)
        .then().statusCode(200).extract().response();
		return getUserData;
       
        }
    
 public static Response addUserData(HashMap<String,String> header,String payload,String path) {
    	
      	Response addUserData=RestAssured.given().headers(header)
         .when().body(payload).post(path)
        .then().statusCode(201).extract().response();
		return addUserData;
       
        }
 
 public static Response putUserData(HashMap<String,String> header,String payload,String path) {
 	
   	Response putUserData=RestAssured.given().headers(header)
      .when().body(payload).post(path)
     .then().statusCode(200).extract().response();
		return putUserData;
    
     }
 
 public static Response deleteUserData(HashMap<String,String> header,String payload,String path) {
	 	
	   	Response deleteUserData=RestAssured.given().headers(header)
	      .when().body(payload).post(path)
	     .then().statusCode(200).extract().response();
			return deleteUserData;
	    
	     }
 
 public static void validateSchema(Response response,String file) {
	 response.then().assertThat().body(matchesJsonSchema(new File(file)));
 }
   
    	
    }
	
	


