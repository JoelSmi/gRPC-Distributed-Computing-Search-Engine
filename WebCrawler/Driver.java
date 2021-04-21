package WebCrawler;

/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 
 * 	Description:
 */

import java.io.IOException;

public class Driver {
	private static String ProjectName = "FutureProjects";
	private static String Homepage = "https://www.google.com/";
	private static String DomainName = DomainParser.getDomainName(Homepage);
	//private static String queueFile = "/lib/" + ProjectName + "/queue.txt";
	//private static String crawledFile = "/lib/" + ProjectName + "/crawled.txt";
	
	public static void main(String[] args) throws IOException {
		Spider crawlers = new Spider(ProjectName, Homepage, DomainName);
		crawlers.Boot();
		crawlers.CrawlIterator("First Spider");
	}
}
