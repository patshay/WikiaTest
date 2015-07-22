package wikiatests;

import org.testng.xml.*;


//This main file will parse the config.txt file, and write the xml object needed to run TestNG tests


public class WikiaMain {

	//first lets set up the parsing for config.txt
	public static void main(String[] args){
		
		//Write the xml file for TestNG (hardcoded to make sure the tests runs)
				
		
		WriteXMLFile testXML = new WriteXMLFile();
		testXML.setXmlSuiteName("wikiasuite");//Name of the folder
		testXML.setXmlTestName("wikiatest");//Name of the XML File
		
		//Add the two tests to the xml file
		testXML.addToXmlClasses(new XmlClass("wikiatests.LoginTest"));
		testXML.addToXmlClasses(new XmlClass("wikiatests.VideoUploadTest"));
		
		//Now that the tests are added, commit them
		testXML.commitXmlClasses();

		//Run the TestNG test
		testXML.addSuiteToListOfXmlSuites();
		testXML.setAndRunTestNG();

		//Connect to the singleton connection object, and call the tear down method 
		ConnectionManager conManager = ConnectionManager.getInstance();
		conManager.ConnectionManagerTearDown();
	}//End of main method
			
			
		}//End of WikiaMain