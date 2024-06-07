package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.FileConstants;
import tests.BaseTest;
import utils.DataUtils;
import utils.WaitUtils;

public class selectUsermenuForUsernameDropdownPage extends BasePage{
	
	public selectUsermenuForUsernameDropdownPage(WebDriver driver) {
		super(driver);
	}
	
	//userMenu //div[@id='userNav']
	@FindBy(xpath="//div[@id='userNav']")
	public WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//a[contains(text(),'My Settings')]")
	public WebElement mySettingsOption;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	public WebElement myProfileOption;
	
	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	public WebElement developerConsoleOption;
	
	@FindBy(xpath="//a[contains(text(),'Switch to Lightning Experience')]")
	public WebElement lightningExperienceOption;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement logoutOption;
	
	//Myprofile Edit
	@FindBy(xpath="(//img[contains(@title,'Edit Profile')])[1]")
	public WebElement editProfile;
	
	@FindBy(xpath="//h2[contains(@id,'contactInfoTitle')]")
	public WebElement editProfilePopUpWindow;
	
	@FindBy(id="contactInfoContentId")
	public WebElement aboutTabIframe; 
	
	@FindBy(id = "contactTab")
	public WebElement contactTab;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	public WebElement aboutTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastNameField;
	
	@FindBy(xpath="//input[@value='Save All']")
	public WebElement saveAllButton;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement aboutTabLastName;
	
	//Profile Username displayed on webpage
	@FindBy(xpath="//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;
	
	
	//postLink
	@FindBy(xpath="//*[@id='publisherAttachTextPost']/span[1]")
	public WebElement postLink;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement postLinkiframe;
	
	@FindBy(xpath="//html/body[contains(@class,'chatterPublisherRTE')]")
	public WebElement postTextArea;
	
	@FindBy(xpath="//input[@value='Share']")
	public WebElement postShareButton;
	
	@FindBy(xpath="(//span[@class='feeditemtext cxfeeditemtext'])[1]/p")
	public WebElement actualPostCreated;
	
	//file Upload
	@FindBy(xpath="//*[@id='publisherAttachContentPost']/span[1]")
	public WebElement fileLink;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	public WebElement uploadFileLink;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	public WebElement chooseFileLink;
	
	@FindBy(id="publishersharebutton")
	public WebElement fileShareButton;
	
	@FindBy(xpath="//input[@value='Cancel Upload']")
	public WebElement cancelUpload;
	
	@FindBy(xpath="(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;
	
	//PhotoLink
	@FindBy(xpath="//div[@class='photoUploadSection']")
	public WebElement moderatorLink;
	
	@FindBy(xpath="//a[contains(text(),'Update')]")
	public WebElement updatePhoto;
	
	@FindBy(id="uploadPhotoContentId")
	public WebElement uploadPhotoFrame;
	
	@FindBy(xpath="//*[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement photoChooseUploadFile;
	
	@FindBy(xpath="//*[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoUploadButton;
	
	@FindBy(xpath="//div[@class='imgCrop_selArea']")
	public WebElement photoCrop;
	
	@FindBy(xpath="//input[@id='j_id0:j_id7:save']")
	public WebElement clickOnSavePhoto;
	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	public WebElement saveImageButton;
	
	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;
	
	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	
	
	//mySettings
	@FindBy(xpath="//a[@id='PersonalSetup_font']")
	public WebElement MySettingPage;
	
	@FindBy(xpath="//span[@id='PersonalInfo_font']")
	public WebElement mySettingsPersonalLink;
	
	@FindBy(xpath="//div/a[@id='LoginHistory_font']")
	public WebElement personalHistoryLink;
	
	@FindBy(xpath="//a[contains(text(),'Download login history')]")
	public WebElement historyLinkDownloadLoginHistory;
	
	//Display and Layout Link
	@FindBy(xpath="//span[@id='DisplayAndLayout_font']")
	public WebElement displayAndLayoutLink;
	
	@FindBy(xpath="//span[@id='CustomizeTabs_font']")
	public WebElement customizeTabs;
	
	//select class salesforce chatter option from customApp
	@FindBy(id="p4")
	public WebElement selectcustomApp;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement selectAvailableTab;
	
	@FindBy(xpath="//img[@title='Add']")
	public WebElement addButton;
	
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	public WebElement selectedTabs;
	
	//Reports Tab Added to sales and sales force chatter page and sales and marketing pages.[Validation]
	@FindBy(xpath="//span[@id='tsidLabel']")//span[contains(text(),'Sales')]
	public WebElement salesPageOnContentTab;
	////*[contains(text(),'Salesforce Chatter')]
	
	@FindBy(xpath="//div[@id='tsid']")
	public WebElement salesMenuOptions;
	
	@FindBy(xpath="//div[@id='toolbar']//a[contains(text(),'Sales')]")
	public WebElement salesOption;
	
	@FindBy(xpath="//ul[@id='tabBar']/li[@id='MoreTabs_Tab']")//ul[@id="tabBar"]/li[14]
	public WebElement moreTabs;
	
	@FindBy(xpath="//ul/li[@id='report_Tab']")
	public WebElement reportsTab;
	
//	@FindBy(xpath="//div[@id='tsid-menuItems']/a[1]")
//	public WebElement selectSalesTab;
	
//	@FindBy(xpath="//ul[@id='tabBar']")
//	public WebElement salesPageTabBar;
	
	@FindBy(xpath="//a[contains(text(),'Reports')]")
	public WebElement reportsTabInMenu;
	
	
	//Reports Tab added to the sales force chatter page
		
	@FindBy(xpath="//*[@id='tsid-menuItems']/a[6]")
	public WebElement selectSalesForceChatter;
	
	@FindBy(xpath="//ul[@id='tabBar']/li[7]")
	public WebElement reportsTabOnPage;
	
	//ReportsTab added to marketing page
	@FindBy(xpath="//span[@id='tsidLabel']")
	public WebElement selectMenu;
	
	@FindBy(xpath="//a[contains(text(),'Marketing CRM Classic')]")
	public WebElement marketingCRMOption;
	
	
	//select Email Link and Settings
	@FindBy(xpath="//*[@id='EmailSetup']/a")
	public WebElement emailLink;
	
	@FindBy(xpath="//a[@id='EmailSettings_font']")
	public WebElement myEmailSettings;
	
	@FindBy(xpath="//input[@id='sender_name']")
	public WebElement emailName;
	
	@FindBy(xpath="//input[@id='sender_email']")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='auto_bcc1']")
	public WebElement yesRadioButton;
	
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[1]")
	public WebElement emailPageSaveButton;
	
//	@FindBy(xpath="//a[@id='PersonalSetup_font']")
//	public WebElement mySettingsConformationMessage;
	
	@FindBy(xpath="//div[@id='meSaveCompleteMessage']")
	public WebElement successMessage;
	
	@FindBy(id="CalendarAndReminders")
	public WebElement calenderNReminders;
	
	@FindBy(xpath="//span[@id='Reminders_font']")
	public WebElement activityReminders;
	
	@FindBy(xpath="//input[@id='testbtn']")
	public WebElement openTestReminder;
	
	@FindBy(xpath="//div[@id='summary']//div[contains(text(),'Sample Event.')]")
	public WebElement eventText;
	
	@FindBy(xpath=" //input[@id='ids0']")
	public WebElement checkBoxEvent1;
	
	@FindBy(xpath="//input[@id='ids1']")
	public WebElement checkBoxEvent2;
	
	@FindBy(xpath="//input[@name='dismiss_all']")
	public WebElement dismissEvent;
	
	//DeveloperConsole
	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	public WebElement developerConsoleOptionOnUsermenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutOptionFromUserMenu;
	
	String mainWindowId=BaseTest.parentWindowId(BaseTest.getDriver());
	
	public boolean verifyLogOut(WebDriver driver,String loginTitle) {
		boolean isLogoutSuccessfull=false;
		if(userMenu.isDisplayed() && userMenu.isEnabled()) {
			userMenu.click();
			System.out.println("clicked on usermenu");
		if(WaitUtils.elementToBeClickable(driver, logoutOptionFromUserMenu)) {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			logoutOptionFromUserMenu.click();
		}
		if(driver.getTitle().contains(loginTitle)) {
			isLogoutSuccessfull=true;
			logger.info("PASS: Logged Out of Usermenu");
		}else {
			logger.error("Logout is not Successfull");
		}
		}
		return isLogoutSuccessfull;
	}
	
    public boolean verifyDeveloperConsoleDisplayed(WebDriver driver) {
    	boolean isDeveloperConsoleWindowOpened=false;
    	String developerConsoleTitle="";
    	//String mainWindowId=BaseTest.parentWindowId(driver);
    	if(WaitUtils.waitForElementToBeVisible(driver, developerConsoleOptionOnUsermenu)) {
    		developerConsoleOptionOnUsermenu.click();
    		BaseTest.switchToChildWindow(driver, mainWindowId);
    		developerConsoleTitle=driver.getTitle();  
    		isDeveloperConsoleWindowOpened=true;
    		logger.info("PASS:" + developerConsoleTitle+" DeveloperConsole Window is Opened");
    		
    	}else {
    		logger.error("Developer Console Window is not Opened");
    	}
    	return isDeveloperConsoleWindowOpened;
    }
	
    public boolean verifyDeveloperConsoleWindowIsClosed(WebDriver driver) {
    	boolean devConsoleClosed=false;
    	 
    	String developerConsoleTitle=driver.getTitle();
    	driver.close();
    	devConsoleClosed=true;
		logger.info("PASS:" + developerConsoleTitle + " Developer Console Window is Closed");
    	driver.switchTo().window(mainWindowId);
    	
    	return devConsoleClosed;
    }
	
	
	
	
	
	public boolean verifySampleEventPopWindow(WebDriver driver) {
		boolean isEventTextMessage=false;
		String eventTextMessage="";
		//String mainWindowId=BaseTest.parentWindowId(driver);
		if(WaitUtils.waitForElementToBeVisible(driver, calenderNReminders)) {
			calenderNReminders.click();
		}
			if(WaitUtils.waitForElementToBeVisible(driver,activityReminders)) {
				activityReminders.click();
		      if(WaitUtils.waitForElementToBeVisible(driver, openTestReminder)) {
		    	  openTestReminder.click();
		    	  BaseTest.switchToChildWindow(driver,mainWindowId);
		    	  if(WaitUtils.waitForElementToBeVisible(driver, eventText)) {
		    		  eventTextMessage=eventText.getText();
		    		  if(!checkBoxEvent1.isSelected())
		    		  checkBoxEvent1.click();
		    		  if(!checkBoxEvent2.isSelected())
		    		  checkBoxEvent2.click();
		    		  if(WaitUtils.elementToBeClickable(driver, dismissEvent)) {
		    			dismissEvent.click();
		    			driver.switchTo().window(mainWindowId);
		    		  }
		    	  }  
		    		  
		    		  isEventTextMessage=true;
		    		  logger.info(eventTextMessage+ " Event Message Displayed");
		    	  }else {
		    		  logger.error("Event Message not Displayed");
		    	  }
		    	  
		      }
		    //input[@name="dismiss_all"]
			return isEventTextMessage;
			}
			
			
			
		
		

	
	
	public void selectEmailLink(WebDriver driver) {
		if(userMenu.isDisplayed()) {
			userMenu.click();
			if(mySettingsOption.isDisplayed()) {
				mySettingsOption.click();
				if(WaitUtils.waitForElementToBeVisible(driver, emailLink)) {
					emailLink.click();
				}else {
					logger.error("Email Link fro My settings Option is not Displayed");
				}
			}
		}
	}
	
	public void verifyMyEmailSettings(WebDriver driver,String expectedConformMessage) throws IOException {
		if(WaitUtils.waitForElementToBeVisible(driver, myEmailSettings)) {
			myEmailSettings.click();
			if(emailName.isDisplayed()) {
				emailName.clear();
				emailName.sendKeys(DataUtils.readLoginTestData("valid.emailname"));
			}
			if(emailAddress.isDisplayed()) {
				emailAddress.clear();
				emailAddress.sendKeys(DataUtils.readLoginTestData("valid.emailaddress"));
			}
			if(!yesRadioButton.isSelected()) {
				yesRadioButton.click();
			}
			if(WaitUtils.elementToBeClickable(driver, emailPageSaveButton)) {
				emailPageSaveButton.click();
			}
			//Validate Given details are saved as default mail options and My settings page is displayed.verify the message <Your settings have been successfully saved>
			if(WaitUtils.waitForElementToBeVisible(driver, successMessage)) {
				String actualConformMessage=successMessage.getText();
			    Assert.assertTrue(actualConformMessage.contains(expectedConformMessage)," message <Your settings have been successfully saved> should be Displayed");
			    logger.info("Message: Given details are saved as default mail options and My settings page is displayed.verify the message <Your settings have been successfully saved>.");
			}else {
				logger.error("Message not Displayed as expected");
			}
		}
	}
	
	
	public boolean verifyReportsAddedToMarketingPage(WebDriver driver) {
		boolean isReportsTabAvailable=false;
		if(WaitUtils.waitForElementToBeVisible(driver,selectMenu)) {
			selectMenu.click();
			if(marketingCRMOption.isDisplayed()) {
				marketingCRMOption.click();
				if(WaitUtils.waitForElementToBeVisible(driver,reportsTabOnPage)) {
					if(reportsTabOnPage.isDisplayed()) {
						isReportsTabAvailable=true;
						logger.info("Reports Tab Available in the Menu Bar of Marketing Page");
					}else {
						logger.error("Reports Tab not Available in the Menu Bar of Marketing Page");
					}
				}
			}
			
		}
		return isReportsTabAvailable;
	}
	
	
	public boolean verifyReportsAddedToSalesForceChatterPage(WebDriver driver) {
		boolean isReportsTabAvailable=false;
		if(WaitUtils.waitForElementToBeVisible(driver,selectMenu)) {
			selectMenu.click();
			if(selectSalesForceChatter.isDisplayed()) {
				selectSalesForceChatter.click();
				if(WaitUtils.waitForElementToBeVisible(driver,reportsTabOnPage)) {
					if(reportsTabOnPage.isDisplayed()) {
						isReportsTabAvailable=true;
						logger.info("Reports Tab Available in the Menu Bar of SalesForceChatter Page");
					}else {
						logger.error("Reports Tab not Available in the Menu Bar of SalesForceChatter Page");
					}
				}
			}
			
		}
		return isReportsTabAvailable;
	}
	//reportsTab //a[contains(text(),'Reports')]

	//(//div[@class="menuButtonButton"])[2]
	public boolean verifyReportsAddedToPages(WebDriver driver,String option) {
		boolean isReportsTabAvailable=false;
		String path="//*[text()='"+option+"']";
		
		if(WaitUtils.waitForElementToBeVisible(driver,salesMenuOptions)) {
			salesMenuOptions.click();
			WebElement menuOptions=driver.findElement(By.xpath(path));
			if(WaitUtils.waitForElementToBeVisible(driver, menuOptions)) {
				menuOptions.click();
			}
			if(reportsTab.isDisplayed()) {
				isReportsTabAvailable=true;
				logger.info("Reports field is added in "+option );
		}
			else  {
			WaitUtils.waitForElementToBeVisible(driver, moreTabs);
				moreTabs.click();
				WaitUtils.waitForElementToBeVisible(driver, reportsTab);
					isReportsTabAvailable=true;
					logger.info("Reports field is added in "+option );
				}
			}
		

		return isReportsTabAvailable;
}
	
	public void selectDisplaynLayout(WebDriver driver) {
		if(WaitUtils.waitForElementToBeVisible(driver, displayAndLayoutLink)) {
			displayAndLayoutLink.click();
			if(customizeTabs.isDisplayed()) {
				customizeTabs.click();
				logger.info("Clicked on customize Tabs");
			}else {
				logger.error("Customize Tabs option is not Displayed");
			}
		}
	}
	
	public void verifyAvailableNSelectedTabs(WebDriver driver,String selectCustomOption,String selectAvailableOption) {
		if(WaitUtils.waitForElementToBeVisible(driver, selectcustomApp)) {
			Select option=new Select(selectcustomApp);
			option.selectByVisibleText(selectCustomOption);
//			BaseTest.selectOption(selectcustomApp, selectCustomOption);//"Salesforce Chatter"
			logger.info(selectCustomOption + " is selected from CustomApp Field ");
		}
		else {
			logger.error(selectCustomOption + " is selected from CustomApp Field ");
		}
		if(WaitUtils.waitForElementToBeVisible(driver,selectAvailableTab)) {
			Select availableOption=new Select(selectAvailableTab);
			List<WebElement> allOptions=availableOption.getOptions();
			for(WebElement option:allOptions) {
				String text=option.getText(); 
				if(text.equals(selectAvailableOption)) {
					availableOption.selectByVisibleText(text);
					break;
				}
			}
			
	    if(WaitUtils.elementToBeClickable(driver, addButton)) {
			addButton.click();
			//validation for Selected Tabs contains reports.
			if(WaitUtils.waitForElementToBeVisible(driver, selectedTabs)) {
				Select selectedOption=new Select(selectedTabs);
				List<WebElement> selectedReportOption=selectedOption.getOptions();
				for(WebElement eachOption:selectedReportOption) 
				{
				String actualSelectedOption=eachOption.getText();
				//Assert.assertTrue(actualSelectedOption,"Reports Option should be added to the Selected Tabs List");
			    if(actualSelectedOption.equals(selectAvailableOption)) {
			    	logger.info("PASS: Reports option is Avaliable in the Selected Tabs List");
			    	saveButton.click();
			    	break;
			    }
			    else {
					logger.error("Reports option not Avaliable in the Selected Tabs List");
				}
			}
			}
				
				
				}
			}
	}
	
		
	
	
	////div/a[@id='LoginHistory_font']
	public boolean verifyLoginHistory(WebDriver driver,String option) {
		boolean isLoginHistoryDownloaded=false;
		String path="//span[contains(text(),'"+option+"')]";
		if(WaitUtils.waitForElementToBeVisible(driver, mySettingsPersonalLink)) {
			mySettingsPersonalLink.click();
			System.out.println("clicked on personal");
			WebElement personalMySettingsOption=driver.findElement(By.xpath(path));
			if(WaitUtils.waitForElementToBeVisible(driver, personalMySettingsOption)) {
				personalMySettingsOption.click();
				logger.info("PASS: "+option+" LoginHistory is Displayed");
				if(WaitUtils.elementToBeClickable(driver, historyLinkDownloadLoginHistory)) {
					isLoginHistoryDownloaded=true;
					historyLinkDownloadLoginHistory.click();
					logger.info("PASS:Login history data is downloaded in .csv format");
				}
			}
		}
		return isLoginHistoryDownloaded;
	}
	
	public boolean selectMySettings(WebDriver driver,String expectedSettingsPage) {
		boolean isMySettingsPageDisplayed=false;
		
		if(mySettingsOption.isDisplayed()) {
			mySettingsOption.click();
			logger.info("My Settings from usermenu option selected");
			if(WaitUtils.waitForElementToBeVisible(driver, MySettingPage)) {
				isMySettingsPageDisplayed=true;
			    String actualSettingsPage=MySettingPage.getText();
				Assert.assertTrue(actualSettingsPage.contains(expectedSettingsPage),"My Settings Page should be Displayed");
			}
		}else {
			logger.error("My Settings from usermenu Option not Displayed");
		}
		return isMySettingsPageDisplayed;
	}
	
	
	public boolean verifyPhotoUpload(WebDriver driver,String imagefilepath) {
		boolean isPhotoUploadSuccess=false;
		if(moderatorLink.isDisplayed()) {
			BaseTest.mouseHover(driver, moderatorLink);
			if(updatePhoto.isDisplayed()) {
				updatePhoto.click();
				driver.switchTo().frame(uploadPhotoFrame);
				if(WaitUtils.waitForElementToBeVisible(driver, photoChooseUploadFile)) {
				photoChooseUploadFile.sendKeys(imagefilepath);
				saveImageButton.click();
			    BaseTest.cropPhotoClickNHold(driver,photoCrop);
			    clickOnSavePhoto.click();
			    driver.switchTo().defaultContent();
			}
		}
			
	}
//		if(WaitUtils.waitForElementToDisappear(driver, spinnerIcon) 
//				&& WaitUtils.waitForElementToBeVisible(driver, photoSaveButton2)) {
//			photoSaveButton2.click();
//			if(WaitUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
//				isPhotoUploadSuccess = true;
//			}
//		}
		
		return isPhotoUploadSuccess;
	}
	
	
	
	public boolean verifyFileUpload(WebDriver driver,String filepath) {
		boolean isFileUploadSuccess=false;
		if(WaitUtils.elementToBeClickable(driver, fileLink)) {
			fileLink.click();
			if(WaitUtils.elementToBeClickable(driver, uploadFileLink)) {
				uploadFileLink.click();
			}
			 if(WaitUtils.elementToBeClickable(driver, chooseFileLink)) {
				 chooseFileLink.sendKeys(filepath);
				 fileShareButton.click();
				 if(WaitUtils.waitForElementToDisappear(driver, cancelUpload)) {
						if(verifyFilePostElement.isDisplayed()) {
							isFileUploadSuccess = true;
						}
					}
			 }
			 isFileUploadSuccess=true;
		}
		return isFileUploadSuccess;
	}
	
	
	public boolean verifyCreatePost(WebDriver driver,String text) {
		boolean isPostCreated=false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(postLinkiframe);
		if(postTextArea.isDisplayed()) 
			postTextArea.clear();
			postTextArea.sendKeys(text);
			driver.switchTo().parentFrame();
			postShareButton.click();
		}if(actualPostCreated.isDisplayed()) {
			String actualPost=actualPostCreated.getText();
			if(actualPost.contains(text)) {
				isPostCreated=true;
				logger.info("PASS: Created Post Displayed on the Page");
			}else {
				logger.error("Created Post is not Displayed on the page");
			}
		}
		return isPostCreated;
	}
	
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
		}
		if (userProfilePageNameDisplay.isDisplayed()) {
			String actualName = userProfilePageNameDisplay.getText();
			if (actualName.contains(lastName)) {
				isLastNameChanged = true;
				logger.info("PASS: Lastname in userProfile page is Displayed");
			} else {
				logger.error("Lastname in user profile page not Displayed");
			}
		}
		return isLastNameChanged;
	}
	
	public  boolean verifyAboutContactTabs(WebDriver driver) {
		boolean isIframeLoaded = false;
		if(WaitUtils.waitForElementToBeVisible(driver, aboutTabIframe)) {
			driver.switchTo().frame(aboutTabIframe);
			if(aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded=true;
				logger.info("PASS: About and Contact Tabs Displayed");
			}else {
				logger.error("About and Contact Tabs not Displayed");
			}
		}
		return isIframeLoaded;
	}	
		
		
	//"Edit Profile"
	public boolean verifyEditProfilePopUpWindow(String expectedProfilePopWindowTitle) {
		boolean isEditProfilePopupWindowDisplayed=false;
		if(editProfilePopUpWindow.isDisplayed()) {
			String editProfilePopUpWindowTitle=editProfilePopUpWindow.getText();
			if(editProfilePopUpWindowTitle.contains(expectedProfilePopWindowTitle)) 
			{//,"Edit Profile Pop up window should be displayed");
			isEditProfilePopupWindowDisplayed=true;	
			logger.debug("PASS: Edit Profile Pop up Window Displayed");
				
			 }else {
				 logger.error("Edit Profile Pop up window not Displayed");
			 }
		}
		return isEditProfilePopupWindowDisplayed;
		}
	
	
	public void selectEditIcon(WebDriver driver) {
		if (WaitUtils.elementToBeClickable(driver, editProfile)) {
			editProfile.click();
			logger.info("Clicked on Edit profile button ");
		} else {
			logger.error("Edit profile button was not visible");
		}
	}
	
	
	public boolean selectUserMenuOption(WebDriver driver,String option) throws IOException {
		boolean isOptionVerified = false;
		logger.debug("Selecting an user menu option: "+option);
		String path="//*[text()='"+option+"']";
		WebElement userMenuOption=driver.findElement(By.xpath(path));
		
		if (WaitUtils.waitForElementToBeVisible(driver,userMenuOption)) {
			logger.debug(option+" was visible");
			userMenuOption.click();
			logger.debug(option+" was clicked");
			isOptionVerified = true;
			String actualProfilePage=driver.getTitle();
			if(actualProfilePage.contains(DataUtils.readUsermenuDropdownPageData("username"))) {
				logger.debug("PASS:" +option+ " page is displayed");
			}else {
				logger.error(option +" page not displayed");
			}
			
		} else {
			System.out.println(option + " Option is not visible");
			logger.debug(option+" Could not be selected");
		}
		return isOptionVerified;
	}
	
	
	
	
	
	public boolean verifyUserMenuMouseHover(WebDriver driver) {
		boolean isUserMenuDisplayed=false;
	if(userMenu.isDisplayed()) {
  	  if(BaseTest.mouseHover(driver,userMenu)) {
  		logger.info("Pass: UserMenu is Displayed on WebPage and MouseHovered on the element");
  		if(WaitUtils.elementToBeClickable(driver, userMenu))
  		userMenu.click();
  		isUserMenuDisplayed=true;
  		logger.info("Clicked on Usermenu");
  	  }
  	  else {
  		  logger.error("Not Clicked on usermenu Dropdown");
  	  }
  	}else {
  	  logger.error("Fail: Usermenu is not Displayed on WebPage");
    }
	return isUserMenuDisplayed;
}
    public boolean validatingDropdownListOfUserMenuOptions() {
    	boolean isUsermenuOptionsDisplayed=false;
	   if(myProfileOption.isDisplayed() && mySettingsOption.isDisplayed() && developerConsoleOption.isDisplayed() && lightningExperienceOption.isDisplayed() && logoutOption.isDisplayed()) {
		   isUsermenuOptionsDisplayed=true;
		   logger.info("PASS: Verifying the Options in UserMenu DropDown are Displayed as Expected");
	 		   }else {
	 			  logger.error("Verifying the Options in UserMenu DropDown are not Displayed.");
	 		   }
	   return isUsermenuOptionsDisplayed;
	}
	     
    }

