import java.net.http.HttpRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherModel {
    private String apiKey;
    private String zipCode;

    public WeatherModel(String apiKey, String zipCode) {
        this.apiKey = apiKey;
        this.zipCode = zipCode;

    }

    public double[] setLatAndLonBasedOnZip() {

        double[] latLonArray = new double[2];

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

        // Parse JSON using Gson
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(zipResponse.body()).getAsJsonObject();

        // Extract the "lat" and "lon" based on zip
        double lat = jsonResponse.get("lat").getAsDouble();
        double lon = jsonResponse.get("lon").getAsDouble();

        latLonArray[0] = lat; 
        latLonArray[1] = lon;

        return latLonArray;
    }

    public void generateWeatherInformation(double lat, double lon) {
        
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
