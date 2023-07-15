package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	public static String readConfig(String key) throws IOException
	{
//		to get the current project path
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		
		File file = new File(path);
		
		FileInputStream fis = new FileInputStream(file);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String value = prop.getProperty(key);
		
		return value;
	}
	
	
	

}
