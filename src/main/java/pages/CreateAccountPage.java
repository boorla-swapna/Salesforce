package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.BaseTest;
import utils.DataUtils;
import utils.WaitUtils;

public class CreateAccountPage extends BasePage{

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//ul/li[@id='Account_Tab']")
	public WebElement accountTab;
	
	@FindBy(xpath="//input[@name='new']")
	public WebElement newAccountButton;
	
	@FindBy(xpath="//div[@class='bPageTitle']")
	public WebElement editAccountPage;
	
	@FindBy(xpath="//input[@id='acc2']")
	public WebElement accountName;
	
	@FindBy(xpath="//select[@id='acc6']")
	public WebElement selectType;
	
	@FindBy(xpath="//select[@id='00Nak000001jL9P']")
	public WebElement selectCustomerPriority;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement saveAccount;
	
	//create new view
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	public WebElement createNewViewLink;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement uniqueViewName;
	
	@FindBy(xpath="(//input[@class='btn primary'])[1]")
	public WebElement saveViewButton;
	
	@FindBy(xpath="//a[@title='Accounts Tab - Selected']")
	public WebElement accountsTab;
	
	@FindBy(id="fcf")
	public WebElement accountViewList;
	
//	@FindBy(id="00Bak000009vm2j_listSelect")
//	public WebElement selectCreatedViewDropdown;
	
	
	
	//EditView
	@FindBy(id="fcf")
	public WebElement selectViewDropDown;
	
	@FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
    public WebElement editView;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement editViewName;
	
	@FindBy(id="fcol1")
	public WebElement editViewField;
	
	@FindBy(id="fop1")
	public WebElement editViewOperator;
	
	@FindBy(id="fval1")
	public WebElement editViewValue;
	
	@FindBy(xpath="//td//div//select[@id='colselector_select_0']")
	public WebElement selectAvailableFields;
	
	@FindBy(xpath="(//img[@title='Add'])[1]")
	public WebElement editViewAddButton;
	
	@FindBy(xpath="//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")
	public WebElement editViewSaveButton;
	
	@FindBy(name="fcf")
	public WebElement editedAccountName;
	
	@FindBy(xpath="//div[@title='Last Activity']")
	public WebElement lastActivityColumnOnPage;
	
	@FindBy(xpath="//div/table/tbody/tr/td[4]/div/a/span")
	public List<WebElement> listOfAccountsContainsA;
	
	//MergeAccounts
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	public WebElement mergeAccounts;
	
	@FindBy(xpath="//input[@id='srch']")
	public WebElement textBoxToEnterAccountName;
	
	@FindBy(xpath="//input[@value='Find Accounts']")
	public WebElement findAccountsButton;
	
	@FindBy(xpath="//div/table/tbody/tr[2]/td")
	public WebElement listOfAccounts;
	
	@FindBy(xpath="//input[@id='cid0']")
	public WebElement selectFirstAccountCheckBox;
	
	@FindBy(xpath="//input[@id='cid1']")
	public WebElement selectSecondAccountCheckBox;
	
	@FindBy(xpath="(//div//input[@value=' Next '])[1]")
	public WebElement clickOnNext;
	
	@FindBy(xpath="(//div//input[@value=' Merge '])[1]")
	public WebElement mergeButton;
	
	@FindBy(id="hotlist_mode")
	public WebElement recentlyViewedDropDown;
	
	@FindBy(xpath="//span[@class='menuButtonLabel'][contains(text(),'Sales')]")
	public WebElement menuButtonSales;
	
	//CreateAccountsReports
	//Click on Accounts with last activity > 30 days link in reports area on accounts
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
	public WebElement accountsWithLastActivity;
	
	@FindBy(xpath="//h2[text()='Unsaved Report']")
	public WebElement unsavedReportText;
	
	@FindBy(xpath="//img[@id='ext-gen148']")
	public WebElement dateFieldDropDown;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	public WebElement createdDate;
	
	@FindBy(xpath="//img[@id='ext-gen152']")
	public WebElement clickCalenderFrom;
	
	@FindBy(xpath="(//button[@type='button'][text()='Today'])[1]")
	public WebElement selectTodayButton;
	
	@FindBy(xpath="//img[@id='ext-gen154']")
	public WebElement clickCalenderTo;
	
	@FindBy(xpath="(//button[@type='button'][text()='Today'])[2]")
	public WebElement clickTodayButton;
	
	@FindBy(xpath="//div[@id='ext-gen253']//table/tbody/tr/td[3]/div")
	public List<WebElement> listOfAccountsCreatedToday;
	
	@FindBy(xpath="//button[@id='ext-gen49']")
	public WebElement clickOnSave;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")
	public WebElement reportName;
	
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")
	public WebElement reportUniqueName;
	
	@FindBy(xpath="//button[contains(text(),'Save and Run Report')]")
	public WebElement saveAndRunReport;
	
	@FindBy(xpath="//h1[contains(text(),'newSalesReport')]")
	public WebElement salesReportName;
	
	//delete account
	@FindBy(xpath="//a[contains(text(),'Mass Delete Accounts')]")
	public WebElement deleteAccount;
	
	@FindBy(id="col0")
	public WebElement selectAccountName; //select Account Name
	
	@FindBy(xpath="//select[@id='oper0']")
	public WebElement selectOperator; //select contains
	
	@FindBy(xpath="//input[@id='fval0']")
	public WebElement selectCreatedAccountName; //enter account
	
	@FindBy(xpath="(//input[@value='Search'])[2]")
	public WebElement searchButton; //after thisstep scroll down
	
	@FindBy(xpath="//div[@class='pbBody']/table/tbody/tr")
	public List<WebElement> AccountNamesForDeletion; //select name with created account
	
//	@FindBy(xpath="//div[@class='pbBody']/table/tbody/tr[4]/td[@class='actionColumn']")
//	public WebElement selectCheckBoxAccountToDelete;
	
	@FindBy(xpath="//div[@class='pbBody']/table/tbody")
	public WebElement accountsToBeDeletedTable;
	//String path=/tr[i]/td[@class='actionColumn']
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	public WebElement deleteAccountCreated;
	
	@FindBy(xpath="//div[@id='tsid']")
	public WebElement salesMenuOptions;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	public WebElement clickOnGoButtonForCreatedView;
	
	@FindBy(xpath="//div[@class='filterLinks']/a[2]")
	public WebElement deleteButtonForCreatedView;
	
	public void verifyDeleteAccount(WebDriver driver) throws IOException {
		if(WaitUtils.waitForElementToBeVisible(driver, deleteAccount)) {
			BaseTest.scrollToElement(driver, deleteAccount);
			deleteAccount.click();
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectAccountName)) {
			BaseTest.scrollToElement(driver, selectAccountName);
			BaseTest.selectOption(selectAccountName,"Account Name");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectOperator)) {
			BaseTest.scrollToElement(driver, selectOperator);
			BaseTest.selectOption(selectOperator,"contains");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectCreatedAccountName)) {
			selectCreatedAccountName.sendKeys(DataUtils.readNewAccountEditDetails("account.name"));
		}
		if(WaitUtils.elementToBeClickable(driver, searchButton)) {
			searchButton.click();
		}
		if(WaitUtils.waitForElementToBeVisible(driver, accountsToBeDeletedTable)) {
			BaseTest.scrollToElement(driver, accountsToBeDeletedTable);
			for(int i=1;i<=AccountNamesForDeletion.size();i++) {
				WebElement checkbox=driver.findElement(By.xpath("//div[@class='pbBody']/table/tbody/tr[i]/td[@class='actionColumn']"));
				if(checkbox.getAttribute("title").contains(DataUtils.readNewAccountEditDetails("account.name"))) {
					checkbox.click();
				}
			}
		}
		if(WaitUtils.waitForElementToBeVisible(driver, deleteAccountCreated)) {
			deleteAccountCreated.click();
			logger.info("Deleted the account");
		}
		
	}
	
	public void verifyReportPageDetails(WebDriver driver) {
		if(WaitUtils.waitForElementToBeVisible(driver, salesReportName)) {
			String savedReportNameOnPage=salesReportName.getText();
			logger.info("Report Page is Displayed with saved <Report Name> " +savedReportNameOnPage);
			
		}
	}
	
	
	
	public void verifySaveReport(WebDriver driver) {
		if(WaitUtils.waitForElementToBeVisible(driver, clickOnSave)) {
			clickOnSave.click();
			logger.info("Clicked on Save button on unsaved Report Page");
		}
		reportName.clear();
		reportName.sendKeys("sales_Report_2");
//		if(WaitUtils.waitForElementToBeVisible(driver, reportUniqueName)) {
//		reportUniqueName.click();
//		reportUniqueName.clear();
//		reportUniqueName.sendKeys("sales_U_Report");
//		}
		if(WaitUtils.elementToBeClickable(driver, saveAndRunReport)) {
		saveAndRunReport.click();
		logger.info("Clicked on save and run report button");
		}
	}
	
	@FindBy(xpath="//h1[contains(text(),'sales_Report')]")
	public WebElement salesReportPageTitle;
	
	
	
	public void verifyReportPageWithDisplayedDetailsWithReportNameDisplayed(WebDriver driver) {
				if(salesReportPageTitle.isDisplayed()) {
					System.out.println(salesReportPageTitle + "Reports Page Created");
				}
	 List<WebElement> list=driver.findElements(By.xpath("//div/table[@class='reportTable tabularReportTable']/tbody/tr"));
	 for(WebElement eachList:list) {
		 System.out.println(eachList.getText()+" ");
	 }
	 
	 
	}
	
	
	public boolean verifyListOfAccountsQualified(WebDriver driver) {
		boolean isAccountQualifiedDisplayed=false;
		String accounts="";
		if(WaitUtils.waitForElementToBeVisible(driver, dateFieldDropDown)) {
			dateFieldDropDown.click();
			logger.info("DropDown is clicked in Date Field");
			if(createdDate.isDisplayed()) {
			createdDate.click();
			logger.info("Clicked on created Date");
			}
		}
		if(WaitUtils.waitForElementToBeVisible(driver, clickCalenderFrom)) {
			
			clickCalenderFrom.click();
			selectTodayButton.click();
			clickCalenderTo.click();
			clickTodayButton.click();
			logger.info("Selected Today Date in From field");
			logger.info("List of Accounts Created Today");
			for(WebElement eachAccountCreatedToday:listOfAccountsCreatedToday) {
				isAccountQualifiedDisplayed=true;
				accounts=eachAccountCreatedToday.getText();
			}
	   }
		logger.debug(accounts+" ");
		return isAccountQualifiedDisplayed;
		
	}
	
	public String verifyUnsavedReportPageIsDisplayed(WebDriver driver) {
		String actualUnsavedPageDisplayed="";
		if(WaitUtils.waitForElementToBeVisible(driver, accountsWithLastActivity)) {
			BaseTest.scrollToElement(driver, accountsWithLastActivity);
			accountsWithLastActivity.click();
			logger.info("Clicked on 'accounts with Last Activity > 30'");
		    actualUnsavedPageDisplayed=driver.getTitle();
		    logger.info("Unsaved Report Page is Displayed");
		}
		return actualUnsavedPageDisplayed;
	}
	
	public void verifyMergedAccountPageDisplayed(WebDriver driver,String expectedMergedAccount) {
		String accountName="";
		if(WaitUtils.waitForElementToBeVisible(driver, mergeButton)) {
			mergeButton.click();
			logger.info("Clicked on clickMergeButton");
			Alert mergeAlert=driver.switchTo().alert();
			mergeAlert.accept();
			System.out.println("Confimed the pop up to Merge Accounts");
		}
		if(recentlyViewedDropDown.isDisplayed()) {
			BaseTest.selectOption(recentlyViewedDropDown,"Recently Viewed");
		for(int i=2;i<10;i++) {
			WebElement accounts=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/th"));
			accountName=accounts.getText();
			logger.info(accountName +" ");
			if(accountName.contains(expectedMergedAccount)) {
				logger.info("Merged Account Displayed in the Recently viewed DropDown");
				break;
			}else {
				logger.info("Merged Account is not 	Displayed in the Recently viewed DropDown");
			}
		}
	}
}
	
	
	
	
	public void enterAccountsToMerge(WebDriver driver) {
		
		if(WaitUtils.waitForElementToBeVisible(driver, mergeAccounts)) {
			BaseTest.scrollToElement(driver, mergeAccounts);
			mergeAccounts.click();
			logger.info("Clicked on Merge Accounts Link");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, textBoxToEnterAccountName)) {
			textBoxToEnterAccountName.sendKeys("sales");
			if(findAccountsButton.isDisplayed()) {
				findAccountsButton.click();
			}
			
			for(int i=2;i<=3;i++) { 
				int j=1;
				List<WebElement> list=driver.findElements(By.xpath("//div[@class='pbBody']/table/tbody/tr["+i+"]/td["+j+"]"));
				for(WebElement eachAccountListed:list) {
				String accountsDisplayed=eachAccountListed.getText();
			    logger.info(accountsDisplayed + " ");
			}
			}
			
			for(int k=2;k<=4;k++) {

				List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='pbBody']/table/tbody/tr["+k+"]/th/input"));
				for(WebElement eachcheckbox:checkbox) {
				         eachcheckbox.click();
				  }
			}
		
//			if(!selectFirstAccountCheckBox.isSelected()) {
//				selectFirstAccountCheckBox.clear();
//				selectFirstAccountCheckBox.click();
//			}
//			if(!selectSecondAccountCheckBox.isSelected()) {
//				selectSecondAccountCheckBox.clear();
//				selectSecondAccountCheckBox.click();
//			}
		}
		if(clickOnNext.isDisplayed()) {
			clickOnNext.click();
			logger.info("Merge My Accounts step 2 page is displayed with the selected accounts details to merge");
		}
	}
	
	
	@FindBy(xpath="//a[contains(text(),'salesAccount1')]")
	public WebElement firstAccountCreated;
	
	@FindBy(xpath="//a[contains(text(),'salesAccount2')]")
	public WebElement secondAccountCreated;
	
	@FindBy(xpath="//a[contains(text(),'salesAccount3')]")
	public WebElement thirdAccountCreated;
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	public WebElement deleteAccountCreatedButton;
	
	public void deleteAccount(WebDriver driver) { //not working. but modify later for the methods 
		List<WebElement> accountsListTobeDeleted=new ArrayList<WebElement>();
		
		accountsListTobeDeleted.add(firstAccountCreated);
		accountsListTobeDeleted.add(secondAccountCreated);
		accountsListTobeDeleted.add(thirdAccountCreated);
		
		
		for(WebElement acountname:accountsListTobeDeleted) {
			 
		    if(acountname.isDisplayed()) {
		    	acountname.click();
		    	WaitUtils.elementToBeClickable(driver, deleteAccountCreatedButton);
					deleteAccountCreatedButton.click();
					Alert alert=driver.switchTo().alert();
					alert.accept();
					System.out.println("Created account Deleted");
		}else {
			System.out.println("Account not Displayed");
		}
		
//		if(WaitUtils.elementToBeClickable(driver, deleteAccountCreatedButton)) {
//			deleteAccountCreatedButton.click();
//			Alert alert=driver.switchTo().alert();
//			alert.accept();
//			System.out.println("Created account Deleted");
//		}
	}
	}	
	public boolean verifyViewDetails(WebDriver driver) throws IOException {
		boolean isViewDetailsDisplayed=false;
		if(WaitUtils.waitForElementToBeVisible(driver, editedAccountName)) {
			BaseTest.selectOption(editedAccountName,DataUtils.readCreateNewViewDetails("new.view.name"));
			logger.info("Account view Drop Down Listed the Edited View ");
			isViewDetailsDisplayed=true;
		}
		if(WaitUtils.waitForElementToBeVisible(driver,lastActivityColumnOnPage)) {
		    if(lastActivityColumnOnPage.isDisplayed()) {
		    	isViewDetailsDisplayed=true;
		    	logger.info("Last Activity Column is added to the Page");
		    }else {
		    	logger.error("Last Activity Column is not Displayed to the Page");
		    }
		}
		return isViewDetailsDisplayed;
	}
	
	
	
	
	public boolean verifyAccountNamesContainsA() {
		boolean isAccountNamesContainsA=false;
		for(WebElement eachAccount:listOfAccountsContainsA) {
			logger.info(eachAccount.getText());
			if(eachAccount.getText().contains("a")) {
				isAccountNamesContainsA=true;
				
			}else {
				logger.error("Account Names are Not Displayed");
			}
		}
		logger.info("Account Names Displayed that contains 'a' ");
		return isAccountNamesContainsA;
	}
	
	
	public void editViewDetails(WebDriver driver) {
		if(WaitUtils.waitForElementToBeVisible(driver, editViewName)) {
			editViewName.clear();
			editViewName.sendKeys("Swapna_account");
			logger.info("Entered Swapna_account");
		}if(WaitUtils.waitForElementToBeVisible(driver, editViewField)) {
			BaseTest.selectOption(editViewField, "Account Name");
			logger.info("selected 'Account Name' in the Filter field");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, editViewOperator)) 
		{
			BaseTest.selectOption(editViewOperator, "contains");
			logger.info("Selected 'contains' operator in the Operator field");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, editViewValue)) {
			editViewValue.clear();
			editViewValue.sendKeys("a");
			logger.info("Entered value 'a' in the value field");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectAvailableFields)) {
			BaseTest.scrollToElement(driver, selectAvailableFields);
			BaseTest.selectOption(selectAvailableFields, "Last Activity");
			logger.info("Last Activity is Added to the selected Fields");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, editViewAddButton)) {
			editViewAddButton.click();
			logger.info("Add Button Clicked");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, editViewSaveButton)) {
			editViewSaveButton.click();
			logger.info("Save Button clicked");
		}
	}
	
	
	public void selectViewFromDropDown(WebDriver driver) throws IOException {
		if(WaitUtils.waitForElementToBeVisible(driver,selectViewDropDown)) {
		  BaseTest.selectOption(selectViewDropDown,DataUtils.readCreateNewViewDetails("view.name")); //mangoview
		  logger.info("View is Selected from DropDown");
		}else {
			logger.error("View is not selected from Dropdown");
		}
	}
	
	public String verifyViewEditPageIsDisplayed(WebDriver driver) {
		String actualEditViewTitle="";
		if(WaitUtils.elementToBeClickable(driver,editView)) {
			editView.click();
			actualEditViewTitle=driver.getTitle();
			}
		return actualEditViewTitle;
	}
	
	public boolean verifyAddedViewIsDisplayed(WebDriver driver) throws IOException {
		boolean isCreatedViewDisplyedInAccountsViewList=false;
		if(WaitUtils.waitForElementToBeVisible(driver, accountsTab))
			accountsTab.click();
		if(WaitUtils.waitForElementToBeVisible(driver, accountViewList)) {
			if(BaseTest.getSelectedOption(accountViewList).equals(DataUtils.readCreateNewViewDetails("view.name")))
			{
				isCreatedViewDisplyedInAccountsViewList=true;
				logger.info("Newly Created View is Displayed in the Accounts View List");
			}
		}
		return isCreatedViewDisplyedInAccountsViewList;
	}
	
	
	public boolean verifyCreateNewViewPageIsDisplayed(WebDriver driver,String expectedTitle) throws IOException {
		boolean isCreateNewViewPageDisplayed=false;
		if(WaitUtils.elementToBeClickable(driver,createNewViewLink)) {
			createNewViewLink.click();
			if(driver.getTitle().contains(expectedTitle)) { //Accounts: Create New View
				isCreateNewViewPageDisplayed=true;
				logger.info("Create New View Page is  Displayed");
				
				if(viewName.isDisplayed()) {
					viewName.clear();
					viewName.sendKeys(DataUtils.readCreateNewViewDetails("view.name"));
				}
				if(uniqueViewName.isDisplayed()) {
					uniqueViewName.click();
					uniqueViewName.clear();
					uniqueViewName.sendKeys(DataUtils.readCreateNewViewDetails("unique.view.name"));
					}
				if(saveViewButton.isDisplayed()) {
					saveViewButton.click();
				}
			
			}else {
				logger.error("Create New View Page is not Displayed");
			}
		}
		return isCreateNewViewPageDisplayed;
	}
	
	public void deleteCreatedView(WebDriver driver,String viewname) throws IOException {
		if(WaitUtils.waitForElementToBeVisible(driver, accountTab)) {
			accountTab.click();
		}
		if(WaitUtils.waitForElementToBeVisible(driver, accountViewList)) {
			BaseTest.selectOption(accountViewList,viewname);//
			WaitUtils.elementToBeClickable(driver,clickOnGoButtonForCreatedView);
			clickOnGoButtonForCreatedView.click();
			if(WaitUtils.elementToBeClickable(driver, deleteButtonForCreatedView)) {
				deleteButtonForCreatedView.click();
				//popup
				Alert alert=driver.switchTo().alert();
				alert.accept();
				logger.info("Created View Deleted");
			}
		}
	}
	
	public boolean selectTabMenu(WebDriver driver,String option) {
		boolean isTabAvailable=false;
		String path="//*[text()='"+option+"']";
		
		if(WaitUtils.waitForElementToBeVisible(driver,salesMenuOptions)) {
			salesMenuOptions.click();
			WebElement menuOptions=driver.findElement(By.xpath(path));
			if(WaitUtils.waitForElementToBeVisible(driver, menuOptions)) {
				menuOptions.click();
			}
		}
		return isTabAvailable;
	}
	public boolean verifyAccountsTabAvailable(WebDriver driver,String expectedTitle) {
		boolean isAccountPageDisplayed=false;
		selectTabMenu(driver,"Sales");
		if(WaitUtils.waitForElementToBeVisible(driver, accountTab)) {
			accountTab.click();
			if(driver.getTitle().contains(expectedTitle)) {
				isAccountPageDisplayed=true;
				logger.info("PASS: Accounts Home Page is Displayed");
			}
		}else {
			logger.error("Accounts Page is not Displayed");
		}
		return isAccountPageDisplayed;
	}
	
	public boolean selectNewAccountEditPage(WebDriver driver,String expectedEditPage) {
		boolean isNewAccountEditPageDisplayed=false;
		String newAccountEditPageTitle="";
		if(WaitUtils.elementToBeClickable(driver, newAccountButton)) {
			newAccountButton.click();
			newAccountEditPageTitle=driver.getTitle();
			if(newAccountEditPageTitle.contains(expectedEditPage)) {
				isNewAccountEditPageDisplayed=true;
				logger.info(newAccountEditPageTitle + "Is Diaplyed");
			}else {
				logger.error(newAccountEditPageTitle +"New Account Edit Page is Not Displayed");
			}
		}
		return isNewAccountEditPageDisplayed;
	}
	
	
	
	public void enterDetailsInEditNewAccountPage(WebDriver driver,String accountnametobeCreated) throws IOException {
		
		if(accountName.isDisplayed()) {
			accountName.sendKeys(accountnametobeCreated);
			logger.info("Entered Account Name" +accountnametobeCreated);
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectType)) {
			BaseTest.selectOption(selectType,"Technology Partner");
			logger.info("Selected Technology Partner Option as Type");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, selectCustomerPriority)) {
			BaseTest.selectOption(selectCustomerPriority, "High");
			logger.info("Selected High Option as Customer Priority");
		}
		if(WaitUtils.elementToBeClickable(driver, saveAccount)) {
			saveAccount.click();
			logger.info("Clicked on Save Button");
		}
		//verifyNewAccountPageIsDisplayedWithDetails(driver,accountnametobeCreated);
	}
	
	public boolean verifyNewAccountPageIsDisplayedWithDetails(WebDriver driver,String expectedTitle) {
		boolean isNewAccountPageDisplayed=false;
		String actualAccountPage=driver.getTitle();
		//CreateAccountPage cop=new CreateAccountPage(driver);
		
		if(actualAccountPage.contains(expectedTitle)) { //Account: Bloosom
			isNewAccountPageDisplayed=true;
			logger.info("Account Page with new User Displayed and Account Details are displayed under Account Details");
		}else {
			logger.info("Account Page with new User is not Displayed");
		}
		
		
		return isNewAccountPageDisplayed;
	}
	
	@FindBy(xpath="//div/table[@class='detailList']/tbody/tr")
	public List<WebElement> accountDetailTableList;
	
	public void verifyAccountDetails(WebDriver driver) {
		for(WebElement accountDetail:accountDetailTableList) {
			System.out.println(accountDetail.getText()+"  ");
		}
		//div/table[@class='detailList']/tbody/tr
	}

   public boolean deleteCreatedAccount() {
	   
	return false;
	   
   }
}