package tests;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import constants.WaitConstants;
import listeners.TestListener;
import pages.CreateAccountPage;
import pages.CreateOppotunityPage;
import pages.LoginPage;
import pages.selectUsermenuForUsernameDropdownPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class CreateOpportunity extends BaseTest {
	
	public static LoginPage lp;
	public static CreateAccountPage cp;
	public static selectUsermenuForUsernameDropdownPage ump;
	public static CreateOppotunityPage cop;
	
	@BeforeMethod
	public void preConditions(Method name) {
		System.out.println("Pre conditions to Login Test........ ");
		BaseTest.setDriver("chrome", false);
		logger.info("Setting the Driver  for test:  "+name.getName() +" Success" );
	}
	
	@AfterMethod
	public void postConditions(Method name) {
		System.out.println("Post Conditions to Login Test");
        BaseTest.getDriver().close();
        logger.info("Closing the Driver for test " +name.getName() +" Success");
	}
	
	@AfterClass(alwaysRun = true)
    public void cleanup() throws IOException {
	   logger.info("Closing Resources...");
       DataUtils.fileinputstream.close();
    }
	
	@Test(priority=1)
	public void verfiyOpportunitiesDropDown_TC15() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
		cop=new CreateOppotunityPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
		logger.info("Home Page is Displayed");
		Assert.assertTrue(cop.verifyOpportunitiesHomePageIsDisplayed(driver,"Opportunities: Home"),"Opportunities home page should be displayed");
		test.log(Status.PASS,"Opportunities home page is displayed");
		Assert.assertTrue(cop.verifyOpportunitiesDropDown(driver));
	    test.log(Status.PASS,"Opportunities DropDown with <All Oppotunities>,<Closing Next Month>,<Closing This Month>,<My Opportunities>,<New This Week>,<Recently Viewed Opportunities>,<Won> should be available");
	}
	
	@Test(priority=2)
	public void verifyCreateNewOpportunity_TC16() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
		cop=new CreateOppotunityPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
		logger.info("Home Page is Displayed");
		Assert.assertTrue(cop.verifyOpportunitiesHomePageIsDisplayed(driver,"Opportunities: Home"),"Opportunities home page should be displayed");
		test.log(Status.PASS,"Opportunities home page is displayed");
		Assert.assertTrue(cop.verifyOpportunitiesPageDisplayed(driver).contains("Opportunity Edit: New Opportunity"),"New Opportunity Edit Page should be Displayed");
	    test.log(Status.PASS,"");
	    cop.enterNewOpportunityDetails(driver);
	    test.log(Status.INFO,"Entered New Opportunity Details");
	    Assert.assertTrue(cop.verifyNewOpportunityPageDisplayedWithDetails(driver, "Opportunity"),"New Opportunity page should be  displayed with Opportunity details.");
	    test.log(Status.PASS,"New Opportunity page is displayed with Opportunity details.");
	    cop.verifyNewOpportunityDetails(driver);    
	}
	
	@Test(priority=3)
	public void verifyTestOpportunityPipelineReport_TC17() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
		cop=new CreateOppotunityPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
		logger.info("Home Page is Displayed");
		Assert.assertTrue(cop.verifyOpportunitiesHomePageIsDisplayed(driver,"Opportunities: Home"),"Opportunities home page should be displayed");
		test.log(Status.PASS,"Opportunities home page is displayed");
		Assert.assertTrue(cop.verifyTestOpportunityPipeLinePage(driver,"Opportunity Pipeline"),"Report Page with the Opportunities that are pipelined should be displayed.");
		test.log(Status.PASS,"Report Page with the Opportunities that are pipelined are displayed.");
        cop.verifyPipeLineDetails(driver);	
	}
	
	@Test(priority=4)
    public void verifyStuckOpportunityReport_TC18() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
		cop=new CreateOppotunityPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
		logger.info("Home Page is Displayed");
	Assert.assertTrue(cop.verifyOpportunitiesHomePageIsDisplayed(driver,"Opportunities: Home"),"Opportunities home page should be displayed");
	test.log(Status.PASS,"Opportunities home page is displayed");
	Assert.assertTrue(cop.verifyStuckOpportunitiesPageIsDisplayed(driver,"Stuck Opportunities"),"Report Page with the Opportunities that are Stuck should be displayed.");
    test.log(Status.PASS,"Report Page with the Opportunities that are Stuck will be displayed.");
    cop.verifyStuckOpportunitiesDetails(driver);
	}
    
	@Test(priority=5)
    public void verifyTestQuarterlySummaryReport_TC19() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
		cop=new CreateOppotunityPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
		logger.info("Home Page is Displayed");
		Assert.assertTrue(cop.verifyOpportunitiesHomePageIsDisplayed(driver,"Opportunities: Home"),"Opportunities home page should be displayed");
		test.log(Status.PASS,"Opportunities home page is displayed");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Current FQ", "All Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Current FQ with All Opportunities should be displayed.");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Current FQ", "Open Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Current FQ with Open Opportunities should be displayed.");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Current FQ", "Closed Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Current FQ with Closed Opportunities should be displayed.");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Next FQ", "All Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Next FQ with All Opportunities should be displayed.");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Next FQ", "Open Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Next FQ with Open Opportunities should be displayed.");
		Assert.assertTrue(cop.verifyQuarterlySummaryLink(driver, "Next FQ", "Closed Opportunities"),"Report Page with the Opportunities that satisfies the search criteria<Next FQ with Closed Opportunities should be displayed.");
    	
    }
}
