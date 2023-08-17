import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherController {
    private WeatherView view;
    private WeatherModel model;

    public WeatherController(WeatherView view, WeatherModel model) {
        this.view = view;
        this.model = model;

        // Add button click listener
        view.addButtonClickListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double[] latLonArray = model.setLatAndLonBasedOnZip();
                
                String information = model.generateWeatherInformation(latLonArray[0], latLonArray[1]);
                JsonParser parser = new JsonParser();
                JsonObject jsonResponse = parser.parseString(information).getAsJsonObject();
                System.out.println(jsonResponse);
                String location = jsonResponse.get("name").getAsString();
                // String description = jsonResponse.get("description").getAsString();
                // String temp = jsonResponse.get("temp").getAsString();
                String description = "";
                String temp = "100";
                view.displayInformation(location, description, temp);
            }
        });
    }
}
