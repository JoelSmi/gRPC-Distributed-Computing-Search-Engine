# Distributed-Computing-Web-Browser

## Client:
   #### -making Request
   #### -GUI to make a keyword or URL request
  ### Retrieving Information
    #### -Display the URLs for the keyword(s) requested
    #### -Display the Page of the URL requested
## Server:
  ### Determine if the given string is a URL or a keyword being requested
  #### Finding Webpage
      ##### -Converting given string to a URL webpage 
      ##### -Pass found page back to the Client
    #### Keyword Search
      ##### -Search for the given keyword(s)
      ##### -Provide list of the URLs associated to the keyword(s) found
## RPC Request:
  ### -Client request:
    #### -Pass inputted string to the server for processing
    #### -Return a connection status when a request is made
  ### -Server Request:
    #### -Pass found information back to the user
    #### -Provide a return status when attempting to return the information back to the client
