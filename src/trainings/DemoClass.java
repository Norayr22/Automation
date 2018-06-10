package trainings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Helper;

public class DemoClass {
	
	@Test
	public void start() {
		

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norayr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://facebook.com");
		 
		 WebElement username = driver.findElement(By.id("email"));
		 Helper.highLightElement(driver, username);
		 username.sendKeys("nksanoro@gmail.com");
		 WebElement password = driver.findElement(By.id("pass"));
		 Helper.highLightElement(driver, password);
		 password.sendKeys("iamtheone2217");
		 WebElement login = driver.findElement(By.id("loginbutton"));
		 Helper.highLightElement(driver, login);
		 login.click();
		 
	}


}
