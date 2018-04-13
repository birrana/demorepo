package Academy.EndtoEnd_project;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.landingpage;
import pageobject.loginpage;
import resources.base;

public class Homepage extends base
{
	public static Logger Log = LogManager.getLogger((base.class.getName()));
@BeforeTest
	public void intialize() throws IOException
{
	
	driver=intializeDriver();
}

@Test (dataProvider = "getData") //data provide annotation
	public void basePageNavigation(String Username, String password, String text) throws IOException, InterruptedException
	{
	
		//driver = intializeDriver();
		driver.get(prop.getProperty("url"));
		
		landingpage l= new landingpage(driver);
		Thread.sleep(3000);
		l.getlogin().click();
		
		
		loginpage l1= new loginpage(driver);
		l1.getmail().sendKeys(Username);
		l1.getpassword().sendKeys(password);
		//System.out.println(text);
		Log.info(text);
		
		l1.getlogin().click();
		
	}
@AfterTest
public void teardown()
{
	driver.close();
	driver=null;

}
@ DataProvider
public Object[][] getData()
{
	//now stands for how many different data types test should run
	//column stands for how many values per each test
		Object[][] data = new Object [2][3];
		//oth row
		data[0][0]="non restricted user";
		data[0][1]="1234";
		data[0][2]= "restricted user";
		 
		//1st row
		
		data[1][0]="restricted user";
		data[1][1]="566789";
		data[1][2]="non restricted user";
		return data;
		

	}


	
}
