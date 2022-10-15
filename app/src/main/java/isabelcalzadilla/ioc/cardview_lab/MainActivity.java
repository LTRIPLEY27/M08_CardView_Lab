package isabelcalzadilla.ioc.cardview_lab;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // VARIABLES GLOBALES PARA IMPLEMENTAR
    private List<ListLayout> elements;
    private RecyclerView recicler;
    private ListAdapter adapter;
    private ItemTouchHelper touching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startApp();
    }

    void startApp(){
        elements = List.of(
                new ListLayout(R.drawable.fry,"Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
                new ListLayout(R.drawable.leela,"Turanga Leela", "Conocida como Leela es la capitana de la nave Planet Express.eela creció en el Orfanato de mínima seguridad Cookieville, por lo tanto, desconoce todo sobre sus padres."),
                new ListLayout(R.drawable.zoidberg,"John A. Zoidberg", "Es un alienígena parecido a una langosta procedente del planeta Decapod 10. Vive por debajo del umbral de la pobreza y Hermes Conrad le detesta. El doctor Zoidberg es el único al que Santa Claus considera bueno."),
                new ListLayout(R.drawable.bender,"Bender Doblador Rodríguez ", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
                new ListLayout(R.drawable.professor,"Profesor Hubert J. Farnsworth", "El tatara-tatara-...-tatara-sobrino de Fry, que dirige Planet Express. Aprendió a leer por sí mismo cuando aún llevaba pañales (a los 8 años) en el barrio más nerd de Nueva Nueva York, Hell's Laboratory. Años más tarde comenzó a construir una gran variedad de robots"),
                new ListLayout(R.drawable.amy,"Dra. Amy Wong", "Amy es la hija de una acaudalada pareja de granjeros marcianos con rasgos achinados. Está obsesionada con los chicos y una de sus mayores características es la promiscuidad. Básicamente, conserva su trabajo porque al profesor le gusta tenerla cerca para que le done sangre ya que pertenecen al mismo grupo sanguíneo."),
                new ListLayout(R.drawable.hermes,"Hermes Conrad", "Es un burócrata jamaiquino con un don especial para archivar. También es un bailarín olímpico de limbo, sufrió un trauma cuando un niño que era su mayor admirador trato de imitarlo y falleció al romperse la espina, sin embargo es capaz de utilizar su talento cuando hace falta."),
                new ListLayout(R.drawable.zapp,"Zapp Brannigan", "es un General 25 estrellas del Orden Democrático de Planetas, capitán de la nave Nimbus y líder del ejército DOOP.Aunque Zapp se llama a sí mismo un genio, él es en realidad un 'Pomposo bufón' (así llamado por Leela) cuyos planes pudieron haber sido fácilmente ideados por un niño."),
                new ListLayout(R.drawable.robot_devil,"Beelzebot", "A pesar de su naturaleza malvada, considera que Bender es aún peor que él después de ver algunos de los actos de este último y decir que no hay robots más malos que él, sin embargo, se deja entrever que lo más probable es que Bender tome decisiones influenciadas por él.")
        );

        recicler = findViewById(R.id.recicler);
        adapter = new ListAdapter(this, elements);
        recicler.setHasFixedSize(true);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(adapter);

        touching = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {

                        int indiceOriginal = viewHolder.getAdapterPosition();
                        int indiceNuevo = viewHolder1.getAdapterPosition();

                        Collections.swap(elements, indiceOriginal, indiceNuevo);
                        adapter.notifyItemMoved(indiceOriginal, indiceNuevo);
                        return true;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                        elements.remove(viewHolder.getAdapterPosition());
                        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    }
                }
        );

        touching.attachToRecyclerView(recicler);
    }


}