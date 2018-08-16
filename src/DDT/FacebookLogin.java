package DDT;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin {
	WebDriver driver;

    @Test(dataProvider = "facebookData")
	public void loginToFacebook(String userName, String passWord) throws InterruptedException {
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVER_EXE);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("email")); 
		username.sendKeys(userName);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(passWord);
		WebElement login_button = driver.findElement(By.xpath("//input[@value = 'Log In']"));
		login_button.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Facebook"), "user is not abel to Login");
		System.out.println("user logged in successfully");
	
	}
    @AfterMethod
    public void close()
    {
    	driver.quit();
    }
	@DataProvider(name = "facebookData")
	public Object[][] passData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admin1";
		data[0][1] = "password1";
				
		data[1][0] = "nksanoro@gmail.com";
		data[1][1] = "iamtheone2217";
		
		data[2][0] = "admin2";
		data[2][1] = "password2";
		
		return data;
	}

}
