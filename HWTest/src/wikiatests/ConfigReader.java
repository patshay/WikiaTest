package wikiatests;

import java.io.*;
import java.util.*;

public class ConfigReader {

	String configFilePath = null;//String for config.txt filepath
	FindAFile fileSearch = new FindAFile(); //For finding the config.txt file
	File configTxt = null;//File object for config.txt
	Scanner scannerTop = null;//Scanner to consistently point to the top of config.txt
	Scanner configLines = null;
	String browserType;
	String userName;
	String password;
	
	public ConfigReader(){		
		configFilePath = fileSearch.getFilePathFor("config.txt", "src/wikiatests/");
		configTxt = new File(configFilePath);//make config.txt into a file object
		
		try { //Try to set the scanner to the top of the config.txt file
			scannerTop = new Scanner(configTxt);
			configLines = new Scanner(configTxt);
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND....SCANNER NOT SET TO THE TOP OF CONFIG.TXT!!!!!!");
			e.printStackTrace();
		}	
		
		
		while(configLines.hasNextLine()){//As long as there is another line
			Scanner parseScanner = new Scanner(configLines.nextLine());
			parseScanner.useDelimiter(":");
			if(parseScanner.hasNext()){
				String variable = parseScanner.next();
				String value = parseScanner.next();
				value = value.trim();
				
				if(variable.equals("Browser")){ browserType = value; }
				else if(variable.equals("Username")){ userName = value; }
				else if(variable.equals("Password")){ password = value; }
				
			}//end if
		}//end while
		
	}//End of ConfigReader()

	public File getConfigTxt(){return configTxt;}//Get the config.txt file
	public Scanner getScanner(){return scannerTop;}//Get the scanner thats at the top of the file
	
}//End of ConfigReader
