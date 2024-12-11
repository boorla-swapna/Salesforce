package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;

public class TestListenerForAPI implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		BaseTest.test=BaseTest.extentreport.createTest(result.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName());
	}
    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println(result.getName());
    }
}
