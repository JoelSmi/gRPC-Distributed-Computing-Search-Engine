package Services;

/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 	EngineService.java provides the services that the client can access via the RPC connection
 * 
 * 	Description:
 * 		The two functions accessible directly through the RPC connection are the requestSite() and searchRequest() functions.
 * 	These two functions provide the use the ability to retrieve a valid URL from the stored files as well as make a keyword
 *  search request which returns the links that are most directly connected to the keyword provided.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import SearchEngineServerRPC.EngineServiceGrpc.EngineServiceImplBase;
import SearchEngineServerRPC.SearchEngine.KeywordRequest;
import SearchEngineServerRPC.SearchEngine.URLRequest;
import SearchEngineServerRPC.SearchEngine.URLs;
import SearchEngineServerRPC.SearchEngine.ValidURL;
import io.grpc.stub.StreamObserver;

public class EngineService extends EngineServiceImplBase
{

	@Override
	//requestSite() function is the URL search RPC connected function which takes in a URL and returns a 
	//boolean value indicating if the URL is valid or not.
	public void requestSite(URLRequest request, StreamObserver<ValidURL> responseObserver) {
		ValidURL.Builder isvalid = ValidURL.newBuilder();
		try {
			//Request to the isValidURL helper function
			isvalid.setIsValid(isValidURL(request.getKeyword()));
		} catch (IOException e) {
			System.out.println("Error checking URL");
			isvalid.setIsValid(false);
		}
		
		//Returning the response back to the client
		responseObserver.onNext(isvalid.build());
		responseObserver.onCompleted();
	}

	@Override
	public void searchRequest(KeywordRequest request, StreamObserver<URLs> responseObserver) {
		//code for parsing the keywords from the headers of web pages
	}
	
	/* 
	 * isValidURL() function is the helper function for the reQuestSite function to parse through the 
	 * projects.txt file and all found crawled.txt files for the URL links currently found and crawled 
	 * by the web crawler.
	*/
	public static boolean isValidURL(String URL) throws IOException {
		String Library = new File( "." ).getCanonicalPath() + "/lib/";
		BufferedReader BR = new BufferedReader(new FileReader(Library + "Projects.txt"));
		String Projectline;
		
		//Reading the projects created by the web crawler
		while ((Projectline = BR.readLine()) != null) {
			Projectline = Projectline.replace("\n", "");
			BufferedReader URLSearch = new BufferedReader(new FileReader(Library + Projectline + "/crawled.txt"));
			String URLline;
			//Reading the current project's crawled.txt file to search for the URL provided
			while ((URLline = URLSearch.readLine()) != null) {
				URLline = URLline.replace("\n", "");
				if(URLline.equals(URL)) {
					BR.close();
					URLSearch.close();
					return true;
				}
			}
			URLSearch.close();
		}
		BR.close();
		return false;
	}
	
}
