package wikiatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectionManager {

	//connections manager needs to read from config file, and make correct driver connections

	public WebDriver wd = null;

	//singleton object
	public static ConnectionManager INSTANCE = null;
	
	//String that holds what 
	String browserType = "";
	
	
	//singleton constructor
	public ConnectionManager(){
		//have a find file object
		//have a config file reader object
		//have a scanner object
		
		//while statement for parsing the above scanner object
		
		//set the browserType to what config.txt says
		browserType = "chrome";
		System.setProperty("webdriver.chrome.driver", "/Users/patricksc/Dev/WikiaTest/HWTest/JarsAndDrivers/chromedriver"); //this will need a class that finds files, so that it can run on wikia's computers
		wd = new ChromeDriver();
		
	}//End of ConnectionManager constructor
	
	public static ConnectionManager getInstance(){
		//If the singleton object hasn't been initialized, do so before returning the singleton object
		if(INSTANCE == null){
			INSTANCE = new ConnectionManager();
		}
		return INSTANCE;
	}//End of getInstance constructor
	
	public void ConnectionManagerTearDown(){
		wd.quit();//Closes the singleton's web driver, ending the testing session
	}//End of ConnectionManagerTearDown
	
	public WebDriver getWebDriver(){ return wd; }
	
}//End of ConnectionManager