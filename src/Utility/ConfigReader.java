package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.bytebuddy.jar.asm.tree.analysis.SourceInterpreter;

public class ConfigReader {
	Properties pro;
	
	public ConfigReader()
	{
		
		try {
			File src = new File("./Configuration/config.property");
			
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
	
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public String getChromePath()
	{
		String path = pro.getProperty("ChromeDriver");
		return path;
	}
	
	public String getApplicationUrl()
	{
		return pro.getProperty("URL");
	}

}
