package wikiatests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BaseClass {

	//each test class will extend BaseClass.  
	//This ensures a connection via singleton Manager object, and access to all helper classes
	
	ConnectionManager conManager;
	WebDriver wd = null;
	Actions action = null;//Action object to interact with mouse or keyboard
	public BaseClass(){
		
		//create or get a connection to the singleton
		conManager = ConnectionManager.getInstance();
		
		if(conManager.browserType.equals("chrome"))
		{
			wd = (ChromeDriver) conManager.getWebDriver();
		} else if (conManager.browserType.equals("firefox")){
			wd = (FirefoxDriver) conManager.getWebDriver();
		}
		
		action = new Actions(wd);//initialize the Action object for the new web driver
		
	}//End of BaseClass constructor
	
	public WebElement findElement(String by, String identifier){
		WebElement foundElement = null;
		ArrayList<WebElement> doesElementExist = null; 
		
		switch (by){
			case "className":
				doesElementExist = new ArrayList<WebElement>(wd.findElements(By.className(identifier)));
				break;
			case "id":
				doesElementExist = new ArrayList<WebElement>(wd.findElements(By.id(identifier)));
				break;
			case "cssSelector":
				doesElementExist = new ArrayList<WebElement>(wd.findElements(By.cssSelector(identifier)));
				break;
			case "xpath":
				doesElementExist = new ArrayList<WebElement>(wd.findElements(By.xpath(identifier)));
				break;
			case "partialLinkText":
				doesElementExist = new ArrayList<WebElement>(wd.findElements(By.partialLinkText(identifier)));
				break;
		}//end switch
		
		if(doesElementExist.size()==0){
			//No element was found for the identifier
			Assert.fail("Could not find the " + identifier);
		} else {
			//We found the element we want, return the last one in the list
			foundElement = doesElementExist.get(doesElementExist.size() - 1);
		}
		
		return foundElement;
	}
	
	public void findAndClick(String by, String identifier){
		findElement(by, identifier).click();
	}
	
	
}//End of BaseClass
