package HomeWorkProject;

import java.io.IOException;

import static HomeWorkProject.ModelUnitWeather.getWeather;


public class Main {
    public static void main(String[] args) throws IOException {
        String selectedCity = "295212";

        getWeather(selectedCity, Period.FIVE_DAYS);
    }
}
