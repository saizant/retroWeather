package es.schooleando.retroweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.schooleando.retroweather.Presenter.WeatherPresenter;
import es.schooleando.retroweather.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherPresenter.WeatherPresenterListener{

    WeatherPresenter weatherPresenter;

    //Vistas
    private ListView listaCiudades;
    private TextView estado, temperatura, viento, humedad, txt1, txt2, txt3, txt4, cityTxt;
    private ImageView icono;

    //Lista
    private String[] ciudades = {"Addis Ababa,et", "Al Fallujah,iq", "Aleppo,sy", "Alicante,es",
            "Amsterdam,nl", "Barcelona,es", "Bilbao,es", "Bucharest,ro", "California,us", "Caracas,ve",
            "Chefchaouene,ma", "Cienfuegos,cu", "Cuenca,es", "Damascus,sy", "Gaza,ps", "Granada,es",
            "Kingston,jm", "Kyoto,jp", "Leningradskaya,ru", "Livorno,it", "Madrid,es", "Malabo,gq",
            "Marseille,fr", "Matanzas,cu", "Mislata,es", "Moscow,ru", "New York City,us", "Panama,pa",
            "Pyongyang,kp", "Roswell,us", "Sanaa,ye", "Sarajevo,ba", "Thanh pho Ho Chi Minh,vn",
            "Tokyo,jp", "Toulouse,fr", "Tripoli,ly", "Valencia,es"};

    private ArrayAdapter<String> adaptador;
    private String seleccionCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enganchar vistas
        listaCiudades = (ListView)findViewById(R.id.listaCiudades);
        estado = (TextView) findViewById(R.id.estado);
        temperatura = (TextView)findViewById(R.id.temperatura);
        viento = (TextView)findViewById(R.id.viento);
        humedad = (TextView)findViewById(R.id.humedad);
        icono = (ImageView)findViewById(R.id.icono);

        cityTxt = (TextView) findViewById(R.id.cityTxt);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);

        seleccionCiudad = ciudades[0];

        //Rellenar ListView
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ciudades);
        listaCiudades.setAdapter(adaptador);

        listaCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                seleccionCiudad = ciudades[position];
                weatherPresenter.getWeather(seleccionCiudad);
                cityTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
            }
        });

        weatherPresenter = new WeatherPresenter(this, this);
    }

    @Override
    public void weatherReady(WeatherModel weather) {
        // aquí obtenemos las actualizaciones gracias a WeatherPresenter y actualizamos el interfaz
        cityTxt.setText(weather.getName());
        estado.setText(weather.getWeather().get(0).getDescription().toUpperCase() + ".");
        Picasso.with(this).load("http://openweathermap.org/img/w/" + weather.getWeather().get(0).getIcon() + ".png").into(icono);
        temperatura.setText(Math.round((Double.parseDouble(weather.getMain().getTemp())-273.15d)* 100.0) / 100.0 + " ºC.");     //weather.getMain().getTemp() --> Kelvin
        viento.setText(Math.round((Double.parseDouble(weather.getWind().getSpeed())*3.6d)* 100.0) / 100.0 + " km/h.");      //weather.getWind().getSpeed() --> m/s
        humedad.setText(weather.getMain().getHumidity() + " %.");
    }

    //BOTÓN:
    public void actualizar(View v) {
        weatherPresenter.getWeather(seleccionCiudad);
        cityTxt.setVisibility(View.VISIBLE);
        txt1.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.VISIBLE);
        txt4.setVisibility(View.VISIBLE);
    }
}
