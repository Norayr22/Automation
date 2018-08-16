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

import library.ExcelDataConfig;

public class FacebookLoginWithExcel {
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
		
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\User\\eclipse-workspace\\Learn_Automation\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][2];
		
		for(int i = 0; i < rows; i++)
		{
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			
		}
		
		return data;
	}

}
