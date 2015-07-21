package wikiatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	//each test class will extend BaseClass.  
	//This ensures a connection via singleton Manager object, and access to all helper classes
	
	ConnectionManager conManager;
	WebDriver wd = null;
	
	public BaseClass(){
		
		//create or get a connection to the singleton
		conManager = ConnectionManager.getInstance();
		
		if(conManager.browserType.equals("chrome"))
		{
			wd = (ChromeDriver) conManager.getWebDriver();
		} else if (conManager.browserType.equals("firefox")){
			System.out.println("FIREFOX NOT SET YET");
		}
		
	}//End of BaseClass constructor
	
	
	
}//End of BaseClass
