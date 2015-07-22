package wikiatests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class WriteXMLFile {
	
	private List<XmlSuite> listOfSuites = new ArrayList<XmlSuite>();
	private List<XmlClass> classesToRun = new ArrayList<XmlClass>();
	private XmlSuite suite = new XmlSuite();//The folder that TestNG creates to hold the suite's tests
	private XmlTest test;
	private TestNG testNg = new TestNG();//object so we can actually run the testNG tests
	
	//I could also add constructors here like groups to include/exclude, but they aren't needed for this project
	
	public void setXmlSuiteName(String suiteName){suite.setName(suiteName);}//Will be the name of the folder that holds all the TestNG print out info
	public String getXmlSuiteName(){return suite.getName();}
	
	public void setXmlTestName(String testName){
		test = new XmlTest(suite);
		test.setName(testName);//Will be the name of the test's XML and HTML files that the test outputs
	}
	public String getXmlTestName(){return test.getName();}
	
	public void addSuiteToListOfXmlSuites(){listOfSuites.add(suite);}
	public void setAndRunTestNG(){
		testNg.setXmlSuites(listOfSuites);//Set the TestNG's sml suite
		testNg.run();//Run the XMl file
	}
	
	public void addToXmlClasses(XmlClass classToAdd){classesToRun.add(classToAdd);}//method to add classes to the include list
	public void commitXmlClasses(){test.setXmlClasses(classesToRun);}
	
}
