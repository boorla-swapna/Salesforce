package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import Contants.FileConstants;
import Utils.AddUserPojo;
import Utils.DataUtils;
import Utils.RestUtils;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginAPI extends BaseTest{
     
	@BeforeTest
	public void initialize() {
		RestAssured.baseURI=BaseTest.baseUri;
	}
	
	@BeforeMethod
	public void generateTokenForTests() {
		BaseTest.generateToken();
	}
	
	//To validate schema..copy output of Test response and go to free jsonschema validator app and convert json to json schema.
	
	@Test
	public void loginTest_TC01() throws IOException {
		//JSON_DATA_FILE_PATH
	HashMap<String,String> headers=new HashMap<String,String>();
	headers.put("Content-Type","application/json");
	Object payLoad=DataUtils.getJsonData("$.payloads.login").toString();

	Response loginResponse=RestUtils.postRequestLogin(headers, payLoad,DataUtils.getJsonData("$.endpoints.login").toString());
	long responseTime=loginResponse.getTimeIn(TimeUnit.MILLISECONDS);
	System.out.println(responseTime + " :Response Time");
	RestUtils.validateSchema(loginResponse,FileConstants.SCHEMA_VALIDATION_JSON_FILE_PATH);
    loginResponse.prettyPrint();
    //assertEquals(loginResponse.statusCode(), 201);
    // Assert.assertEquals(loginResponse.statusCode(),201); this assert is from testng
   
	}
	
	//@Test
	public void getUsers() throws JsonMappingException, JsonProcessingException {
		HashMap<String,String> headers=new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		headers.put("token", BaseTest.generateToken());
		Response getUserData=RestUtils.getUserData(headers,"/getdata");
		getUserData.prettyPrint();
		String data=getUserData.jsonPath().get("[0]");
	    System.out.println(data.toString());
	    
	    //Deserialization not working..mithun said he will get back with this
        //ObjectMapper objMapper=new ObjectMapper();
       // AddUserPojo library=objMapper.readValue(data,AddUserPojo.class);
	    assertEquals(getUserData.statusCode(),200); //this is coming from hamcrest
	}
	//@Test
	public void addUserTest_TC02() throws JsonProcessingException {
		AddUserPojo pojo=new AddUserPojo("45673","4","5678","345621");
		
		ObjectMapper objMapper=new ObjectMapper();
		objMapper.setVisibility(PropertyAccessor.FIELD,Visibility.ANY);
		String payload=objMapper.writeValueAsString(pojo);
		System.out.println(payload);
		
		HashMap<String,String> headers=new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		headers.put("token", BaseTest.generateToken());
		Response addUserData=RestUtils.addUserData(headers,payload,"/addData");
		
		addUserData.prettyPrint();
		addUserData.getBody();
	    //assertThat(addUserData.statusCode(),equalTo(201));
	}

	
}
