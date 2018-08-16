import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestAngularApp {
	@Test
	public void begin() throws InterruptedException {
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVER_EXE);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		driver.get("https://account-stg.sylkar.net/login");
//
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		Thread.sleep(2000);
//
		driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys("sylkar-test-5@mailinator.com");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("hunter");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();

//
			 driver.findElement(By.xpath("//a[@routerlink = '/registration']")).click();


	}
}