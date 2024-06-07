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

import constants.FileConstants;
import constants.WaitConstants;
import listeners.TestListener;
import pages.LoginPage;
import pages.selectUsermenuForUsernameDropdownPage;
import utils.CommonUtils;
import utils.DataUtils;


@Listeners(TestListener.class)
public class selectUsermenuForUsernameDropdown extends BaseTest{
	
	@BeforeMethod
	public  void preConditions(Method name){
		System.out.println("Pre conditions to Usermenu DropDown........ ");
		BaseTest.setDriver("chrome", false);
		logger.info("Setting the Driver  for test:  "+name.getName() +" Success" );
		
	}
	@AfterMethod 
	public  void postConditions(Method name) {
		System.out.println("Post Conditions to Usermenu DropDown");
        BaseTest.getDriver().close();
        logger.info("Closing the Driver for test " +name.getName() +" Success");
	}
	
	@AfterClass(alwaysRun = true)
    public void cleanup() throws IOException {
	   logger.info("Closing Resources...");
       DataUtils.fileinputstream.close();
    }
	
	@Test(priority=1)
	public void verifyUserMenuDropDown_TC05() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		selectUsermenuForUsernameDropdownPage ump=new selectUsermenuForUsernameDropdownPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
	    Assert.assertTrue(ump.verifyUserMenuMouseHover(driver),"Usermenu DropDown should be Displayed");
	    Assert.assertTrue(ump.validatingDropdownListOfUserMenuOptions(),"UserMenu DropDown Options <My profile>, <My Settings>, <Developer Console>,<Logout>, <Switching to lightning Experience> should be Displayed");
	    test.log(Status.PASS,"verifyUserMenuDropDown_TC05  test case");
	}
	
	@Test(priority=2)
	public void verifyMyProfileOptionFromUsermenu_TC06() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		selectUsermenuForUsernameDropdownPage ump=new selectUsermenuForUsernameDropdownPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
	    Assert.assertTrue(ump.verifyUserMenuMouseHover(driver),"Usermenu DropDown should be Displayed");
	    Assert.assertTrue(ump.validatingDropdownListOfUserMenuOptions(),"UserMenu DropDown Options <My profile>, <My Settings>, <Developer Console>,<Logout>, <Switching to lightning Experience> should be Displayed");
	    test.log(Status.PASS,"Drop down with <My profile>, <My Settings>, <Developer Console>,<Logout> , <Switching to lightning Experience> is displayed");
	    Assert.assertTrue(ump.selectUserMenuOption(driver,"My Profile"),"User profile page should be  displayed");
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.verifyEditProfilePopUpWindow(DataUtils.readUsermenuDropdownPageData("myprofile.popwindowTitle")),"Edit profile pop up window is displayed ");
		Assert.assertTrue(ump.verifyAboutContactTabs(driver),"About and Contact Tabs should be Displayed");
        Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver,DataUtils.readUsermenuDropdownPageData("myprofile.lastname")),"Lastname should be Displayed");
        Assert.assertTrue(ump.verifyCreatePost(driver,"Hello World"),"Created Post Should be Displayed");
        ump.verifyFileUpload(driver,FileConstants.FILE_UPLOAD_PATH);
        Assert.assertTrue(ump.verifyPhotoUpload(driver,"C:/Users/santh/OneDrive/Desktop/Saved Pictures/lotus-6314190_1280.jpg"),"File should be uploaded and Displayed on the WebPage");
		test.log(Status.PASS, "verifyMyProfileOptionFromUsermenu_TC06 testcase passed");
		
	}
	
	@Test(priority=3)
	public void verifyMySettingsUsermenuOptions_TC07() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		selectUsermenuForUsernameDropdownPage ump=new selectUsermenuForUsernameDropdownPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
	    Assert.assertTrue(ump.verifyUserMenuMouseHover(driver),"Usermenu DropDown should be Displayed");
	    Assert.assertTrue(ump.validatingDropdownListOfUserMenuOptions(),"UserMenu DropDown Options <My profile>, <My Settings>, <Developer Console>,<Logout>, <Switching to lightning Experience> should be Displayed");
	    test.log(Status.PASS,"Drop down with <My profile>, <My Settings>, <Developer Console>,<Logout> , <Switching to lightning Experience> is displayed");
		//ump.selectMySettings(driver,"My Settings");
	    Assert.assertTrue(ump.selectUserMenuOption(driver,"My Settings"),"My Settings page should be  displayed");
		test.log(Status.PASS,"My Settings Option is selected and Page is Displayed");
		Assert.assertTrue(ump.verifyLoginHistory(driver,"Login History"),"Login history data should be  downloaded in .csv format");
		ump.selectDisplaynLayout(driver);
		ump.verifyAvailableNSelectedTabs(driver,"Salesforce Chatter","Reports");
		Assert.assertTrue(ump.verifyReportsAddedToPages(driver,"Salesforce Chatter"),"Reports  should be added in SalesForce Chatter Page");
		Assert.assertTrue(ump.verifyReportsAddedToPages(driver,"Sales"),"Reports  should be added in Sales Page");
		Assert.assertTrue(ump.verifyReportsAddedToPages(driver,"Marketing CRM Classic"),"Reports  should be added in Marketing CRM Classic Page");
		//step4 click on Email link and Email Settings Link
		ump.selectEmailLink(driver);
		ump.verifyMyEmailSettings(driver,"Your settings have been successfully saved.");
		//Step 5 	Click on Calendar & Remainders
		Assert.assertTrue(ump.verifySampleEventPopWindow(driver),"Sample event pop window is dispayed.");
		test.log(Status.PASS,"verifyMySettingsUsermenuOptions_TC07 testcase passed");
	}
	
	@Test(priority=4)
	public void verifyDeveloperConsoleOptionFromUserMenu_TC08() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		selectUsermenuForUsernameDropdownPage ump=new selectUsermenuForUsernameDropdownPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
	    Assert.assertTrue(ump.verifyUserMenuMouseHover(driver),"Usermenu DropDown should be Displayed");
	    Assert.assertTrue(ump.validatingDropdownListOfUserMenuOptions(),"UserMenu DropDown Options <My profile>, <My Settings>, <Developer Console>,<Logout>, <Switching to lightning Experience> should be Displayed");
	    test.log(Status.PASS,"Drop down with <My profile>, <My Settings>, <Developer Console>,<Logout> , <Switching to lightning Experience> is displayed");
	    Assert.assertTrue(ump.verifyDeveloperConsoleDisplayed(driver),"Developer Console Window should be Displayed");	
	    test.log(Status.PASS,"Developer Console Window is Opened");
	    Assert.assertTrue(ump.verifyDeveloperConsoleWindowIsClosed(driver),"Developer Console Window Should be Closed");
	    test.log(Status.PASS,"Developer Console Window is Closed");
	    test.log(Status.PASS,"verifyDeveloperConsoleOptionFromUserMenu_TC08 testcase passed");
	}
	
	@Test(priority=5)
	public void verifyLogoutOptionFromUsermenu_TC09() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		selectUsermenuForUsernameDropdownPage ump=new selectUsermenuForUsernameDropdownPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.verifyApplicationPageIsDisplayed(driver);
		test.log(Status.PASS,"SFDC Appication login page is opened");
		Assert.assertTrue(lp.verifyLoginToSFDC(driver,DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password")),"Valid Username & Password Should be Entered");
	    test.log(Status.INFO,"Entered Valid Username and Password & Login Button is Clickable and Clicked");
	    CommonUtils.captureScreenShot(driver);
	    Assert.assertTrue(lp.verifyHomePageIsDisplayed(driver,DataUtils.readLoginTestData("homepage.title")),"Home page should be displayed");
	    test.log(Status.PASS,"Application Home Page is Displayed");
	    Assert.assertTrue(ump.verifyUserMenuMouseHover(driver),"Usermenu DropDown should be Displayed");
	    Assert.assertTrue(ump.validatingDropdownListOfUserMenuOptions(),"UserMenu DropDown Options <My profile>, <My Settings>, <Developer Console>,<Logout>, <Switching to lightning Experience> should be Displayed");
	    test.log(Status.PASS,"Drop down with <My profile>, <My Settings>, <Developer Console>,<Logout> , <Switching to lightning Experience> is displayed");
	    Assert.assertTrue(ump.verifyLogOut(driver,DataUtils.readUsermenuDropdownPageData("loginTitle")),"Should be logged Out of Current Sales Force Application  and Login Page Should be Displayed");
//	    lp.clickLogOut(driver);
//	    Assert.assertTrue(lp.verifyApplicationPageIsDisplayed(driver),"Application Page Should be Displayed");
	    test.log(Status.PASS,"Application Login Page is Displayed");
	    test.log(Status.PASS, "verifyLogoutOptionFromUsermenu_TC09 testcase passed");
	}
}
