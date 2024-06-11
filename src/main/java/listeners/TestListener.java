package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import stepdefinitions.BaseSteps;

import utils.CommonUtils;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		BaseSteps.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.captureScreenShot(BaseSteps.getDriver()));
		BaseSteps.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED: " +result.getName(),ExtentColor.RED));
	}
	@Override
	public void onTestStart(ITestResult name){
		BaseSteps.test=BaseSteps.extent.createTest(name.getName());
		BaseSteps.threadExtentTest.set(BaseSteps.test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//		    BaseTest.test.log(Status.PASS, "Pass Test case is: " + result.getName());
		BaseSteps.threadExtentTest.get().pass(result.getName());
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

