package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.WaitConstants;
import listeners.TestListener;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.selectUsermenuForUsernameDropdownPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class CreateAccount extends BaseTest{
	public static LoginPage lp;
	public static CreateAccountPage cp;
	public static selectUsermenuForUsernameDropdownPage ump;
	
	@BeforeMethod
	public void preConditions(Method name) {
		System.out.println("Pre Conditions to create account........");
		BaseTest.setDriver("chrome", false);
		logger.info("setting the driver for" +name.getName()+ " success");
	}
	
	@AfterMethod
	public void postConditions(Method name) {
		System.out.println("Post Conditions to create account.......");
		BaseTest.getDriver().close();
		logger.info("Closing the driver for" +name.getName()+ " success");
	}
	@AfterClass(alwaysRun = true)
    public void cleanup() throws IOException {
	   logger.info("Closing Resources...");
       DataUtils.fileinputstream.close();
    }
	@Test
	public void verifyCreateAccount_TC10() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
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
	    Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
		Assert.assertTrue(cp.selectNewAccountEditPage(driver,DataUtils.readNewAccountEditDetails("account.EditTitle")),"New Account Edit Page should be Displayed");
		cp.enterDetailsInEditNewAccountPage(driver,DataUtils.readNewAccountEditDetails("account.name"));
		Assert.assertTrue(cp.verifyNewAccountPageIsDisplayedWithDetails(driver,DataUtils.readNewAccountEditDetails("account.name")),"Account Page with New User Displayed");
	    cp.verifyAccountDetails(driver);
	}
	
	
	
	@Test
	public void verifyCreateNewView_TC11() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
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
		Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
		try {
		Assert.assertTrue(cp.verifyCreateNewViewPageIsDisplayed(driver,DataUtils.readNewAccountEditDetails("account.CreateNewViewPageTitle")),"Create New View Page Should be Displayed");
		Assert.assertTrue(cp.verifyAddedViewIsDisplayed(driver),"Created New View Should be Displayed in the Accounts View List");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		cp.deleteCreatedView(driver,DataUtils.readCreateNewViewDetails("view.name"));
		}
	}
	
	@Test
	public void verifyEditView_TC12() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
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
		Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
		try {
		Assert.assertTrue(cp.verifyCreateNewViewPageIsDisplayed(driver,DataUtils.readNewAccountEditDetails("account.CreateNewViewPageTitle")),"Create New View Page Should be Displayed");
		Assert.assertTrue(cp.verifyAddedViewIsDisplayed(driver),"Created New View Should be Displayed in the Accounts View List");
		cp.selectViewFromDropDown(driver);
	    Assert.assertEquals(cp.verifyViewEditPageIsDisplayed(driver),"Accounts: Edit View ~ Salesforce - Developer Edition");
	    logger.debug("Accounts Edit View Page is Displayed");
	    
	    cp.editViewDetails(driver);
	    Assert.assertTrue(cp.verifyViewDetails(driver),"View Page with <new view name>in the drop down is Displayed and Last Activity Column is added");

	    test.log(Status.PASS,"View Page with <new view name>in the drop down is Displayed and Last Activity Column is added");
	    Assert.assertTrue(cp.verifyAccountNamesContainsA(),"the data of the list should have all account names which has <a> in the text.");
	    test.log(Status.PASS,"The data of the List have all accounts names which has <a> in the text ");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
	    cp.deleteCreatedView(driver,DataUtils.readCreateNewViewDetails("new.view.name"));
		}
	}
	
	@Test
	public void verifyMergeAccounts_TC13() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
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
		Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
	    //createNewAccount
		try {
			Assert.assertTrue(cp.selectNewAccountEditPage(driver,DataUtils.readNewAccountEditDetails("account.EditTitle")),"New Account Edit Page should be Displayed");
			cp.enterDetailsInEditNewAccountPage(driver,DataUtils.readNewAccountEditDetails("firstaccountcreated.to.merge"));//"New Account Edit Page should be Displayed");
			
			Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
			Assert.assertTrue(cp.selectNewAccountEditPage(driver,DataUtils.readNewAccountEditDetails("account.EditTitle")),"New Account Edit Page should be Displayed");
			cp.enterDetailsInEditNewAccountPage(driver,DataUtils.readNewAccountEditDetails("secondaccountcreated.to.merge"));//"New Account Edit Page should be Displayed");
			
			Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
			Assert.assertTrue(cp.selectNewAccountEditPage(driver,DataUtils.readNewAccountEditDetails("account.EditTitle")),"New Account Edit Page should be Displayed");
			cp.enterDetailsInEditNewAccountPage(driver,DataUtils.readNewAccountEditDetails("thirdaccountcreated.to.merge"));//"New Account Edit Page should be Displayed");
		    
			Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
			cp.enterAccountsToMerge(driver);
	    cp.verifyMergedAccountPageDisplayed(driver, "sales");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void verifyCreateAccountReport_TC14() throws IOException {
		test=BaseTest.threadExtentTest.get();
		WebDriver driver=BaseTest.getDriver();
		lp=new LoginPage(driver);
		cp=new CreateAccountPage(driver);
		ump=new selectUsermenuForUsernameDropdownPage(driver);
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
		Assert.assertTrue(cp.verifyAccountsTabAvailable(driver,DataUtils.readNewAccountEditDetails("account.HomeTitle")),"Accounts Home Page Should be Displayed");
		Assert.assertEquals(cp.verifyUnsavedReportPageIsDisplayed(driver),"Unsaved Report ~ Salesforce - Developer Edition","Unsaved Report page should be diaplayed");
		test.log(Status.PASS, "Unsaved Report page is diaplayed");
		Assert.assertTrue(cp.verifyListOfAccountsQualified(driver),"List of accounts qualified should be displayed");
	    test.log(Status.PASS,"List of accounts qualified is displayed");
	    cp.verifySaveReport(driver);
	    cp.verifyReportPageWithDisplayedDetailsWithReportNameDisplayed(driver);
	}
	
	
}
