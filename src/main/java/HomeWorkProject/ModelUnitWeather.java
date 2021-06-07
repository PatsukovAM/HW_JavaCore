package HomeWorkProject;

import HomeWorkProject.entity.DayForecast;
import HomeWorkProject.entity.NowForecast;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Pair;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;


public class ModelUnitWeather implements  WeatherModel{

    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String VERSION = "v1";
    private static final String LENGHT = "daily";
    private static final String SPAN5 = "5day";
    private static final String SPAN1 = "1day";
    private static final String LOCATIOMS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLITE = "autocomplete";
    private static final String API_KEY = "LqaHFAzgokjUBODMCTKIPgdzcFLu4ZP6";
    private static String currentConditions;

    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public  void getWeather(String selectedCity, Period period, String locationName) throws IOException {
        //http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey} 295212

        switch (period) {
            case FIVE_DAYS: {
                currentConditions = "forecasts";
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegments(currentConditions)
                        .addPathSegments(VERSION)
                        .addPathSegments(LENGHT)
                        .addPathSegments(SPAN5)
                        .addPathSegments(selectedCity) // .addPathSegments(getLocationKey(selectedCity))
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("language", "ru")
                        .addQueryParameter("details", "false")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response response = okHttpClient.newCall(request).execute();
                String responceForecast = response.body().string();
                ArrayList<DayForecast> dayForecastArrayList = new ArrayList<DayForecast>();

                for(int i=0;i<5;i++) {
                    String responseDate = objectMapper.readTree(responceForecast).at("/DailyForecasts").get(i)
                            .at("/Date").asText();
                    int responseTemperatureMinimum = objectMapper.readTree(responceForecast).at("/DailyForecasts").get(i)
                            .at("/Temperature/Minimum/Value").asInt();
                    int responseTemperatureMaximum = objectMapper.readTree(responceForecast).at("/DailyForecasts").get(i)
                            .at("/Temperature/Maximum/Value").asInt();
                    String responseDayWeather = objectMapper.readTree(responceForecast).at("/DailyForecasts").get(i)
                            .at("/Day/IconPhrase").asText();
                    String responseNighWeather = objectMapper.readTree(responceForecast).at("/DailyForecasts").get(i)
                            .at("/Night/IconPhrase").asText();

                    dayForecastArrayList.add(new DayForecast(locationName, responseDate, responseTemperatureMinimum,
                            responseTemperatureMaximum, responseDayWeather, responseNighWeather));
                }

                System.out.println(dayForecastArrayList);
                break;
            }
            //http://dataservice.accuweather.com/currentconditions/v1/{locationKey}
            case NOW: {
                currentConditions = "currentconditions";
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegments(currentConditions)
                        .addPathSegments(VERSION)
                        .addPathSegments(selectedCity) // .addPathSegments(getLocationKey(selectedCity))
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("language", "ru")
                        .addQueryParameter("details", "false")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response response = okHttpClient.newCall(request).execute();
                String responceForecast = response.body().string();
                String responseWetherText = objectMapper.readTree(responceForecast).get(0).at("/WeatherText").asText();
                int responseTemperature = objectMapper.readTree(responceForecast).get(0).at("/Temperature/Metric/Value").asInt();
                NowForecast nowForecast = new NowForecast(locationName, responseWetherText, responseTemperature);
                System.out.println(nowForecast);
                break;
            }
        }
    }

    public static Pair<String, String> getLocationKey(String city) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegments(LOCATIOMS)
                .addPathSegments(VERSION)
                .addPathSegments(CITIES)
                .addPathSegments(AUTOCOMPLITE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .addQueryParameter("language", "ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responceBody = response.body().string();
        String locationKey = objectMapper.readTree(responceBody).get(0).at("/Key").asText();
        String locationName = objectMapper.readTree(responceBody).get(0).at("/LocalizedName").asText();

        return new Pair<>(locationKey, locationName);
    }
}
