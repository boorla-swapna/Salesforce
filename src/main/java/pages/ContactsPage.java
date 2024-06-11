package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import stepdefinitions.BaseSteps;
import utils.DataUtils;
import utils.WaitUtils;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@title='Contacts Tab']")
	public WebElement contactsTab;
	
	@FindBy(xpath="//input[@name='new']")
	public WebElement newButtonOnRecentContacts;
	
	@FindBy(xpath="//input[@id='name_lastcon2']")
	public WebElement lastName;
	
	@FindBy(xpath="(//img[@class='lookupIcon'])[1]")
	public WebElement accountLookup;
	
	@FindBy(id="searchFrame")
	public WebElement searchFrame;
	
	@FindBy(xpath="//div/input[@id='lksrch']")
	public WebElement searchTextBox;
	
	@FindBy(xpath="//div/input[@name='go']")
	public WebElement goButton;
	
	@FindBy(id="resultsFrame")
	public WebElement resultFrame;
	
	@FindBy(xpath="//div/table/tbody/tr")
	public List<WebElement> listOfAccounts;
	
	@FindBy(xpath="//div/table/tbody/tr[1]/th[1]")
	public WebElement accountNameHeader;
	//div/table/tbody/tr[2]/th/a--accounts
	//div/table/tbody/tr[1]/th[1]--header AccountNames
	@FindBy(xpath="//a[contains(text(),'salesforce_account_swapna')]")
	public WebElement selectAccountName;
	
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	public WebElement createNewViewLink;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement uniqueViewName;
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	public WebElement saveViewButton;
	
	@FindBy(id="00Bak000009NFQz_listSelect")
	public WebElement selectedOptionInDropDown;
	
	//recently Created
	@FindBy(id="hotlist_mode")
	public WebElement CreatedOption;
	
	
	//MyContactsView in contact page
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement contactDropDown;
	
	@FindBy(xpath="//div[@class='pbBody']/table/tbody/tr")
	public List<WebElement> listOfContactNames;
	
	@FindBy(xpath="//div[@class='pbBody']/table/tbody/tr[3]/th/a")
	public WebElement selectContactOption;
	
	@FindBy(xpath="//div[@class='requiredInput']//div[@class='errorMsg']")
	public WebElement errorMessage;
	
	public boolean verifyErrorMessageUnderViewName(WebDriver driver) {
		boolean isErrorMessageDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, saveButton)) {
			saveButton.click();
			if(errorMessage.isDisplayed()) {
				isErrorMessageDisplayed=true;
				logger.info(errorMessage.getText());
			}
		}
		return isErrorMessageDisplayed;
	}
	
	public boolean verifyContactPageRelatedToContactName(WebDriver driver) throws IOException {
		String contactNames="";
		boolean isContactPageRelatedToContactNameDisplayed=false;
		if(WaitUtils.waitForListOfElementToBeVisible(driver, listOfContactNames)) {
			for(int i=1;i<=listOfContactNames.size();i++) {
				if(i==1) {
					String name=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/th")).getText();
					logger.info(name);
				}else {
					contactNames=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/th/a")).getText();
				    logger.info(contactNames);
				}
				if(contactNames.contains(DataUtils.readContactsPageData("contactLastName"))) {
					selectContactOption.click();
					isContactPageRelatedToContactNameDisplayed=true;
					break;
				}
			}
		}
		return isContactPageRelatedToContactNameDisplayed;
	}
	
	public boolean verifyMyContactsViewDisplayedInDropDown(WebDriver driver) throws IOException {
		boolean isMycontactsViewDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, contactDropDown)) {
			if(BaseSteps.selectOption(contactDropDown,DataUtils.readContactsPageData("contact.selectMyContactsDropDownOption"))){
				isMycontactsViewDisplayed=true;
			}
		}
		return isMycontactsViewDisplayed;
	}
	
	public boolean verifyRecentlyCreatedContacts(WebDriver driver) throws IOException {
		boolean isRecentlyCreatedContactsSelected=false;
		if(WaitUtils.waitForElementToBeVisible(driver, CreatedOption)) {
			if(BaseSteps.selectOption(CreatedOption, DataUtils.readContactsPageData("contact.recentlyCreatedOption"))) {
				isRecentlyCreatedContactsSelected=true;
			}
		}//validate more to display details
		return isRecentlyCreatedContactsSelected;
	}
	
	
	//TC26
	public boolean verifyCreatedViewNameDisplayedInDropDown(WebDriver driver,String expectedContactHomePageTitle) {
		boolean isCreatedViewNameDisplayedInDropDown=false;
		if(WaitUtils.waitForElementToBeVisible(driver, saveViewButton)) {
			saveViewButton.click();
			String actualContactHomePageTitle=driver.getTitle();
			if(actualContactHomePageTitle.contains(expectedContactHomePageTitle)) {
				isCreatedViewNameDisplayedInDropDown=true;
			}
			if(WaitUtils.waitForElementToBeVisible(driver, selectedOptionInDropDown)) {
				logger.info("Selected Default view Option Displayed in Contacts DropDown: "+ BaseSteps.getSelectedOption(selectedOptionInDropDown));
			}
		}
        return isCreatedViewNameDisplayedInDropDown;
	}
	
	
	public boolean verifyUniqueViewNameEntered(WebDriver driver,String expectedUniqueViewName) throws IOException {
		boolean isUniqueViewNameDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, uniqueViewName)) {
			if(!uniqueViewName.isDisplayed()) {
				uniqueViewName.clear();
				uniqueViewName.click();
				uniqueViewName.sendKeys(expectedUniqueViewName);
				logger.info(expectedUniqueViewName+" entered unique view name");
			}
		}
		if(uniqueViewName.getAttribute("vlaue").contains(DataUtils.readContactsPageData("contact.uniqueviewName"))) {
			isUniqueViewNameDisplayed=true;
		}
		return isUniqueViewNameDisplayed;
	}
	
	public boolean verifyViewNameEntered(WebDriver driver) throws IOException {
		boolean isViewNameEntered=false;
		if(WaitUtils.waitForElementToBeVisible(driver, viewName)) {
			if(!viewName.isDisplayed()) {
			viewName.clear();
			viewName.sendKeys(DataUtils.readContactsPageData("contact.viewName"));
		}
		}
			if(!viewName.getAttribute("value").contains(DataUtils.readContactsPageData("contact.viewName"))) {
				isViewNameEntered=true;
			}
			return isViewNameEntered;
		}
		
	
	
	
	public boolean verifyCreateNewViewLinkDisplayed(WebDriver driver,String expectedNewViewPageTitle) {
		boolean isCreateNewViewLinkDisplayed=false;
		if(WaitUtils.elementToBeClickable(driver, createNewViewLink)) {
			createNewViewLink.click();
			String actualNewViewPageTitle=driver.getTitle();
			if(actualNewViewPageTitle.contains(expectedNewViewPageTitle)) {
				isCreateNewViewLinkDisplayed=true;
			}
		}
		return isCreateNewViewLinkDisplayed;
	}
	
	
	//TC25
	public boolean verifyContactHomePageDisplayed(WebDriver driver,String expectedContactsPage) {
		boolean isContactsHomePageDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, contactsTab)) {
			contactsTab.click();
			String actualContactsPage=driver.getTitle();
			if(actualContactsPage.contains(expectedContactsPage)) {
				isContactsHomePageDisplayed=true;
			}
		}
		return isContactsHomePageDisplayed;
	}
	
	public boolean verifyNewContactHomePage(WebDriver driver,String expectedNewContactHomePage) {
		boolean isNewContactHomePageDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, newButtonOnRecentContacts)) {
			newButtonOnRecentContacts.click();
			String actualNewContactHomePage=driver.getTitle();
			if(actualNewContactHomePage.contains(expectedNewContactHomePage)) {
				isNewContactHomePageDisplayed=true;
			}
		}
		return isNewContactHomePageDisplayed;
	}
	
	public boolean verifyLastNameEnteredInField(WebDriver driver) throws IOException {
		boolean isLastNameEntered=false;
		if(WaitUtils.waitForElementToBeVisible(driver, lastName)) {
			
			if(lastName.getText().isBlank()) {
				lastName.sendKeys(DataUtils.readContactsPageData("contactLastName"));
				isLastNameEntered=true;
				logger.info("Last name enterd in Last name field");
			}else {
				lastName.clear();
				verifyLastNameEnteredInField(driver);
			}
		}
		return isLastNameEntered;
	}
	
	public boolean verifyAccountNameDisplayedInAccountNameField(WebDriver driver) throws IOException {
		boolean isAccountNameDisplayed=false;
		String parentId=BaseSteps.parentWindowId(driver);
		if(WaitUtils.waitForElementToBeVisible(driver, accountLookup)) {
			accountLookup.click();
			BaseSteps.switchToChildWindow(driver, parentId);
			driver.switchTo().frame(searchFrame);
			if(WaitUtils.waitForElementToBeVisible(driver, searchTextBox)) {
				if(searchTextBox.getText().isEmpty()) {
					searchTextBox.sendKeys(DataUtils.readContactsPageData("contactAccountNameSearchText"));
				}else {
					searchTextBox.clear();
					searchTextBox.sendKeys(DataUtils.readContactsPageData("contactAccountNameSearchText"));
				}
			}
			if(WaitUtils.waitForElementToBeVisible(driver, goButton)) {
				searchTextBox.click();
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame(resultFrame);
			if(WaitUtils.waitForListOfElementToBeVisible(driver, listOfAccounts)) {
				
				for(int i=1;i<=listOfAccounts.size();i++) {
					if(i==1) {
						logger.info(accountNameHeader.getText());
					}
					else {
						WebElement accountNames=driver.findElement(By.xpath("//div/table/tbody/tr[i]/th/a"));
						logger.info(accountNames.getText());
					    if(accountNames.getText().contains(DataUtils.readContactsPageData("contactAccountNameSearchText"))) {
					    	selectAccountName.click();
					    	driver.switchTo().window(parentId);
					    	isAccountNameDisplayed=true;
					    }
				  }
			}
	    }
	}
	return isAccountNameDisplayed;
	}
	
	public boolean verifyNewContactCreated(WebDriver driver,String expectedNewContactPageCreated) {
		boolean isNewContactPageCreatedDispayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, saveButton)) {
			saveButton.click();
			String actualNewContactPageCreated=driver.getTitle();
			if(actualNewContactPageCreated.contains(expectedNewContactPageCreated)) {
				isNewContactPageCreatedDispayed=true;
			}
		}
		return isNewContactPageCreatedDispayed;
	}
}
