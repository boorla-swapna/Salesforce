package pages;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import testdata.LeadsExpectedDropDownList;
import tests.BaseTest;
import utils.DataUtils;
import utils.WaitUtils;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="(//a[contains(text(),'Leads')])[1]")
	public WebElement leadsTab;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement leadsViewDropDown;
	
	@FindBy(xpath="//input[@name='new']")
	public WebElement newButtonOnRecentLeads;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='lea3']")
	public WebElement companyName;
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	public WebElement saveButton;
	

	
	public boolean verifyMyUnreadLeads(WebDriver driver) throws IOException {
		boolean isMyUnreadLeadsSelected=false;
		if(WaitUtils.waitForElementToBeVisible( driver,leadsViewDropDown )) {
			if(BaseTest.selectOption(leadsViewDropDown,DataUtils.readLeadsPageData("leads.viewunreadleadsoption"))) {
				isMyUnreadLeadsSelected=true;
			}
		}
		return isMyUnreadLeadsSelected;
	}
	public boolean verifyNewLeadViewPageCreated(WebDriver driver,String expectedCreatedLeadPage) throws IOException {
		boolean isNewLeadViewPageCreatedDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, newButtonOnRecentLeads)) {
			newButtonOnRecentLeads.click();
			logger.info("Clicked on New button");
			String actualLeadCreationPage=driver.getTitle();
			String expectedLeadCreationPage=DataUtils.readLeadsPageData("expectedLeadCreationPageTitle");
			Assert.assertEquals(actualLeadCreationPage,expectedLeadCreationPage,"New Lead Edit page should open");
		    logger.info("New Lead Edit page is open") ;
		}
		if(WaitUtils.waitForElementToBeVisible(driver, lastName)) {
			lastName.clear();
			lastName.sendKeys(DataUtils.readLeadsPageData("leads.expectedlastname"));
			logger.info("Last name enetered");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, companyName)) {
			companyName.clear();
			companyName.sendKeys(DataUtils.readLeadsPageData("leads.companyname"));
			logger.info("Company name entered");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, saveButton)) {
			saveButton.click();
			logger.info("New Lead Page is Saved");
			String actualCreatedLeadPage=driver.getTitle();
			if(actualCreatedLeadPage.contains(expectedCreatedLeadPage)) {
				isNewLeadViewPageCreatedDisplayed=true;
			}
		}
		return isNewLeadViewPageCreatedDisplayed;
	}
	
	
	public boolean verifyTodaysLeadSelected(WebDriver driver) throws IOException {
		boolean isTodaysLeadsOptionSelected=false;
			if(BaseTest.selectOption(leadsViewDropDown,DataUtils.readLeadsPageData("leads.viewtodaysleadsoption"))) {
				isTodaysLeadsOptionSelected=true;
			}
			return isTodaysLeadsOptionSelected;
		}
	
	
	
	public boolean verifyLeadsViewDropDown(WebDriver driver) {
		boolean isDropDownListDisplayedAsExpected=false;
		if(WaitUtils.waitForElementToBeVisible(driver, leadsViewDropDown)) {
			leadsViewDropDown.click();
			logger.info("Leads DropDown list:");
			List<WebElement> actualOptions=BaseTest.allOptions(leadsViewDropDown);
			LeadsExpectedDropDownList dropDown=new LeadsExpectedDropDownList();
			
		 for(int i=0;i<actualOptions.size();i++) {
			 if((actualOptions.get(i).getText()).contains(dropDown.expectedList().get(i))) {
				 isDropDownListDisplayedAsExpected=true;
				logger.info(actualOptions.get(i).getText());
			 }
		 }
		
	 }
		return isDropDownListDisplayedAsExpected;
	}
	
	
	
	
	public String verifyLeadsHomePage(WebDriver driver) {
		String leadsHomePageDisplayed="";
		
		if(WaitUtils.waitForElementToBeVisible(driver, leadsTab)) {
			leadsTab.click();
			leadsHomePageDisplayed=driver.getTitle();
			
		}
		return leadsHomePageDisplayed;
	}
	
	
}
