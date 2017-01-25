package es.schooleando.retroweather.Presenter;

import es.schooleando.retroweather.Service.WeatherService;
import es.schooleando.retroweather.model.WeatherModel;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherPresenter {
    private final WeatherPresenterListener mListener;
    private final WeatherService weatherService;

    public interface WeatherPresenterListener{
        void weatherReady(WeatherModel weather);
    }

    public WeatherPresenter(WeatherPresenterListener listener){
        this.mListener = listener;
        this.weatherService = new WeatherService();
    }

    public void getWeather() {
        // Aquí llamamos al método de countryService, encolamos y implementamos el callback
        // También deberemos llamar a la Activity a traves del listener (WeatherPresenterListerer)

        // TODO: obtener weatherModel a través del weatherService
        //WeatherModel weathermodel = weatherService.getAPI()....

        // Enviar el weatherModel a la Activity
        //this.mListener.weatherReady(weatherModel);
    }
}
