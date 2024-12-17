import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleCommands {
	
	static AndroidDriver driver;
	
	/**
	 * 
	 */
	public static void doLeftSwipe() {
		PointerInput finger1=new PointerInput(Kind.TOUCH,"finger1");
		Sequence swipe=new Sequence(finger1,0);
		swipe.addAction(finger1.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),1018, 1564));
		swipe.addAction(finger1.createPointerDown(0));
		swipe.addAction(finger1.createPointerMove(Duration.ofSeconds(2), Origin.viewport(),54,1564));
		swipe.addAction(finger1.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}
	
	
	public static void tap() {
		PointerInput finger1=new PointerInput(Kind.TOUCH,"finger1");
		Sequence tap=new Sequence(finger1,0);
		tap.addAction(finger1.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),526, 626));
		tap.addAction(finger1.createPointerDown(0));
		tap.addAction(finger1.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
	}
	
	public static void pinchZoom() {
		PointerInput finger1=new PointerInput(Kind.TOUCH,"finger1");
		Sequence zoom=new Sequence(finger1,0);
		zoom.addAction(finger1.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),500, 626));
		zoom.addAction(finger1.createPointerDown(0));
		zoom.addAction(finger1.createPointerMove(Duration.ofSeconds(2), Origin.viewport(),500,426 ));
		zoom.addAction(finger1.createPointerUp(0));
		driver.perform(Arrays.asList(zoom));
		
		
		PointerInput finger2=new PointerInput(Kind.TOUCH,"finger2");
		Sequence zoom1=new Sequence(finger2,0);
		zoom1.addAction(finger2.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),544, 415));
		zoom1.addAction(finger2.createPointerDown(0));
		zoom1.addAction(finger2.createPointerMove(Duration.ofSeconds(5), Origin.viewport(),544,1749));
		zoom1.addAction(finger2.createPointerUp(0));
		driver.perform(Arrays.asList(zoom,zoom1));
	}
	
	public static void rotateDevice(ScreenOrientation type) {
		if(!driver.getOrientation().equals(type)) {
		   driver.rotate(type);
		}
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options uio=new UiAutomator2Options();
		uio.setAppPackage("com.solodroid.solomerce");
		uio.setAppActivity(".activities.ActivitySplash");
		uio.setDeviceName("Samsung");
		uio.setPlatformName("Android");
		uio.setPlatformVersion("10");
		
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723"),uio);
        System.out.println("app launched");
        
        Thread.sleep(3000);
        
      //  com.solodroid.solomerce:id/recycler_view
         String container="new UiSelector().resourceId(\"com.solodroid.solomerce:id/recycler_view\")";
         
         String babySuiteElement="new UiSelector().textContains(\"Animal\")";
         driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable("+container+").scrollForward().scrollIntoView("+babySuiteElement+")")).click();
        
         
        
         
//        driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/search")).click();
//        driver.hideKeyboard();
//        driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("baby");
        
      //driver.runAppInBackground(Duration.ofSeconds(5));
//        SampleCommands.rotateDevice(ScreenOrientation.PORTRAIT);
//        
//        SampleCommands.rotateDevice(ScreenOrientation.LANDSCAPE);
        //WebElement element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Samsung\")"));
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
     
        Thread.sleep(1000);
//        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Samsung\")"));
//       
//        element.click();
//       
//      SampleCommands.tap();
//        SampleCommands.pinchZoom();
        
        
	    //SampleCommands.doLeftSwipe();
	}

}
