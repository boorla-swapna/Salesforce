package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.WaitConstants;
import listeners.TestListener;
import pages.LoginPage;
import pages.selectUsermenuForUsernameDropdownPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class SFDCLogin extends BaseTest{
	selectUsermenuForUsernameDropdownPage  ump;
	
	@BeforeMethod
	public  void preConditions(Method name){
		System.out.println("Pre conditions to Login Test........ ");
		BaseTest.setDriver("chrome", false);
		logger.info("Setting the Driver  for test:  "+name.getName() +" Success" );
		
	}
	@AfterMethod 
	public  void postConditions(Method name) {
		System.out.println("Post Conditions to Login Test");
        BaseTest.getDriver().close();
        logger.info("Closing the Driver for test " +name.getName() +" Success");
	}
	
	@AfterClass(alwaysRun = true)
    public void cleanup() throws IOException {
	   logger.info("Closing Resources...");
       DataUtils.fileinputstream.close();
    }
	
	
	//@Test
	public  void verifyLoginErrorMessage_TC01() throws Exception {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
		lp.enterUserName(driver,DataUtils.readLoginTestData("valid.username"));
	    Assert.assertTrue(lp.verifyUserNameIsDisplayedInUserNameField(driver),"Username should be displayed in User name field");
	    test.log(Status.PASS, " Username is Displayed in Username Field");
	    lp.enterPassword(DataUtils.readLoginTestData("empty.password"));
	    Assert.assertTrue(lp.verifyEmptyPasswordFieldDisplayed(driver),"Password field should be empty");
	    test.log(Status.PASS, "Password field is Empty ");
	    lp.clickLoginButton(driver);
	    test.log(Status.INFO,"Login Button is Clickable and Clicked");
		Assert.assertTrue(lp.verfiyPasswordErrorMessageDisplayed(driver,"Please enter your password.") ,"Error message should be displayed as Expected");
		CommonUtils.captureScreenShot(driver);
		test.log(Status.PASS,"Password Error Message is Displayed as Expected");
		test.log(Status.PASS,"verifyLoginErrorMessage_TC01");
		
	}
	//@Test
	public void verifyLoginToSalesForce_TC02() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		System.out.println("Pass: TC2_verifyLoginToSalesForce ");
	}
	//@Test
	public void verifyRemeberMeCheckBox_TC03() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        lp.enterUserName(driver,DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO, "Valid Username is Displayed ");
	    lp.enterPassword(DataUtils.readLoginTestData("valid.password"));
	    test.log(Status.INFO, "Valid Password is Displayed ");
	    CommonUtils.captureScreenShot(driver);
	    lp.checkRememberMeCheckBox();
	    test.log(Status.INFO, "RemeberMe checked box selected");
	    lp.clickLoginButton(driver);
	    test.log(Status.INFO,"Clicked on Login Button");
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title" )),"Home page should be displayed");
	    test.log(Status.PASS,"SalesForce Home page is displayed");
	    lp.clickLogOut(driver);
	    Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
	    test.log(Status.PASS,"Application Login Page is Displayed");
	    Assert.assertTrue(lp.verifyUsernameFieldAfterLogout(driver,DataUtils.readLoginTestData("valid.username")),"Login salesforce page is displayed with <username> populated ");
	    test.log(Status.PASS, "<username> is populated as expected");
	    Assert.assertTrue(lp.verifyRememberMeAfterLogout(driver),"Login sales force page is displayed with  Remember Me checked");
	    test.log(Status.PASS,"RememberMe is Checked as expected");
	    System.out.println("Pass: TC3_verifyLoginToSalesForce ");
	}
	//@Test
	public  void verifyForgotPassword_TC4A() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
	    Assert.assertTrue(lp.verifyForgotPasswordLink(driver,"Forgot Your Password | Salesforce"),"Salesforce forgot password page should be displayed");
	    test.log(Status.INFO,"Clicked on ForgotPasswordLink");
	    lp.enterUsernameInForgotYourPasswordPage(DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO,"Username is entered ");
	    lp.clickOnContinueButton(driver);
	    test.log(Status.INFO,"Clicked on Login Button");
	    Assert.assertTrue(lp.verifyPasswordResetMessagePageIsDisplayed(driver,"sent you an email with a link to finish resetting your password."),"Password reset message page is displayed. An email associated with the <username> account is sent.");
	    test.log(Status.PASS,"verifyForgotPassword_TC4A testcase");
	}
	@Test
	public  void ValidateLoginErrorMessage_TC4B() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is Displayed");
	    Assert.assertTrue(lp.verifyWrongUsernameEntered(driver,"123"),"Wrong username should be Entered in username field");
	    test.log(Status.INFO,"Wrong Username Entered");
	    Assert.assertTrue(lp.verifyWrongPasswordEntered(driver,"22131"),"Wrong Password should be Entered in password field");
	    test.log(Status.INFO,"Wrong Password Entered");
	    lp.clickLoginButton(driver);
	    test.log(Status.INFO,"Clicked on Login Button");
	    Assert.assertTrue(lp.verifyPasswordError(driver),"Error message should be displayed Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help");
	    test.log(Status.PASS,"ValidateLoginErrorMessage_TC4B testcase");
	}
}

