import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONObject;

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
                
                JSONObject information = model.generateWeatherInformation(latLonArray[0], latLonArray[1]);
                System.out.println(information);
                
                // view.displayInformation(location, description, temp);
            }
        });
    }
}
