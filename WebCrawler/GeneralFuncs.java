package WebCrawler;
/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 	General.java for web crawler portion of search engine project
 * 
 * 	Description:
 * 		This portion of the program deals with the creation of directories and data 
 *  files as well as the adding and cleaning of file contents. The final portion 
 *  returns the content of the given file to the called function.
 */

import java.io.*;
import java.util.ArrayList;

public class GeneralFuncs {
	
	//CreateSiteDirectory() function to create all necessary directories that may not already exist 
	public static String  CreateSiteDirectory(String directory){
		
		//Checking if the needed directories exist or not and creates the directories if they do not already exist
		if (!(new File(directory).exists())) {
			System.out.print("Creating new site directory: " + directory);
			File dir = new File(directory);
			dir.mkdirs();
		}
		else {
			System.out.println("Directory already Exists");
		}
		return directory;
	}
	
	//CreateDataFiles() function creates the two necessary data files for the current directory selected
	public static void CreateDataFiles(String directory, String Lib, String Project, String BaseURL) throws IOException {
		String queue = directory + "/queue.txt";
		String crawled = directory + "/crawled.txt";
		String Projects = Lib + "Projects.txt";
		
		//Checking if the queue file exists or not in the currently selected directory
		if (!(new File(queue).exists())) {
			FileWriter FW = new FileWriter(new File(queue));
			FW.write(BaseURL);
			FW.close();
		}
		
		//Checking if the crawled file exists or not in the currently selected directory
		if(!(new File(crawled).exists())) {
			FileWriter FW = new FileWriter(new File(crawled));
			FW.write("");
			FW.close();
		}
		
		//Checking if the Projects file exists or not in the lib directory
		if(!(new File(Projects).exists())) {
			FileWriter FW = new FileWriter(new File(Projects));
			FW.write(Project);
			FW.close();
		}
		
		//Checking if the current project has been added to the Projects.txt file and 
		//adds it if it does not already exist in the file
		else {
			BufferedReader BR = new BufferedReader(new FileReader(new File(Projects)));
			boolean isFound = false;
			String line;
			
			//Checking if the current Project is in the Projects.txt file
			while((line = BR.readLine()) != null) {
				if (line.equals(Project)) {
					isFound = true;
					break;
				}
			}
			BR.close();
			
			//Adding current project name to the Projects.txt file
			if (!isFound) {
				FileWriter FW = new FileWriter(new File(Projects), true);
				FW.append(Project + '\n');
				FW.close();
			}
		}
	}
	
	//AppendFile() function adds the content currently stored in an ArrayList to the file selected
	public static void AppendFile(String currFile, ArrayList<String> data) throws IOException {
		FileWriter FW = new FileWriter(new File(currFile));
		
		//Adding found links to the file selected
		for(int i = 0; i < data.size(); i++) {
			FW.append(data.get(i) + "\n");
		}
		FW.close();
	}
	
	// CleanFile() function clears all the content from the file selected
	public static void CleanFile(String currFile) throws IOException{
		FileWriter FW = new FileWriter(new File(currFile));
		FW.flush();
		FW.close();
	}
	
	//workingSet() function reads the contents of a files and outputs the information in an ArrayList to the called function
	public static ArrayList<String> workingSet(String currFile) throws IOException {
		ArrayList<String> AL = new ArrayList<String>();
		BufferedReader BR = new BufferedReader(new FileReader(currFile));
		String Line;
		
		//Reading a given file and adding all the information from the file to an ArrayList
		while ((Line = BR.readLine()) != null) {
			Line.replace("\n", "");
			//Ensuring that only unique content is added to the AL object
			if (!AL.contains(Line)) {
				AL.add(Line);
			}
		}
		BR.close();
		return AL;
	}
}
