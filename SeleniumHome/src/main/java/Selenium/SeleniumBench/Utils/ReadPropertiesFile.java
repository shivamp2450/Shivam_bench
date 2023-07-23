package Selenium.SeleniumBench.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile
{
	static FileReader file;
	public static Properties prop;
	 
	// Static block to initialize a class variables for read properties 
	
	static
	{
		try
		{
			prop = new Properties();
			file = new FileReader(System.getProperty("user.dir")+"/configuration/Config.properties");
			prop.load(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
