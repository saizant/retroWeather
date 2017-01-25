package es.schooleando.retroweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.schooleando.retroweather.Presenter.WeatherPresenter;
import es.schooleando.retroweather.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherPresenter.WeatherPresenterListener{
    WeatherPresenter weatherPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherPresenter = new WeatherPresenter(this);
    }

    @Override
    public void weatherReady(WeatherModel weather) {
        // aquí obtenemos las actualizaciones gracias a WeatherPresenter y actualizamos el interfaz
    }
}
