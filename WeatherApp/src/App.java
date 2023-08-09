import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        
        String apiKey = System.getenv("OPENWEATHERMAP_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("API key not set. Exiting...");
            return;
        }
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=" + apiKey))
            .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            
        HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(response.body());

    }
}
