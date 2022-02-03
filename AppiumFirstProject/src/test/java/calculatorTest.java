import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class calculatorTest {

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
		
		//2 + 3 = 5
		MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
		MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
		MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
		MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
		MobileElement results = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
		
		two.click();
		plus.click();
		three.click();
		equals.click();
		
		//verify results
		Assert.assertEquals(results.getText(), "5");
		System.out.println("Completed");
	}
}
