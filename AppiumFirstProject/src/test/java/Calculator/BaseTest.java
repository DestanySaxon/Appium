package Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	static AppiumDriver<MobileElement> driver;
	
	@BeforeTest 
	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy S9+"); //Located in settings -> about phone
		cap.setCapability("udid", "192.168.4.21:5555"); //device connect to pc, run command 'adb devices', first value
		cap.setCapability("platformName", "Android"); //Android or iOS
		cap.setCapability("platformVersion", "10"); //device settings -> about phone -> version
		
		//Every application on any device will have the two below values 
		//Using app called Apk Info I found below values for calculator
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub"); //Default host and port then this is your url
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started");
	}
}
