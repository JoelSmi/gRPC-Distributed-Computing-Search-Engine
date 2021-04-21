package WebCrawler;

public class DomainParser {
	public static String getDomainName(String URL) {
		String[] subdom = getSubDomainName(URL).replace('.', ',').split(",");
		return subdom[subdom.length-2] + "." + subdom[subdom.length-1];
	}
	public static String getSubDomainName(String URL) { 
		URL = URL.replace("http://", "");
		URL = URL.replace("https://", "");
		URL = URL.substring(0, URL.indexOf("/"));
		return URL;
	}
}
