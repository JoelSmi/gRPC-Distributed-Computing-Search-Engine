import SearchEngineServerRPC.EngineServiceGrpc;
import SearchEngineServerRPC.SearchEngine.KeywordRequest;
import SearchEngineServerRPC.SearchEngine.URLRequest;
import SearchEngineServerRPC.SearchEngine.URLs;
import SearchEngineServerRPC.SearchEngine.ValidURL;
import SearchEngineServerRPC.EngineServiceGrpc.EngineServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class SearchEngineClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		while (!input.equals("q")) {
			System.out.println("Enter the URL you wish to check (\'q\' to quit): ");
			input = scan.nextLine();
			if (input.equals("q")) {
				continue;
			}
			
			ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 10000).usePlaintext().build();
			EngineServiceBlockingStub requestStub = EngineServiceGrpc.newBlockingStub(chan);
			
			URLRequest request = URLRequest.newBuilder().setKeyword(input).build();
			ValidURL isValid = requestStub.requestSite(request);
			
			if (isValid.getIsValid()) {
				System.out.println("The given URL is Valid");
			}
			else {
				System.out.println("The given URL is NOT Valid");
			}
		}
		scan.close();
	}
}
