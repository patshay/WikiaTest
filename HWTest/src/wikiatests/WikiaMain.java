package wikiatests;

import java.util.*;
import org.testng.TestNG;
import org.testng.xml.*;


//This main file will parse the config.txt file, and write the xml object needed to run TestNG tests


public class WikiaMain {

	//first lets set up the parsing for config.txt
	public static void main(String[] args){
		
		//Write the xml file for TestNG (hardcoded to make sure the tests runs)
				TestNG testNg = new TestNG();
				List<XmlClass> testsToRun = new ArrayList<XmlClass>();
				List<XmlSuite> suitesToRun = new ArrayList<XmlSuite>();
				
				//Set the suite name for the test (the folder the test will be in)
				XmlSuite suite = new XmlSuite();
				suite.setName("wikiasuite");
				
				//Set the test name of the xml and html files that are output by TestNG
				XmlTest test = new XmlTest(suite);
				test.setName("wikiatest");
				
				//Add the tests we want to run to the XmlClass list
				testsToRun.add(new XmlClass("wikiatests.LoginTest"));
				
				//Commit the list of tests to run to the XmlTest object
				test.setXmlClasses(testsToRun);
				
				//Add the suite to the list of xml suites to run
				suitesToRun.add(suite);
				
				//set and run the TestNG object
				testNg.setXmlSuites(suitesToRun);
				testNg.run();
				
				//Connect to the singleton connection object, and call the tear down method 
				ConnectionManager conManager = ConnectionManager.getInstance();
				conManager.ConnectionManagerTearDown();
			}//End of main method
			
			
		}//End of WikiaMain