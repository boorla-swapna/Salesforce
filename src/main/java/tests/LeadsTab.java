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
import pages.LeadsPage;
import pages.LoginPage;
import pages.selectUsermenuForUsernameDropdownPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class LeadsTab extends BaseTest {
	
	public static LoginPage lp;
	public static CreateAccountPage cp;
	public static selectUsermenuForUsernameDropdownPage ump;
	public static CreateOppotunityPage cop;
	
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

    @Test
	public void verifyLeadsHomePageDisplayed_TC20() throws IOException {
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
		LeadsPage leadpage=new LeadsPage(driver);
		Assert.assertEquals(leadpage.verifyLeadsHomePage(driver),(DataUtils.readLeadsPageData("expectedLeadsHomePageTitle")),"Leads Home Page Should be Displayed");
	}
    
    @Test
    public void verifyLeadsSelectView_21() throws IOException {
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
		LeadsPage leadpage=new LeadsPage(driver);
		Assert.assertTrue(leadpage.verifyLeadsHomePage(driver).contains(DataUtils.readLeadsPageData("expectedLeadsHomePageTitle")),"Leads Home Page Should be Displayed");
		test.log(Status.PASS,"Leads Home Page is be Displayed");
		Assert.assertTrue(leadpage.verifyLeadsViewDropDown(driver),"Leads Dropdown Should be Displayed as Expected with values All Open Leads / My Unread Leads / Recently Viewed Leads / Today's Leads.");
		test.log(Status.PASS,"Leads Dropdown Should be Displayed with values as Expected");
    }
    
    public void verifyDefaultView_TC22() throws IOException {
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
		LeadsPage leadpage=new LeadsPage(driver);
    	
    }
    
    @Test
    public void verifyTodaysLeadsWork_TC23() throws IOException {
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
		LeadsPage leadpage=new LeadsPage(driver);
		Assert.assertTrue(leadpage.verifyLeadsHomePage(driver).contains(DataUtils.readLeadsPageData("expectedLeadsHomePageTitle")),"Leads Home Page Should be Displayed");
		test.log(Status.PASS,"Leads Home Page is be Displayed");
		Assert.assertTrue(leadpage.verifyTodaysLeadSelected(driver),"Todays leads page should be selected from the drop down");
		test.log(Status.PASS,"Todays leads page is Displayed");
    }
    
    @Test
    public void verifyNewButtonOnLeadsHome_TC24() throws IOException {
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
		LeadsPage leadpage=new LeadsPage(driver);
		Assert.assertTrue(leadpage.verifyLeadsHomePage(driver).contains(DataUtils.readLeadsPageData("expectedLeadsHomePageTitle")),"Leads Home Page Should be Displayed");
		test.log(Status.PASS,"Leads Home Page is be Displayed");
		Assert.assertTrue(leadpage.verifyNewLeadViewPageCreated(driver, DataUtils.readLeadsPageData("expectedCreatedLeadPageTitle")));
		test.log(Status.PASS, "The newly created lead view page should be opened");
    }
}
