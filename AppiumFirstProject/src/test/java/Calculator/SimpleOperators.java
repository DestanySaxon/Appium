package Calculator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;

public class SimpleOperators extends BaseTest{
	private MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
	private MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
	private MobileElement results = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
	
	@Test 
	public void twoPlusThree() {
		//2 + 3 = 5
		MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
		MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
		
		two.click();
		plus.click();
		three.click();
		equals.click();
		
		//verify results
		Assert.assertEquals(results.getText(), "5");
		System.out.println("Completed");
	}
	
}
