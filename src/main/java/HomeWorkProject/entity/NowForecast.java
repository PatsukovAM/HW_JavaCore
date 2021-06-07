package HomeWorkProject.entity;

public class NowForecast {
     String location;
     String weatherText;
     int Temperature;

    public NowForecast(String location, String weatherText, int temperature) {
        this.location = location;
        this.weatherText = weatherText;
        Temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    @Override
    public String toString() {
        return "Текущий прогноз погоды\n"
                +location
                +"\n"+weatherText
                +"\nтемпература " + Temperature+" "
                +"\u00B0" +"C";
    }
}
