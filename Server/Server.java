/*	Author: Joel Smith
 * 	CS4504: Parallel and Distributed Computing
 * 	Spring 2021
 * 
 * 	Purpose:
 * 	Server.java runs the server on a certain port, 10000, for the RPC connection to communicate across
 * 
 * 	Description:
 * 		The main function builds a server on the port 10000 with the services accessible directly through 
 *  the RPC connection and the web crawler running while the server is active. 
 */

import java.io.IOException;
import Services.EngineService;
import io.grpc.ServerBuilder;

public class Server {
	public static void main(String[] agrs) throws IOException, InterruptedException {
		io.grpc.Server serv = ServerBuilder.forPort(10000).addService(new EngineService()).build();
		
		//Starting the server
		serv.start();
		
		//Printing the startup response and the port number it is running on
		System.out.println("Server started on port " + serv.getPort());
		
		//Awaits a call to be terminated
		serv.awaitTermination();
	}
}
