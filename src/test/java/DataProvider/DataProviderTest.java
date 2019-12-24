package DataProvider;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public  class DataProviderTest {
	WebDriver driver;
	
	 @DataProvider(name="create")
	  public static Object[][] getlogindata() throws EncryptedDocumentException, Exception{
	  Object data[][]  =  TestUtil.getTestData("login");	  
		return data;
			
		}
	
	

		
	

}
