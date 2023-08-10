import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                
                double[] latLonArray = model.setLatAndLonBasedOnZip(model.getZipCode());
                
                model.generateWeatherInformation(latLonArray[0], latLonArray[1]);
            }
        });
    }
}
