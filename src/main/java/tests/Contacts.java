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
import pages.ContactsPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class Contacts extends BaseTest{
	
	public static ContactsPage cp;
	public static LoginPage lp;
	
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
	public void verifyCreateNewContact_TC25() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyNewContactHomePage(driver,DataUtils.readContactsPageData("expectedNewContactHomePage")),"New Contact home page sould be displayed");
		test.log(Status.PASS,"New Contact home page is be displayed");
		Assert.assertTrue(cp.verifyLastNameEnteredInField(driver),"Last name should be enterd in Last name field");
		test.log(Status.PASS,"Last name is enterd in Last name field");
		Assert.assertTrue(cp.verifyAccountNameDisplayedInAccountNameField(driver),"Account name should be displayed in account name field");
		test.log(Status.PASS,"Account name should be displayed in account name field");
		Assert.assertTrue(cp.verifyNewContactCreated(driver, DataUtils.readContactsPageData("expectedNewContactPageCreated")),"New contact should be created");
	    test.log(Status.PASS,"New contact page is created");
	}
	
	@Test
	public void verifyCreateNewViewInContactPage_TC26() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyCreateNewViewLinkDisplayed(driver, DataUtils.readContactsPageData("expectedCreateNewViewPageTitle")),"New View Page should be displayed");
		test.log(Status.PASS,"New View Page should be displayed");
		Assert.assertTrue(cp.verifyViewNameEntered(driver),"View Name should be entered in the view name field");
		test.log(Status.PASS,"View Name displayed in the view name field");
		Assert.assertTrue(cp.verifyUniqueViewNameEntered(driver,DataUtils.readContactsPageData("contact.uniqueviewName")),"View Unique Name should be entered in the view Unique Name field.");
		test.log(Status.PASS, "View Unique Name Displayed in the view Unique Name field.");
		Assert.assertTrue(cp.verifyCreatedViewNameDisplayedInDropDown(driver, DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contacts Home page should be opened. Created View name should be displayed in drop down in that page by defalut.");
		test.log(Status.PASS,"Contacts Home page is opened. Created View name is displayed in drop down in that page by defalut.");
	
	}
	
	@Test
	public void verifyRecentlyCreatedContactInContactPage_TC27() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyRecentlyCreatedContacts(driver),"Recently created contacts should be displayed");
		test.log(Status.PASS,"Recently created contacts are displayed");
		cp.verifyRecentlyCreatedContactsDetails(driver);
	}
	@Test
	public void verifyMyContactsViewInContactPage_TC28() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyMyContactsViewDisplayedInDropDown(driver),"My contacts View should be displayed");
		test.log(Status.PASS,"My contacts View is displayed");
		cp.verifyMycontactsCreatedDetails(driver);
	}
	
	@Test
	public void verifyViewAContactInContactPage_TC29() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyContactPageRelatedToContactName(driver),"Contact Page related to <contact name>, which contains entire information about that <contact name> should be displayed ");
		test.log(Status.PASS,"Contact Page related to <contact name>, which contains entire information about that <contact name>  displayed ");
	    cp.verifyClickedContactPageDetails(driver);
	}
	
	@Test
	public void verifyErrorMessageWhileCreatingNewViewInContacts_TC30() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
	    lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
		test.log(Status.PASS,"SFDC Application login page is opened");
        Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password and Clicked on Login Button");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
		test.log(Status.PASS,"SalesForce Home page is displayed");
		cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(driver,DataUtils.readContactsPageData("expectedContactsPageTitle")),"Contact Home page should be displayed");
		test.log(Status.PASS,"Contact Home page should be displayed");
		Assert.assertTrue(cp.verifyCreateNewViewLinkDisplayed(driver, DataUtils.readContactsPageData("expectedCreateNewViewPageTitle")),"New View Page should be displayed");
		test.log(Status.PASS,"Create New View Page should be displayed");
		Assert.assertTrue(cp.verifyUniqueViewNameEntered(driver,"EFGH"),"View Unique Name should be entered in the view Unique Name field.");
		test.log(Status.PASS, "View Unique Name Displayed in the view Unique Name field.");
		Assert.assertTrue(cp.verifyErrorMessageUnderViewName(driver),"Error message should appear as Error: You must enter a value.");
		test.log(Status.PASS,"Error message appears as Error: You must enter a value.");
	}
	

}
