package stepdefinitions;



import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.TestListener;
import pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class LoginSteps extends BaseSteps {
	WebDriver driver;
	LoginPage lp;
	
	
//	@Before
//	public void browserSetUp() {
//		 BaseSteps.setDriver("chrome",false);
//	}
	
	@Given("user launched login Page")
	public void user_launched_login_page() throws IOException {
		test=BaseSteps.threadExtentTest.get();
		BaseSteps.setDriver("chrome",false);
		driver=BaseSteps.getDriver();
		lp=new LoginPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	    
	 }
	@Then("verify applicationPageOpened")
	public void applicationPageOpened() {
		Assert.assertTrue("Application Page Should be Displayed",lp.verifyApplicationPageIsDisplayed(driver));
		logger.info("PASS: SFDC Application login page is opened");
		test.log(Status.PASS,"Application Login Page Opened");
	}

	@When("user entered valid username")
	public void user_entered_valid_username() throws IOException {
		lp.enterUserName(driver,DataUtils.readLoginTestData("valid.username"));
	}
    
	@Then("verify userenteredUsername")
	public void verifyUserEnteredUsername() throws IOException {
		Assert.assertTrue("Username should be displayed in User name field",lp.verifyUserNameIsDisplayedInUserNameField(driver));
		logger.info("PASS: Username is Displayed in Username Field");
		test.log(Status.PASS, "Username Displayed in USername Field");
	}
	@When("password field is empty")
	public void password_field_is_empty() throws IOException {
		lp.enterPassword(DataUtils.readLoginTestData("empty.password"));
	    
	}
	
	@Then("verifyPasswordFieldisEmpty")
	public void verifyPasswordFieldisEmpty() throws IOException {
		Assert.assertTrue(lp.verifyEmptyPasswordFieldDisplayed(driver));
	    logger.info("PASS: Password field is Empty ");
	    test.log(Status.PASS,"Password Field is Empty");
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		lp.clickLoginButton(driver);
	    //test.log(Status.INFO,"Login Button is Clickable and Clicked");
		
	}

	@Then("password error message Is Displayed")
	public void password_error_message_is_displayed() throws IOException {
	    Assert.assertTrue("Error message should be displayed as Expected",lp.verfiyPasswordErrorMessageDisplayed(driver,"Please enter your password."));
	    test.log(Status.PASS,"Password Error Message Displayed ");
	}

	@When("entered valid username password and clicked on Login")
	public void entered_valid_username_password_and_clicked_on_login() {
	   
	}

	@Then("user should be Navigating to HomePage")
	public void user_should_be_navigating_to_home_page() {
	  
	}

	@When("entered valid username password")
	public void entered_valid_username_password() {
	    
	}

	@When("user selects the remember user check box")
	public void user_selects_the_remember_user_check_box() {
	   
	}

	@Then("SalesForce Home Page is Displayed")
	public void sales_force_home_page_is_displayed() {
	   
	}

	@Then("When user clicks Logout")
	public void when_user_clicks_logout() {
	   
	}

	@Then("login Page launched with username populated and remember user checked")
	public void login_page_launched_with_username_populated_and_remember_user_checked() {
	   
	}

	@When("user clicks on forgot password")
	public void user_clicks_on_forgot_password() {
	    
	}

	@Then("salesforce forgot password page is displayed")
	public void salesforce_forgot_password_page_is_displayed() {
	   
	}

	@When("user enters username in forgotpassword page and clicks on continue Button")
	public void user_enters_username_in_forgotpassword_page_and_clicks_on_continue_button() {
	    
	}

	@Then("password reset message is Displayed")
	public void password_reset_message_is_displayed() {
	  
	}

	@Then("email associated with <username> account is sent")
	public void email_associated_with_username_account_is_sent() {
	  
	}


}
