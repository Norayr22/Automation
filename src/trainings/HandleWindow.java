package trainings;

import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.html.Keyboard;

public class HandleWindow {

	@Test
	public void start() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norayr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
     	driver.findElement(By.xpath("//a[@href='http://www.google.com']")).sendKeys(Keys.CONTROL.ENTER);
        System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@href='http://www.facebook.com']")).sendKeys(Keys.CONTROL.ENTER);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@href='http://www.yahoo.com']")).sendKeys(Keys.CONTROL.ENTER);
		System.out.println(driver.getTitle());
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		int count = allWindows.size();
		System.out.println(count);
		driver.switchTo().window(tabs.get(3));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(tabs.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(tabs.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());
		System.out.println(count);
		Thread.sleep(3000);
		driver.quit();

	}
}