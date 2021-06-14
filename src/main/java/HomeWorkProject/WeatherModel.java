package HomeWorkProject;

import javafx.util.Pair;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period, String locationName) throws IOException, SQLException;

    Pair<String, String> getLocationKey(String city) throws TypeErrorExeptions, IOException;

}
