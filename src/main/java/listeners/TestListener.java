package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.captureScreenShot(BaseTest.getDriver()));
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED: " +result.getName(),ExtentColor.RED));
	}
	@Override
	public void onTestStart(ITestResult name){
		BaseTest.test=BaseTest.extent.createTest(name.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//		    BaseTest.test.log(Status.PASS, "Pass Test case is: " + result.getName());
		BaseTest.threadExtentTest.get().pass(result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		//BaseTest.threadExtentTest.get().skip(result.getName());
		String testName = result.getName();
        String className = result.getTestClass().getName();
        String reason = result.getThrowable().getMessage(); // If available
        System.out.println("Skipped test: " + className + "." + testName + " (" + reason + ")");
	}
	}

