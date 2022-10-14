package isabelcalzadilla.ioc.cardview_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListLayout> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startApp();
    }

    void startApp(){
        elements = List.of(
            new ListLayout("res/drawable-v24/fry.PNG","Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
            new ListLayout("res/drawable-v24/fry.PNG","Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
            new ListLayout("res/drawable-v24/fry.PNG","Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
            new ListLayout("res/drawable-v24/fry.PNG","Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años.")
        );

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recicler = findViewById(R.id.recicler);
        recicler.setHasFixedSize(true);
        recicler.setLayoutManager(new LinearLayoutManager(this));
    }
}