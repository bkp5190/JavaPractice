import javax.swing.*;
import java.awt.event.ActionListener;

public class WeatherView {
    private JFrame frame;
    private JButton button;

    public WeatherView() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        button = new JButton("Generate Weather");
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }

    public void addButtonClickListener(ActionListener listener) {
        button.addActionListener(listener);
    }
}
