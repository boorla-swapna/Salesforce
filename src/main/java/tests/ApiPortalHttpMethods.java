package tests;



import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Contants.FileConstants;
import Utils.AddUserPojo;
import Utils.DataUtils;
import Utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import listeners.TestListenerForAPI;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath.*;


@Listeners(TestListenerForAPI.class)
public class ApiPortalHttpMethods extends BaseTest {
	
	Response response;
	
	@BeforeTest
	public void initialize() {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
				//FileConstants.API_BASE_URI;
	}
	//@Test
	public void loginTest_TC01() throws IOException {
		test=BaseTest.threadExtentTest.get();
		HashMap<String,String> headers=new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		System.out.println("Headers"+headers);
	    
		Response loginResponse=RestUtils.postRequestLogin(headers,DataUtils.getJsonData("$.payloads.login"),DataUtils.getJsonData("$.endpoints.login").toString());
		RestUtils.validateSchema(loginResponse,FileConstants.SCHEMA_VALIDATION_JSON_FILE_PATH);
		loginResponse.prettyPrint();
		System.out.println(loginResponse.getBody().toString());
		System.out.println(loginResponse.statusCode());
		//schema validation
		String body=loginResponse.getBody().toString();
		//String userid=JsonPath.read(body,"$.items.[properties].[userid].type");
		
		
		
	}
	
	@Test
	public void getUserData() throws IOException {
		test=BaseTest.threadExtentTest.get();
		
			HashMap<String,String> headers=new HashMap<String,String>();
			headers.put("Content-Type","application/json");
			headers.put("token", BaseTest.generateToken());
			
			Response getUserData=RestUtils. getUserData(headers,DataUtils.getJsonData("$.endpoints.getdata").toString());
			//System.out.println(getUserData.jsonPath().get("$.payloads[?(@.departmentno==2)]").toString());
			getUserData.prettyPrint();
			
			System.out.println(getUserData.getStatusCode());
			
			JsonPath jsonPath=getUserData.jsonPath();
			Object obj=jsonPath.get("[0]");
			System.out.println(obj);
			
			Utils.AddUserPojo value=jsonPath.getObject("[0]",Utils.AddUserPojo.class);
			System.out.println(value.toString());
			
			
//	        System.out.println(jsonPath.getList("$.payloads"));
//	        Object obj=jsonPath.get("id");
//	        System.out.println(obj);
						
			//To deserialize get the object from response and use object mapper
			
//			Object result=getUserData.jsonPath().get("[0]");
//			
//			ObjectMapper objMapper=new ObjectMapper();
//		    AddUserPojo value=objMapper.readValue(json,AddUserPojo.class);
//		    System.out.println("accountno:" +value.getAccountNo());
//		    System.out.println("departmentno:" +value.getDepartmentNo());
//		    System.out.println("salary:" +value.getSalary());
//		    System.out.println("pincode:" +value.getPinCode());
//		    
//			//JsonPath.parse(jsonData).read("$.");
//		    System.out.println(result);
	}

	

}
