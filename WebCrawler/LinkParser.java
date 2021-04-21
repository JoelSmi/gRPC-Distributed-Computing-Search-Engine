package WebCrawler;
/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 	LinkParser.java accesses the web page via a URL to extract all links located in 'a' tags in the site HTML
 * 
 * 	Description:
 * 		The only function, StartTagHandler(), uses the JSoup library to access all the start tags 
 * 	in the accessed HTML to search for the a[href] tag attributes for storage in an ArrayList which 
 * 	is then sent back to the called function for further processing.
 */
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class LinkParser {
	public static ArrayList<String> StartTagHandler(String BaseURL, String currURL) {
		ArrayList<String> LinkSet = new ArrayList<String>();
		try {
			
			//connecting to the given URL
			Document doc = Jsoup.connect(currURL).get();
			Spider.setIsAccessable(true);
			
			//Indicating which URL is being accessed currently
			String title = doc.title();
			System.out.println("Currently Scanning:" + title);
			
			//Selecting only the a tags and the href attributes for those a tags
			Elements links = doc.select("a[href]");
			
			//iterating through all the links stored in the a tags
			for (Element link : links) {
				
				//adding only unique links to the LinkSet arrayList
				if (!LinkSet.contains(link.attr("abs:href"))) {
					LinkSet.add(link.attr("abs:href"));
				}
			}
		} 
		catch (IOException e){
			Spider.setIsAccessable(false);
			System.out.println("Invalid or inaccessable link.");
		}
		return LinkSet;
	}
}
