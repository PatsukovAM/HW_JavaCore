package HomeWorkProject;

import javafx.util.Pair;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ControllerUnit {
    private WeatherModel weatherModel = new ModelUnitWeather();
    private Map<Integer, Period> requestParameters = new HashMap<>();


    public ControllerUnit() {
        requestParameters.put(0, Period.NOW);
        requestParameters.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userSelectedCommand, String userSelectedCity, String locationName) throws IOException, SQLException {
        Integer integerSelectCommand = Integer.parseInt(userSelectedCommand);
        switch (requestParameters.get(integerSelectCommand)) {
            case NOW:
                weatherModel.getWeather(userSelectedCity, Period.NOW, locationName);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(userSelectedCity, Period.FIVE_DAYS, locationName);
        }
    }

    public Pair<String, String> getLocationKey(String city) throws TypeErrorExeptions, IOException {
        return weatherModel.getLocationKey(city);
    }

}
