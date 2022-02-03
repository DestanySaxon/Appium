package applicationName;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (MalformedURLException exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", ""); //Located in settings -> about phone
		cap.setCapability("udid", ""); //device connect to pc, run command 'adb devices', first value
		cap.setCapability("platformName", ""); //Android or iOS
		cap.setCapability("platformVersion", ""); //device settings -> about phone -> version
		
		//Every application on any device will have the two below values 
		//Using app called Apk Info I found below values for calculator
		cap.setCapability("automationName", "");
		cap.setCapability("appPackage", "");
		cap.setCapability("appActivity", "");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub"); //Default host and port then this is your url
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started");
	}
}
