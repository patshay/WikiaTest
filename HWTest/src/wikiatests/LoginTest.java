package wikiatests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

	//include test annotations
	@Test(description = "LoginTest", enabled = true)
	public void Test1() throws InterruptedException{
		
		/** 
		 * This test:
		 * 1. Navigates to ​http://qm­homework.wikia.com
		 * 2. Hover mouse over login label
		 * 3. enter username and password, left click the enter button
		 * */
		
		String connectionURL = "http://qm-homework.wikia.com/";
		String redirectURL = "http://qm­homework.wikia.com/wiki/QM_HomeWork_Wikia";
		wd.get(connectionURL); //Connect to wikia homework page before redirection
		Thread.sleep(3000);//Sleep the thread, waiting for the redirect
		
		//Check the url and make sure the page has been redirected to http://qm­homework.wikia.com/wiki/QM_HomeWork_Wikia
		if(wd.getCurrentUrl().equals(connectionURL)){
			Assert.fail("Page was not redirected to " + redirectURL);
		}
		
		//Find the sing in object and make sure it exists (use find elements to get a list)
		WebElement signIn = findElement("className", "sign-in-label");
		
		//Hover the mouse over the sign in button
		action.moveToElement(signIn).click().build().perform();
		
		//Find the Username Input Box
		findAndClick("id", "usernameInput");
		action.sendKeys(conManager.conRead.userName).build().perform();
		
		//Find the password Input Box
		findAndClick("id", "passwordInput");
		action.sendKeys(conManager.conRead.password).build().perform();
		
		//Find the login button
		findAndClick("cssSelector", "input.login-button");
		
	}
}//End of LoginTest
