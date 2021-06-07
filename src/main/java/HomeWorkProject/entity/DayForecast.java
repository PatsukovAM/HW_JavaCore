package HomeWorkProject.entity;

public class DayForecast {
    String location;
    String date;
    int temperatureMinimum;
    int temperatureMaximum;
    String dayWeather;
    String nighWeather;

    public DayForecast(String location, String date, int temperatureMinimum, int temperatureMaximum, String dayWeather,
                       String nighWeather) {
        this.location = location;
        this.date = date;
        this.temperatureMinimum = temperatureMinimum;
        this.temperatureMaximum = temperatureMaximum;
        this.dayWeather = dayWeather;
        this.nighWeather = nighWeather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemperatureMinimum() {
        return temperatureMinimum;
    }

    public void setTemperatureMinimum(int temperatureMinimum) {
        this.temperatureMinimum = temperatureMinimum;
    }

    public int getTemperatureMaximum() {
        return temperatureMaximum;
    }

    public void setTemperatureMaximum(int temperatureMaximum) {
        this.temperatureMaximum = temperatureMaximum;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public String getNighWeather() {
        return nighWeather;
    }

    public void setNighWeather(String nighWeather) {
        this.nighWeather = nighWeather;
    }

    @Override
    public String toString() {
        return "\nПрогноз погоды в" +
                "\nгород/населенный пункт: " + location +
                "\nна " + date +
                "\nтемпература ночью " + temperatureMinimum +
                "\nтемпература днем " + temperatureMaximum +
                "\nднем " + dayWeather +
                "\nночью " + nighWeather+"\n";
    }
}
