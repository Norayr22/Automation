package trainings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HiddenElements {
	@Test
	public void start() {
		

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norayr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		 
		List<WebElement> radio = driver.findElements(By.id("male"));
		
		int count = radio.size();
		
		System.out.println(count);
		
		for(int i = 0; i< count; i++)
		{
			int x = radio.get(i).getLocation().getX();
			
			if(x!=0)
			{
				radio.get(i).click();
				break;
			}
		}
		
		

		
	}

}
