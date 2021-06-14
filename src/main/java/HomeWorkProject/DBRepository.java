package HomeWorkProject;

import HomeWorkProject.entity.DayForecast;

import java.sql.*;

public class DBRepository {
    private static final String DB_URL = "jdbc:sqlite:D:\\java_projects\\HW_JavaCore\\src\\main\\java\\HomeWorkProject\\HWproject.dbО";
    String insertForecastRequest = "insert into  forecasts (location,date,temperatureMinimum,temperatureMaximum,dayWeather,nighWeather) values (?,?,?,?,?,?)";
    String checkForecastCurrentRecord = "select * from forecasts where location=? and date=?";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean preRecordCheck(String checkLocation, String checkDate, int flag) throws SQLException {
        ResultSet precheck = null;
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(checkForecastCurrentRecord);
            preparedStatement.setString(1, checkLocation);
            preparedStatement.setString(2, checkDate);
            preparedStatement.execute();
            precheck = preparedStatement.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (precheck.wasNull()) return true;
        else {
            if (flag == 0) {
                System.out.println(precheck);
                return false;
            } else return false;
        }
    }

    public void saveForecast(DayForecast dayForecast) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertForecastRequest);
            preparedStatement.setString(1, dayForecast.getLocation());
            preparedStatement.setString(2, dayForecast.getDate());
            preparedStatement.setInt(3, dayForecast.getTemperatureMinimum());
            preparedStatement.setInt(4, dayForecast.getTemperatureMaximum());
            preparedStatement.setString(5, dayForecast.getDayWeather());
            preparedStatement.setString(6, dayForecast.getNighWeather());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
