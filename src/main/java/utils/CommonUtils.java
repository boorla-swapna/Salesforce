package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constants.FileConstants;


public class CommonUtils {
	WebDriver driver;
	public static String captureScreenShot(WebDriver driver) {
		String filepath=FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot page=(TakesScreenshot)driver;
		File srcFile=page.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filepath);
		srcFile.renameTo(DestFile);
		return filepath;
  }

	public static String getTimeStamp() {
//		 SimpleDateFormat formatter = new SimpleDateFormat("yyyymmddHHmmss");
//	        Date date = new Date();
//	        String localDate=formatter.format(Date);
//	        return localDate;
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
//	public static void mouseHover(WebDriver driver,WebElement element) {
//		Actions action=new Actions(driver);
//		action.moveToElement(element).build().perform();
//	}
	
}
