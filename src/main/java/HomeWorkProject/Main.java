package HomeWorkProject;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        ViewUnitWeather viewUnitWeather = new ViewUnitWeather();
        viewUnitWeather.runInterface();
    }
}