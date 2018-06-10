package trainings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	
	@Test
	public void testSoft() {
		
		
		SoftAssert assertion = new SoftAssert();
		System.out.println("Test Started");
		assertion.assertEquals(12, 13, "Does not match");
		System.out.println("Test Completed");
		assertion.assertAll();
		

		 
	}
}
