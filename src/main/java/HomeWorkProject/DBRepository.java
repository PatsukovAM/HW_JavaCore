package HomeWorkProject;

import HomeWorkProject.entity.DayForecast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRepository {
    private static final String DB_URL = "jdbc:sqlite:HWproject.db";
    String insertForecastRequest = "insert into  forecasts (location,date,temperatureMinimum,temperatureMaximum,dayWeather,nighWeather) values (?,?,?,?,?,?)";


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveForecast(DayForecast dayForecast) {
        try (Connection connection= DriverManager.getConnection(DB_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertForecastRequest);
            preparedStatement.setString(1,dayForecast.getLocation());
            preparedStatement.setString(2,dayForecast.getDate());
            preparedStatement.setInt(3,dayForecast.getTemperatureMinimum());
            preparedStatement.setInt(4,dayForecast.getTemperatureMaximum());
            preparedStatement.setString(5,dayForecast.getDayWeather());
            preparedStatement.setString(6,dayForecast.getNighWeather());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
