package Academy.EndtoEnd_project;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageobject.landingpage;
import pageobject.loginpage;
import resources.base;

public class Validatetitle extends base
{
	public static Logger Log = LogManager.getLogger((base.class.getName()));
@BeforeTest
	public void intialize() throws IOException
{
	driver=intializeDriver();
	Log.info("Driver is initialize");
	driver.get(prop.getProperty("url"));
	Log.info("Navigated to Home Page");
}


	public void basePageNavigation() throws IOException, InterruptedException
	{
		//driver = intializeDriver();
		
		
		landingpage l= new landingpage(driver); // compare the text from broswer with the actual text
		Assert.assertEquals(l.getTitle().getText(), "Featured Course123"); //Assert.assertTrue(argo);
		Log.info("Successfully validate Text Message");
		
		
	}
@AfterTest
public void teardown()
{
	driver.close();
	driver=null;

}

		

	}


	

