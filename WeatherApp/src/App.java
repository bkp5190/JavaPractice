import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {
    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("OPENWEATHERMAP_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("API key not set. Exiting...");
            return;
        }

        String zipCode = System.getenv("ZIP_CODE");
        if (zipCode == null || zipCode.isEmpty()) {
            System.out.println("Zip code is not set. Exiting...");
            return;
        }

        HttpRequest zipRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://api.openweathermap.org/geo/1.0/zip?zip=" + zipCode + "&appid=" + apiKey))
            .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> zipResponse = null;
		try {
			zipResponse = HttpClient.newHttpClient().send(zipRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(zipResponse.body());

        // Parse JSON using Gson
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(zipResponse.body()).getAsJsonObject();

        // Extract the "lat" and "lon" based on zip
        double lat = jsonResponse.get("lat").getAsDouble();
        double lon = jsonResponse.get("lon").getAsDouble();


        HttpRequest forecastRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey))
            .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            
        HttpResponse<String> forecastResponse = null;
		try {
			forecastResponse = HttpClient.newHttpClient().send(forecastRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(forecastResponse.body());

    }
}
