package HomeWorkProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class ModelUnitWeather {

    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS = "forecasts";
    private static final String VERSION = "v1";
    private static final String LENGHT = "daily";
    private static final String SPAN = "5day";
    private static final String LOCATIOMS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLITE = "autocomplete";
    private static final String API_KEY = "LqaHFAzgokjUBODMCTKIPgdzcFLu4ZP6";

    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void getWeather(String selectedCity, Period period) throws IOException {
        //http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey} 295212
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegments(CURRENT_CONDITIONS)
                .addPathSegments(VERSION)
                .addPathSegments(LENGHT)
                .addPathSegments(SPAN)
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
        System.out.println(response.body().string());

    }
   /* public  String getLocationKey(String city) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegments(CURRENT_CONDITIONS)
                .addPathSegments(LOCATIOMS)
                .addPathSegments(VERSION)
                .addPathSegments(CITIES)
                .addPathSegments(AUTOCOMPLITE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q",city)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responceBody = response.body().string();
        String locationKey= objectMapper.readTree(responceBody).get(0).at("/Key").asText();
        return locationKey;
    }*/
}
