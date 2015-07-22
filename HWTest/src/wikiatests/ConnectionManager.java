package wikiatests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConnectionManager {

	//connections manager needs to read from config file, and make correct driver connections

	public WebDriver wd = null;

	//singleton object
	public static ConnectionManager INSTANCE = null;
	
	//String that holds what browser we should use
	public ConfigReader conRead;
	
	String browserType = "";
	
	//singleton constructor
	public ConnectionManager(){
		
		FindAFile fileSearch = new FindAFile();//For finding the correct webdriver
		String webdriverLocation = "";
		conRead = new ConfigReader();
		browserType = conRead.browserType.toLowerCase();//make this string easier to compare
		
		if(browserType.toLowerCase().equals("chrome"))
		{
		  webdriverLocation = fileSearch.getFilePathFor("chromedriver", "/JarsAndDrivers");
		  System.setProperty("webdriver.chrome.driver", webdriverLocation); //this will need a class that finds files, so that it can run on wikia's computers
		  wd = new ChromeDriver();
		} else if (browserType.equals("firefox")){
		    wd = new FirefoxDriver();
		}
		wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
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