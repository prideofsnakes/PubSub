package pubsub.publisher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PublisherApp {
	public static final Logger logger = Logger.getLogger(
			PublisherApp.class.getName());
	
	public static void main(String[] args) {

		logger.log(Level.INFO, "Starting Publisher!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
		//остановить выполнение програаммы - наберите в консоли "q"	
		while (!s.equals("q") ) {
			s = br.readLine();
			//чтобы отправить сообщение, введите в консоли "send!"
			if (s.equals("send!")) {
				GeneratedMessage gm = new GeneratedMessage();
				logger.log(Level.INFO, "Sending message: "+gm.getMapValue().toString());
				sendMessage(gm);
			}
		}
		}
		
		catch (IOException ioe) {
			logger.severe(ioe.getMessage());
		}
		
		catch (Exception e) {
			logger.severe(e.getMessage());
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

        logger.info("Response status code: "+response.statusCode());
        if (response.statusCode() == 200) logger.info("Message succesfully sent to Subscriber!");
        else logger.severe("Your message didnt send, check the log");
		return response.statusCode();
	}
}
