package es.schooleando.retroweather.Service;

import es.schooleando.retroweather.model.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherService {
    private static final String BASE_URL = "...";

    public interface WeatherAPI {

        // TODO: Completar
        @GET
        Call<WeatherModel> getWeather();
    }

    public WeatherAPI getAPI() {
        // TODO: creamos la instancia del interfaz del API mediante Retrofit
        // Retrofit retrofit ...

        return null;
        // return retrofit.create(WeatherAPI.class);

    }
}
