package trainings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFIle {

	
	@Test
	public void start() throws Exception {
		

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norayr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("file:///C:/Users/Norayr/Desktop/fileupload.html");
		 
		 driver.findElement(By.xpath("//input[@name = 'resumeupload']")).click();
		 
		 Runtime.getRuntime().exec("C:\\Users\\Norayr\\Desktop\\AutoIt\\fileUpload1.exe"+" "+"C:\\Users\\Norayr\\Desktop\\Screenshot_5.png");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@name = 'resumeupload']")).click();
		 Runtime.getRuntime().exec("C:\\Users\\Norayr\\Desktop\\AutoIt\\fileUpload1.exe"+" "+"C:\\Users\\Norayr\\Desktop\\12.jpg");
		 Thread.sleep(3000);
		 
}
	
}
