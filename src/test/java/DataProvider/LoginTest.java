package DataProvider;


import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	  WebDriver driver;
	 
	  @BeforeMethod
	  public void setup() {
		  System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); 
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();	    
	      driver.get("https://parabank.parasoft.com/parabank/index.htm"); 
		  	  
		  
	  }
	  
		@Test(dataProvider="create", dataProviderClass=DataProviderTest.class)
		public void login_to_parabank(String username, String password) {
			
			  driver.findElement(By.name("username")).sendKeys(username);
			  driver.findElement(By.name("password")).sendKeys(password);
			  driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();

			
			 
		}
		@AfterMethod
		public void teardown() {
			driver.close();
		}
	  

		  
}


