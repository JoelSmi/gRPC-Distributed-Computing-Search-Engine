package WebCrawler;

/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 	Spider.java class structure to create the spider objects for parsing web pages
 * 
 * 	Description:
 * 		
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class Spider {
	
	//Class variables to share information across all instances of the Spider class
	private static String Project;
	private static String Library; 
	private static String Directory;
	private static String BaseURL;
	private static String Domain;
	private static String queue;
	private static String crawled;
	private static ArrayList<String> queuedSet;
	private static ArrayList<String> crawledSet;
	private static boolean isAccessable = true;
	
	//Spider Constructor
	public Spider(String currproject, String Base, String domain) throws IOException{
		Project = currproject;
		Directory = new File( "." ).getCanonicalPath() + "/lib/" + Project;
		Library = new File( "." ).getCanonicalPath() + "/lib/";
		BaseURL = Base;
		Domain = domain;
		queue = new File( "." ).getCanonicalPath() + "/lib/" + Project + "/queue.txt";
		crawled = new File( "." ).getCanonicalPath() + "/lib/" + Project + "/crawled.txt";
	}
	
	public static void setIsAccessable(boolean value) {
		isAccessable = value;
	}
	
	//Boot() function for the spider processes to initiate properly
	public void Boot() throws IOException {
		GeneralFuncs.CreateSiteDirectory(Directory);
		GeneralFuncs.CreateDataFiles(Directory, Library, Project, BaseURL);
		queuedSet = GeneralFuncs.workingSet(queue);
		crawledSet = GeneralFuncs.workingSet(crawled);
	}
	
	public void CrawlIterator(String currSpider) throws IOException {
		for(int i = 0; i < queuedSet.size(); i++) {
			CrawlPage(currSpider, queuedSet.get(i));
		}
	}
	
	//CrawlPage() function displays current progress for page crawling as well as updating the set
	public void CrawlPage(String currSpider, String currURL) throws IOException {
		if (!crawledSet.contains(currURL)) {
			System.out.println("\n" + currSpider + " is currently crawling " + currURL);
			System.out.println("Queued: " + queuedSet.size() + "| Crawled: " + crawledSet.size());
			
			AddToQueue(LinkParser.StartTagHandler(BaseURL, currURL));
			queuedSet.remove(currURL);
			if (isAccessable) {
				crawledSet.add(currURL);
			}
			updateFile();
		}
	}
	
	//AddToQueue() function adds all the found links on a web page to the working queue 
	public void AddToQueue(ArrayList<String> arrayList) {
		for(int i =0; i < arrayList.size(); i++) {
			if (crawledSet.contains(arrayList.get(i))) {
				continue;
			}else if (queuedSet.contains(arrayList.get(i))) {
				continue;
			}else if (!arrayList.get(i).contains(Domain)) {
				continue;
			}
			queuedSet.add(arrayList.get(i));
		}
	}
	
	//updateFile() function Updates the files to permanently save progress should the program close
	public void updateFile() throws IOException {
		GeneralFuncs.AppendFile(queue, queuedSet);
		GeneralFuncs.AppendFile(crawled, crawledSet);
	}
}
