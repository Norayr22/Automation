package ConfigurationDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.ConfigReader;

public class TestSeleniumInChrome {
	ConfigReader  config;
	
	@BeforeTest
	public void setup()
	{
		config = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
	}
	
	@Test
	public void testChrome()
	{
		ConfigReader config = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		WebDriver driver = new ChromeDriver();
		driver.get(config.getApplicationUrl());
		driver.quit();
	}

}
