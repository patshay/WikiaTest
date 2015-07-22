TO RUN:
The tests are in Java, and use TestNG to run.  Simply compile WikiaMain.java, and that will construct the XML file to run the tests in TestNG


Extras:
For this assignemnt all the tests work until you get to part 2.6 (Verify that the filename is the same as on the flash message (note spaces may be shown as underscores))

I was unable to properly identify the Video's title on the upload page, so every comparison to the Upload Header fails.

If you would like to change the browser or user details that we are testing, alter the CONFIG.txt file in HWTest/src/wikiatests

Instead of using Maven I have included the selenium and chromedriver libraries/exe in HWTest/JarsAndDrivers.  
I added them to the build path inside Eclipse.

If these tests were more complex or repetetive, I could add more helper methods like findAndClick, and finElement to the Base Class.

FindAFile.java is a class that I wrote when learning how to use Selenium and Appium.  The methods there are able to find normal files, as well as those inside .app and .ipa files (which are treated like zipped folders by java's methods).