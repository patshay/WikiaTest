package wikiatests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoUploadTest extends BaseClass {

	//include test annotations
	@Test(description = "VideoUploadTest", enabled = true)
	public void Test2() throws InterruptedException{
		/** 
		 * This test:
		 * 1. Navigates to the homework wikia site
		 * 2. Click Contribute
		 * 3. Click Add a video
		 * 4. Enter a youtube url, click the add button
		 * 5. Left click the link to file on the flash message
		 * 6. Verify the filename is the same as on the flash message
		 */
		
		//Redirect test check
		String youtubeUrl = "https://www.youtube.com/watch?v=h9tRIZyTXTI";
		String connectionURL = "http://qm-homework.wikia.com/";
		String redirectURL = "http://qm­homework.wikia.com/wiki/QM_HomeWork_Wikia";
		wd.get(connectionURL); //Connect to wikia homework page before redirection
		Thread.sleep(5000);//Sleep the thread, waiting for the redirect
		
		
		//Check the url and make sure the page has been redirected to http://qm­homework.wikia.com/wiki/QM_HomeWork_Wikia
		if(wd.getCurrentUrl().equals(connectionURL)){
			Assert.fail("Page was not redirected to " + redirectURL);
			}
		
		//Click contribute
		findAndClick("cssSelector", "nav.wikia-menu-button.contribute.secondary.combined");
		
		//Click Add a video
		findAndClick("xpath", "//a[(@href='/wiki/Special:WikiaVideoAdd')]");
		
		//Enter the video url
		findAndClick("cssSelector", "input#wpWikiaVideoAddUrl");
		action.sendKeys(youtubeUrl).build().perform();
			
		//Click add to submit the video
		findAndClick("cssSelector", "input");
		
		Thread.sleep(3000);//Wait for the upload flash message
		
		//Check the flash message for file name accuracy
		WebElement flashMessage = findElement("xpath", "//a[(@href='/wiki/File:The_Best_Classical_Music_In_The_World')]");
		String flashMessageFileName = flashMessage.getAttribute("title");
		
		//Go to the uploaded file page and check the flash message vs the file title
		WebElement videoTitle = findElement("partialLinkText", flashMessageFileName);
		
		String fileName = videoTitle.getAttribute("h1");
		
		System.out.println(videoTitle.getTagName());
		
		if(!flashMessageFileName.equals(fileName)){
			Assert.fail("Uploaded file name does not match the file on the youtube page");
		}
		
	} 
	
}//End of Video Upload Test
