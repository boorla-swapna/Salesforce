import java.util.HashMap;

import Utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class ApiPortalTest {

	public static void main(String[] args) {
		RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
		//Login
		HashMap<String,String> headers=new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		String payLoad="{\"username\": \"swapna.boddula.09@tekarch.com\",\"password\": \"Admin123\"}";
		Response loginRes=RestUtils.postReq(headers, payLoad, "/login");
	    System.out.println(loginRes.prettyPrint());
		System.out.println(loginRes.getStatusCode());
		System.out.println(loginRes.body());
		
		String token=loginRes.jsonPath().get("[0].token");
		System.out.println(token);
		
		//Add users
		HashMap<String,String> addUserheaders=new HashMap<String,String>();
		addUserheaders.put("Content-Type","application/json");
		addUserheaders.put("token", token);
		String addUserPayload="{\"accountno\": \"TA-3452225\",\"departmentno\": \"3\",\"salary\": \"3426\",\"pincode\": \"345467\"}";
		Response addUserRes=RestUtils.postReq(addUserheaders, addUserPayload, "/addData");
		System.out.println(addUserRes.prettyPrint());
		System.out.println(addUserRes.statusCode());
	
		Header contentTypeHeader = new Header("Content-Type", "application/json");
		Header authorizationHeader = new Header("token", token);
		
		//Get Users
		Response getUserData=RestUtils.getUserData(contentTypeHeader,authorizationHeader,"/getdata");
		getUserData.prettyPrint();
		getUserData.getBody();
		System.out.println(getUserData.statusCode());
		
		//update Users
//		String updatePayLoad="{\"accountno\": \"TA-2299889\",\"departmentno\": \"33\",\"salary\": \"3426\",\"pincode\": \"345467\",\"userid\": \"o4FDbZMJElX44kOM78mO\",\"id\": \"WOB0dFNTT6TxZWZ8wttl\"}";
//		Response updateUserData=RestAssured.given().headers(addUserheaders).when().body(updatePayLoad).put("/updateData").then().statusCode(200).extract().response();		
//	    System.out.println(updateUserData.getBody());	
//	    System.out.println(updateUserData.statusCode());
//	
	}
	
	

	}


