package pages;



import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import stepdefinitions.BaseSteps;
import utils.WaitUtils;

public class CreateOppotunityPage extends BasePage{
	
	public CreateOppotunityPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='Opportunities Tab']")
	public WebElement oppotunitiesTabLink;
	
	@FindBy(id="fcf")
	public WebElement oppotunitiesDropDown;
	
	//OpportunitiesPipeline
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	public WebElement opportunityPipeLineLink; 
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
	public WebElement stuckOpportunities;
	
	//TestQuarterlySummaryReport
	@FindBy(id="quarter_q")
	public WebElement quarlterlySummaryInterval;
	
	@FindBy(id="open")
	public WebElement includeOption;
	
	@FindBy(xpath="//input[@title='Run Report']")
	public WebElement runReport;
	
	//create new Opportunity page elements
	@FindBy(xpath="//input[@class='btn'][@title='New']")
	public WebElement newOpportunityButton;
	
	@FindBy(xpath="//table[@class='detailList']/tbody/tr[3]/td[2]/div/input[@id='opp3']")
	public WebElement opportunityName;
	
	@FindBy(xpath="(//img[@class='lookupIcon'])[1]")
	public WebElement searchOpportunityButton;
	
	@FindBy(xpath="//frame[@id='searchFrame']")
	public WebElement searchFrame;
	
	@FindBy(xpath="//div//input[@id='lksrch']")
	public WebElement searchLookUpText;
	
	@FindBy(xpath="//div//input[@name='go']")
	public WebElement goButton;
	
	@FindBy(id="resultsFrame")
	public WebElement resultsFrame;
	
	
	@FindBy(xpath="//div/table/tbody/tr")
	public List<WebElement> accountsListed;
	
	@FindBy(xpath="//div/table/tbody/tr[1]/th")
	public WebElement accountName;
	
	@FindBy(xpath="//a[contains(text(),'salesforce_account_swapna')]")
	public WebElement selectAccountName;
	
//	@FindBy(xpath="//table/tbody/tr[2][@class='dataRow even last first']/th/a")
//	public WebElement accountNameListed;
	
	@FindBy(xpath="//input[@id='opp9']")
	public WebElement closeDate;
	
	@FindBy(xpath="//div[@class='buttonBar']/a")
	public WebElement 	pickTodaysDate;
	
	@FindBy(xpath="//select[@id='opp11']")
	public WebElement stageOption;
	
	@FindBy(xpath="//input[@id='opp12']")
	public WebElement probability;
	
	@FindBy(id="opp6")
	public WebElement leadSource;
	
	
	@FindBy(xpath="(//img[@class='lookupIcon'])[2]")
	public WebElement primaryCampaignSearchButton;
	
	@FindBy(xpath="//span[@class='dateFormat']/a")
	public WebElement dateClick;
	
	@FindBy(id="searchFrame")
	public WebElement primaryCampaignLookUpFrame;
	
	@FindBy(xpath="(//div//input[@id='lksrch'])[1]")
	public WebElement searchPrimaryCampaignTextBox;
	
	@FindBy(xpath="//div/table/tbody/tr")
	public List<WebElement> listOfCampaigns;
	
	@FindBy(xpath="//div/table/tbody/tr[1]/th")
	public WebElement campaignName;
	
	@FindBy(xpath="//a[contains(text(),'Webinar')]")
	public WebElement selectCampaignName;
	
	@FindBy(xpath="(//input[@class='btn'][@name='save'])[1]")
	public WebElement saveButton;
	
	
	public boolean verifyQuarterlySummaryLink(WebDriver driver,String interval,String includeOptions) {
		boolean isReportOpportunitiesPageDisplayed=false;
		if(quarlterlySummaryInterval.isDisplayed()) {
			BaseSteps.scrollToElement(driver, quarlterlySummaryInterval);
			BaseSteps.selectOption(quarlterlySummaryInterval,interval);
			logger.info(interval + "interval is selected");
		}
		if(includeOption.isDisplayed()) {
			BaseSteps.scrollToElement(driver, includeOption);
			BaseSteps.selectOption(includeOption, includeOptions);
			logger.info(includeOptions + " Include Option is selected");
		}
		if(WaitUtils.waitForElementToBeVisible(driver, runReport)) {
			runReport.click();
			logger.info(interval+ " Report Page with the"+ includeOptions +" is displayed.");
			isReportOpportunitiesPageDisplayed=true;
			driver.navigate().back();
		}
		return isReportOpportunitiesPageDisplayed;
	}
	
	
	public boolean verifyNewOpportunityPageDisplayedWithDetails(WebDriver driver,String expectedOpportunityPageTitle) {
		boolean isOpportunityPageDisplayedWithDetails=false;
		String actualOpportunityTitle=driver.getTitle();
		if(actualOpportunityTitle.contains(expectedOpportunityPageTitle)) {
		isOpportunityPageDisplayedWithDetails=true;
		}
		return isOpportunityPageDisplayedWithDetails;
	}
	
	public String verifyOpportunitiesPageDisplayed(WebDriver driver) {
		String actualNewOpportunityPage="";
		if(newOpportunityButton.isDisplayed()) {
			newOpportunityButton.click();
			actualNewOpportunityPage=driver.getTitle();
			
		}
		return actualNewOpportunityPage;
	}
	
	public void enterNewOpportunityDetails(WebDriver driver) {
		if(opportunityName.isDisplayed()) {
			opportunityName.clear();
			opportunityName.sendKeys("Sales|Business");
		}
		if(WaitUtils.elementToBeClickable(driver, searchOpportunityButton)) {
			searchOpportunityButton.click();
			String parentWindowId=BaseSteps.parentWindowId(driver);
			BaseSteps.switchToChildWindow(driver, parentWindowId);
			if(WaitUtils.waitForElementToBeVisible(driver, searchFrame)) {
				driver.switchTo().frame(searchFrame);
				if(searchLookUpText.isDisplayed()) {
					searchLookUpText.clear();
					searchLookUpText.sendKeys("sales");
					if(goButton.isDisplayed())
						goButton.click();
					logger.info("List of Accounts displayed in loopup accounts");
					driver.switchTo().defaultContent();
					driver.switchTo().frame(resultsFrame);
					for(int i=1;i<=accountsListed.size();i++) {
						String data="";
						if(i==1) {
							logger.info(accountName.getText());
						}else {
							data=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/th/a")).getText();
							logger.info(data);
						}
						
						//select an option with salesforce
						if(data.contains("salesforce")) {
							selectAccountName.click();
							break;
						}
					}
					driver.switchTo().window(parentWindowId);
			  }
			}
			//driver.switchTo().defaultContent();
			
			if(WaitUtils.waitForElementToBeVisible(driver, closeDate)) {
				closeDate.click();
				pickTodaysDate.click();
				dateClick.click();
			}
			if(WaitUtils.waitForElementToBeVisible(driver, stageOption)) {
					BaseSteps.selectOptionFromAllOptions(stageOption, "Needs Analysis");
					logger.info("Needs Analysis Option is Selected");
					}
				}
			if(WaitUtils.waitForElementToBeVisible(driver, probability)) {
				String size=probability.getAttribute("size");
				logger.info(size + " Probability is");
			}
			if(WaitUtils.waitForElementToBeVisible(driver, leadSource)) {
				String leadSourceOption=BaseSteps.selectOptionFromAllOptions(stageOption,"Web");
				logger.info(leadSourceOption + " lead source Option selected");
			}
			String parentWindow=BaseSteps.parentWindowId(driver);
			if(WaitUtils.waitForElementToBeVisible(driver, primaryCampaignSearchButton)) {
				primaryCampaignSearchButton.click();
				BaseSteps.switchToChildWindow(driver, parentWindow);
				if(WaitUtils.waitForElementToBeVisible(driver, primaryCampaignLookUpFrame)) {
					driver.switchTo().frame(primaryCampaignLookUpFrame);
					searchPrimaryCampaignTextBox.sendKeys("*a*");
					driver.switchTo().defaultContent();
					logger.info("List of Campaigns");
					driver.switchTo().frame(resultsFrame);
					for(int i=1;i<=listOfCampaigns.size();i++) {
						String data="";
						if(i==1) {
							logger.info(campaignName.getText());
						}else {
							data=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/th/a")).getText();
							logger.info(data);
						}
						if(data.contains("Webinar")) {
							selectCampaignName.click();
							break;
						}
					}
					//driver.switchTo().defaultContent();
					driver.switchTo().window(parentWindow);
				}
			}
			if(saveButton.isDisplayed()) {
				saveButton.click();
			}
			}
	
		

	
	public boolean verifyStuckOpportunitiesPageIsDisplayed(WebDriver driver,String expectedStuckOpportunitiesPage ) {
		boolean isStuckOpportunitiesPageDisplayed=false;
		
		if(WaitUtils.waitForElementToBeVisible(driver, stuckOpportunities)) {
			BaseSteps.scrollToElement(driver, stuckOpportunities);
			stuckOpportunities.click();
			logger.info("Clicked on Stuck Opportunities Link");
			if(driver.getTitle().contains(expectedStuckOpportunitiesPage)) {
				isStuckOpportunitiesPageDisplayed=true;
				logger.info("Stuck Opportunities Page is Displayed");
			}else {
				logger.error("Stuck Opportunities Page is not Displayed");
			}
		}
		return isStuckOpportunitiesPageDisplayed;
	}
	
	public boolean verifyOpportunitiesHomePageIsDisplayed(WebDriver driver,String expectedOpportunitiesPage ) {
		boolean isOpportunitiesPageDisplayed=false;
		//String expectedOpportunitiesPage="Opportunities: Home";
		if(WaitUtils.waitForElementToBeVisible(driver, oppotunitiesTabLink)) {
			oppotunitiesTabLink.click();
			logger.info("Clicked on Opportunities Tab");
			if(driver.getTitle().contains(expectedOpportunitiesPage)) {
				isOpportunitiesPageDisplayed=true;
				logger.info("Opportunities Page is Displayed");
			}else {
				logger.error("Opportunities Page is not Displayed");
			}
		}
		return isOpportunitiesPageDisplayed;
	}
	
	
	public boolean verifyOpportunitiesDropDown(WebDriver driver) {
		boolean isOpportunityDropDownDisplayed=false;
		if(oppotunitiesDropDown.isDisplayed()) {
			BaseSteps.listDropDown(oppotunitiesDropDown);
			isOpportunityDropDownDisplayed=true;
			//String firstSelectedOption=BaseSteps.firstSelectedOption(oppotunitiesDropDown);
			
			//To verify Elements in DropDown
			LinkedList<String> expectedList=new LinkedList<String>();
		     expectedList.add("All Opportunities");
		     expectedList.add("Closing Next Month");
		     expectedList.add("Closing This Month");
		     expectedList.add("My Opportunities");
		     expectedList.add("New Last Week");
		     expectedList.add("New This Week");
		     expectedList.add("Opportunity Pipeline");
		     expectedList.add("Private");
		     expectedList.add("Recently Viewed Opportunities");
		     expectedList.add("Won");
			
//			if(firstSelectedOption.contains("All Opportunities") ){
//				logger.info("Pass: default value selected 'All Opportunites' is as expected in the List");
//	     }  
			List<WebElement> eachOpportunity=BaseSteps.allOptions(oppotunitiesDropDown);
		    
			for(int i=0;i<eachOpportunity.size();i++) {
				String actualList=eachOpportunity.get(i).getText();
				String expectedListofList=expectedList.get(i);
				
				
				if(actualList.contains(expectedListofList)) {
					System.out.println("Pass: Actual List is as expectedList : " +actualList);
					isOpportunityDropDownDisplayed=true;
				}else {
					System.out.println("Fail:");
				}
				
			}
			
		}
		return isOpportunityDropDownDisplayed;
		
		
			
		}
	
	////a[contains(text(),'Opportunity Pipeline')]

            public boolean verifyTestOpportunityPipeLinePage(WebDriver driver,String expectedPipeLineTitle) {
            	boolean isOpportunitiesPipeLinePageDisplayed=false;
            	if(WaitUtils.waitForElementToBeVisible(driver, opportunityPipeLineLink)) {
            		BaseSteps.scrollToElement(driver, opportunityPipeLineLink);
            		opportunityPipeLineLink.click();
            		String actualPipeLineTitle=driver.getTitle();
            	    if(actualPipeLineTitle.contains(expectedPipeLineTitle)) {
            	    	isOpportunitiesPipeLinePageDisplayed=true;
            	    	logger.info("Expected Opportunities PipeLine Page is Displayed");
            	    }else {
            	    	logger.info("Expected Opportunities PipeLine Page is not Displayed");
            	    }

            }
				return isOpportunitiesPipeLinePageDisplayed;
            }
}
