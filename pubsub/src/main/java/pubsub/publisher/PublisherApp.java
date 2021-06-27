package pubsub.publisher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PublisherApp {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
		while (!s.equals("q") ) {
			s = br.readLine();
			if (s.equals("send!")) {
				GeneratedMessage gm = new GeneratedMessage();
				System.out.println(gm.getMapValue());
				sendMessage(gm);
			}
		}
		}
		
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.exit(0);
		}
		
	}
	
	private static int sendMessage(GeneratedMessage gm) throws Exception {
	    ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(gm.getMapValue());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/sendMes"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    
		return response.statusCode();
	}
}
