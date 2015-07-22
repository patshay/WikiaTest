package wikiatests;

import java.io.*;
import java.util.*;

public class FindAFile {

	//This class finds a file by searching a given directory
	
	private String fileNameToSearch;
	  private List<String> result = new ArrayList<String>();
	 
	  public String getFileNameToSearch() {
		return fileNameToSearch;
	  }//End of getFileNameToSearch
	 
	  public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	  }//End of setFileNameToSearch
	 
	  public List<String> getResultList() {
		return result;
	  }//End of getResult
	 
	  public void searchDirectory(File directory, String fileNameToSearch) {
	 
		setFileNameToSearch(fileNameToSearch);
	 
		if (directory.isDirectory()) {
		    search(directory);
		} else {
		    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}
	 
	  }//End of searchDirectory
	 
	  private void search(File file) {
		if (file.isDirectory()) {
	        //If you have permission to read this directory
		    if (file.canRead()) {
				for (File temp : file.listFiles()) {
				    if (temp.isDirectory()) {
				 
				    	if(temp.getName().matches("(.*)"+getFileNameToSearch())){
				    		result.add(temp.getAbsoluteFile().toString());
				    	}
				    	
				    //continue searching in the file, incase this is a duplicate
				    search(temp);//Continues searching if the file is a directory
				    
				    } else {
						if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {			
						    result.add(temp.getAbsoluteFile().toString());//If the file name to search and current file match then add it as a result
					    } else if(temp.getName().toLowerCase().endsWith(getFileNameToSearch())){
					    	result.add(temp.getAbsoluteFile().toString());//If a file is found that ends with the filename
					    }
		 
				    }//end of else
			    }//end of for loop
			 } else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			 }//End of permission denied else
	     }//End of if file.isDirectory()
		
	  }//End of search()

	  public String getFilePathFor(String fileName){
		  
		  	String filePath = "";
		  	result = new ArrayList<String>();
		  	
			//String to find the file
			String filepathStart =  System.getProperty("user.dir"); //This will set it to the path of the User working directory
			searchDirectory(new File(filepathStart), fileName);
		 
			int count = getResultList().size();
			
			switch (count){
			case 0: //If there are no results
					System.out.println("\nNo result found!");
					System.out.println("Could not find " + fileNameToSearch + "... was it deleted?");//return a string saying it was not found
					break;
			case 1: //If there was only 1 result found
					String foundPath = getResultList().get(0);
					System.out.println("\nFound " + count + " result!\n");
					System.out.println("Found : " + foundPath);
					filePath = foundPath;//Return that result
					break;
			default: //If there was more than 1 result found, print them all out and have a user chose the path that will be returned
					int resultIterator=1;
					System.out.println("\nFound " + count + " result!\n");
				    	for (String matched : getResultList()){
				    		System.out.println("#"+resultIterator+" Found : " + matched);
				    		resultIterator++;
				    	}
				    
				    //This will read input from the user, and let them chose what 
				    System.out.print("Please enter the number corresponding to the path you want to use for testing: ");
				    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				    try{
				    String inputString = input.readLine();
					    try {
					    	int i = Integer.parseInt(inputString);
					    		if(0<i && i<=resultIterator){
					        	filePath =  getResultList().get(i-1);}
					    		else{
					    			filePath = "That doesn't seem to be a valid choice";
					    		}
					      } catch(NumberFormatException e) {
					    	  filePath = "You entered a path choice that I couldn't parse!";
					      }
				    
				    } catch (IOException e) {
			            e.printStackTrace();
			            filePath = "There was a problem reading that input";
				    }
				    
			}//end of the switch statement
			
			return filePath;
	  }//End of getFilePathfor(string)
	  
	  
	  public String getFilePathFor(String fileName, String specificDirectory){
		  
		  	String filePath = "";
		  	result = new ArrayList<String>();
		  	
			//String to find the file
			String filepathStart =  System.getProperty("user.dir"); //This will set it to the path of the User working directory
			filepathStart = filepathStart + "/" + specificDirectory;
			
			
			
			searchDirectory(new File(filepathStart), fileName);
		 
			int count = getResultList().size();
			
			switch (count){
			case 0: //If there are no results
					System.out.println("\nNo result found!");
					System.out.println("Could not find " + fileNameToSearch + "... was it deleted?");//return a string saying it was not found
					
					break;
			case 1: //If there was only 1 result found
					String foundPath = getResultList().get(0);
					System.out.println("\nFound " + count + " result!\n");
					System.out.println("Found : " + foundPath);
					filePath = foundPath;//Return that result
					break;
			default: //If there was more than 1 result found, print them all out and have a user chose the path that will be returned
					int resultIterator=1;
					System.out.println("\nFound " + count + " result!\n");
				    	for (String matched : getResultList()){
				    		System.out.println("#"+resultIterator+" Found : " + matched);
				    		resultIterator++;
				    	}
						    
				    //This will read input from the user, and let them chose what 
				    System.out.print("Please enter the number corresponding to the path you want to use for testing: ");
				    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				    try{
				    String inputString = input.readLine();
					    try {
					    	int i = Integer.parseInt(inputString);
					    		if(0<i && i<=resultIterator){
					        	filePath =  getResultList().get(i-1);}
					    		else{
					    			filePath = "That doesn't seem to be a valid choice";
					    		}
					      } catch(NumberFormatException e) {
					    	  filePath = "You entered a path choice that I couldn't parse!";
					      }
				    
				    } catch (IOException e) {
			            e.printStackTrace();
			            filePath = "There was a problem reading that input";
				    }
				    
			}//end of the switch statement
			
			return filePath;
	}//End of getFilePathfor(string, string)
	
}//End of Find a File
