package HomeWorkProject;

import javafx.util.Pair;

import java.io.IOException;

public interface WeatherModel {
    void getWeather (String selectedCity, Period period, String locationName) throws IOException;

}
