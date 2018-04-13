package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {
		
		public WebDriver driver;
		By signIn=By.cssSelector("a[href*='sign_in'");
		By title=By.cssSelector("#content.div.div.h2");
		public landingpage(WebDriver driver)
		{
			this.driver=driver;
		}
		//By signIn=By.cssSelector("a[href*='sign_in'");
		
		public WebElement getlogin()
		{
			return  driver.findElement(signIn);
		}
		public WebElement getTitle() {
			
			
			return driver.findElement(title);
		}
		
		
}
