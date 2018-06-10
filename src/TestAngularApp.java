import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestAngularApp {
	@Test
	public void begin() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norayr\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 Map<String, Object> prefs = new HashMap<String, Object>();
	 prefs.put("profile.default_content_setting_values.notifications", 2);
     ChromeOptions options = new ChromeOptions();
	 options.setExperimentalOption("prefs", prefs);
	 options.addArguments("disable-infobars");
	 WebDriver driver = new ChromeDriver(options);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	 driver.get("https://account-stg.sylkar.net/login");

	 driver.findElement(By.xpath("//button[@class = 'sk-orange-submit text-uppercase text-center center-block']")).click();
	 
	 driver.findElement(By.xpath("//input[@class = 'sk-dark-input ng-pristine ng-invalid ng-touched'][@type = 'email']")).sendKeys("sylkar-test-5@mailinator.com");
	 driver.findElement(By.xpath("//input[@class = 'sk-dark-input ng-pristine ng-invalid ng-touched'][@type = 'password']")).sendKeys("hunter");
	 driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	 
	 
//	 driver.findElement(By.xpath("//a[@routerlink = '/registration']")).click();
	 

}
}