package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class base {
	//private static final String TakeScreenshot = null;
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream f1 = new FileInputStream("/Users/allwazz_awal/eclipse-workspace/EndtoEnd_project/src/main/java/resources/data.properties");
		prop.load(f1);
		//prop.getProperty("broswer");
		
		String browserName = prop.getProperty("broswer");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/allwazz_awal/Downloads/chromedriver");
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
		} 
		
		else if (browserName.equals("IE"))
			
			
		{
			System.out.println("dgdgdg");
		}
		
		else if (browserName.equals("firefox"))
			System.setProperty("webdriver.Firefox.driver", "/Users/allwazz_awal/Downloads/geckodriver");
		{
			System.out.println("webdriver.driver.firefox");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException
	{
	
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("/Users/allwazz_awal/Desktop/Test" + result + "Screenshot.png"));
		
	}
}
