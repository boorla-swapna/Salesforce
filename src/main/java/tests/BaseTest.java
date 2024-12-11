package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Contants.FileConstants;
import Utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {
	
	public static String baseUri="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	public static ExtentReports extentreport;
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> threadExtentTest=new ThreadLocal<ExtentTest>();
	public static Logger logger=LogManager.getLogger("BaseTest");
	
	@BeforeSuite
	public static void doReportConfiguration() {
		extentreport=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(FileConstants.REPORT_FILE_PATH);
		extentreport.attachReporter(sparkReporter);
	}
	@AfterSuite
	 public static void tearDownConfigReport() {
		 extentreport.flush();
	}
	
	public static String generateToken() {
		
		String token="";
		HashMap<String,String> headers=new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		String payLoad="{\"username\": \"swapna.boddula.09@tekarch.com\",\"password\": \"Admin123\"}";
		Response loginRes=RestUtils.postRequestLogin(headers, payLoad, "/login");
		token=loginRes.jsonPath().get("[0].token");
		return token;
	}
	public static String getTimeStamp() {
		SimpleDateFormat date=new SimpleDateFormat("YYYYMMDDhhmmss");
		return date.format(new Date());
		
	}

}
