package isabelcalzadilla.ioc.cardview_lab;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // VARIABLES GLOBALES PARA IMPLEMENTAR
    private ArrayList elements;
    private RecyclerView recicler;
    private ListAdapter adapter;
    private ItemTouchHelper touching;


    // MÉTODO ON CREATE LLAMANDO AL 'STARTAPP' PARA INICIALIZAR TODA LA APP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startApp();
    }

    // MÉTODO QUE INICIALIZA LA APP UBICANDO CADA COMPONENTE Y ESTADO LA CARD Y EMÁS INICIALES
    @SuppressLint("NotifyDataSetChanged")
    void startApp(){

        // llenadp del array de elementos con cada uno de los atributos
        elements = chargeCharacters();

        recicler = findViewById(R.id.recicler);
        adapter = new ListAdapter(this, elements);
        recicler.setHasFixedSize(true);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(adapter);

        // LLAMADO AL ITEM-TOUCHHELPER PARA HACER DINAMICO CADA TOQUE
        touching = retrocede;
        touching.attachToRecyclerView(recicler);

        adapter.notifyDataSetChanged();

    }

    //MÉTODO QUE REALIZA EL LLENADO CON DATOS DE LOS ITEMS A MOSTRAR
    ArrayList chargeCharacters(){

        return new ArrayList(Arrays.asList(
                new ListLayout(R.drawable.fry,"Philip J Fry", "Es el protagonista de Futurama, la serie de animación para televisión creada por Matt Groening, creador de Los Simpson. Fry es un joven repartidor de pizza en el año 1999 que, por accidente, cae en una cámara criogénica y queda congelado por espacio de 1.000 años."),
                new ListLayout(R.drawable.leela,"Turanga Leela", "Conocida como Leela es la capitana de la nave Planet Express.eela creció en el Orfanato de mínima seguridad Cookieville, por lo tanto, desconoce todo sobre sus padres."),
                new ListLayout(R.drawable.zoidberg,"John A. Zoidberg", "Es un alienígena parecido a una langosta procedente del planeta Decapod 10. Vive por debajo del umbral de la pobreza y Hermes Conrad le detesta. El doctor Zoidberg es el único al que Santa Claus considera bueno."),
                new ListLayout(R.drawable.bender,"Bender Doblador Rodríguez", "Es el mejor amigo de Fry, y el cocinero de Planet Express. Fue fabricado en Tijuana, México, en el año 2997 (según el capítulo 3ACV01 - Amazonas con ganas). Existe un robot idéntico a él, salvo por una barbilla negra, llamado Flexo, que aparece en cuatro capítulos; en unos es un amigo inseparable de Bender, mientras que en otros se llevan bastante mal."),
                new ListLayout(R.drawable.professor,"Profesor Hubert J. Farnsworth", "El tatara-tatara-...-tatara-sobrino de Fry, que dirige Planet Express. Aprendió a leer por sí mismo cuando aún llevaba pañales (a los 8 años) en el barrio más nerd de Nueva Nueva York, Hell's Laboratory. Años más tarde comenzó a construir una gran variedad de robots"),
                new ListLayout(R.drawable.amy,"Dra. Amy Wong", "Amy es la hija de una acaudalada pareja de granjeros marcianos con rasgos achinados. Está obsesionada con los chicos y una de sus mayores características es la promiscuidad. Básicamente, conserva su trabajo porque al profesor le gusta tenerla cerca para que le done sangre ya que pertenecen al mismo grupo sanguíneo."),
                new ListLayout(R.drawable.hermes,"Hermes Conrad", "Es un burócrata jamaiquino con un don especial para archivar. También es un bailarín olímpico de limbo, sufrió un trauma cuando un niño que era su mayor admirador trato de imitarlo y falleció al romperse la espina, sin embargo es capaz de utilizar su talento cuando hace falta."),
                new ListLayout(R.drawable.zapp,"Zapp Brannigan", "Es un General 25 estrellas del Orden Democrático de Planetas, capitán de la nave Nimbus y líder del ejército DOOP.Aunque Zapp se llama a sí mismo un genio, él es en realidad un 'Pomposo bufón' (así llamado por Leela) cuyos planes pudieron haber sido fácilmente ideados por un niño."),
                new ListLayout(R.drawable.robot_devil,"Beelzebot", "A pesar de su naturaleza malvada, considera que Bender es aún peor que él después de ver algunos de los actos de este último y decir que no hay robots más malos que él, sin embargo, se deja entrever que lo más probable es que Bender tome decisiones influenciadas por él."),
                new ListLayout(R.drawable.scruffy,"Scruffy", "Es el conserje de Planet Express. Una broma recurrente es que debido a que interactúa muy poco con el resto de los empleados, nadie recuerda haberlo visto nunca antes. Se ha revelado que posee 40.000 acciones de Planet Express, más que ningún otro, porque él cree firmemente en la empresa. Él es perezoso y por lo general se encuentran en el sótano del edificio, mirando la caldera y la lectura de una edición de Zero-G Juggs Nacional o pornográfico. Casi siempre se refiere a sí mismo en tercera persona."),
                new ListLayout(R.drawable.nixon,"Nixon", "Richard Nixon pertenece a la conglomeración de personajes famosos del siglo XX convertidos en 'Cabezas humanas' en frascos llenos de agua, los cuales los mantienen con vida. En las elecciones para Presidente de la Tierra, Nixon ganó por un margen muy pequeño, creando un reino de terror en el Planeta. Aún así, pudo obtener su segundo mandato de una manera algo ortodoxa. "),
                new ListLayout(R.drawable.seymour,"Seymour III", "era el perro de Fry en el siglo 20, su lealtad y fidelidad lo convirtieron en un fósil que se exhibió mil años después.Seymour, esperó fuera de Panucci's Pizza para el regreso de Fry todos los días desde que se congeló, obedeciendo la orden de su amo anterior sin dejar el lugar y nunca perder la esperanza."),
                new ListLayout(R.drawable.morbo,"Morbo", "Morbo es un personaje de Futurama. Morbo es un extraterrestre de color verde con un cerebro grande y palpitante. Vive en Los Ángeles y trabaja en el Canal Noticias √ 2 junto a Linda. Morbo está a la espera del día en que los humanos sean destruidos."),
                new ListLayout(R.drawable.hipnosapo,"Hipnosapo", "Se trata de una rana bastante grande, con ojos que ponen cualquier cosa que se ve en ellos en un trance hipnótico, obligándolos a hacer lo que quiere el Hipnosapo. Los ojos tienen pupilas negras con rojo, y anillos de color amarillo a su alrededor."),
                new ListLayout(R.drawable.robot_hedonista,"Robot Hedonista", "El Robot Hedonista es un robot basado en un hedonista de la antigua Roma, con la notable mejora de ser su propio sofá. Tiene un plato de uvas con él en la mayoría de las veces. Está hecho de oro y fue construido al parecer con dinero de los contribuyentes. "),
                new ListLayout(R.drawable.calculum,"Calculum", "Calculon es un reconocido actor en su forma actual, y ha aparecido en varios programas, además de ser un juez en el concurso de Miss Universo. Fue creado en algún momento antes del año 2019 como un robot de fabricación de automóviles conocidos como Calculon 1.0, y utilizado en la misión militar de crear el coche más malvado jamás se haya creado a partir de partes de automóviles mal; el Proyecto de Satanás."),
                new ListLayout(R.drawable.robot_mafia,"Mafia Robot", "La Mafia Robot se basa en el mercado del mal y es un sindicato del crimen de gran éxito, llenando sus manos metálicas de todo, desde apuestas en los caballos hasta robar cigarros. La tripulación de Planet Express fue víctima de la Mafia Robot en un momento dado, sin saber que Bender fue contratado para participar en el robo. Gracias a Bender, la tripulación sobrevivió, sin tener idea de lo que realmente pasó, mientras que estaban con los ojos vendados en la nave de Planet Express."),
                new ListLayout(R.drawable.globetrotters,"Globetrotters", "Por cualquier razón en algún punto abandonaron la Tierra para habitar su propio mundo. El profesor Farnsworth creó un equipo de Súperhombres atómicos para intentar derrotar a los Globetrotters en un juego de baloncesto. Vienen del Planeta Globetrotter donde hay toda una raza de Globetrotters. Los Globetrotters también son inteligentes científicos, así como buenos jugadores de baloncesto."),
                new ListLayout(R.drawable.nibbler,"Nibbler", "Leela lo rescata cuando su planeta Vergon 6 está a punto de estallar. Una de sus mayores características es su infinito apetito y la capacidad de ingerir cosas mas grandes que él a una velocidad espeluznante. Todo lo que ingiere se convierte en materia oscura que es utilizado como combustible para naves."),
                new ListLayout(R.drawable.abogada_soltera,"Abogada Soltera", "Abogada Soltera es un programa de televisión del siglo 20 transmitido por Fox. Protagonizada por Jenny McNeal este programa les encanta tanto a los omicronianos que han invadido la Tierra para saber que pasa finalmente.")
        ));
    }


    //DECLARACIÓN DEL ITEMTOUCH DECLARADO EN EL MÉTODO ANTERIOR PARA REALIZAR CADA ACCIÓN QUE LO COMPRENDA.
    /*
    * EL ITEM-TOUCH COMPRENDE LAS SIGUIENTES ACCIONES:
    * LEFT : SI SE DESLIZA A LA IZQUIERDA LLAMA A UN EVENTO (EN ÉSTE CASO 'ELIMINAR ITEM') --> 'onSwipe'
    * RIGTH : SI SE DESLIZA A LA IZQUIERDA LLAMA A UN EVENTO (EN ÉSTE CASO 'ELIMINAR ITEM') --> 'onSwipe'
    * UP : SI SE DESLIZA HACÍA ARRIBA LLAMA A UN EVENTO (EN ÉSTE CASO 'CAMBIA LA POSICIÓN DEL ITEM') --> 'onMove'
    * DOWN : SI SE DESLIZA HACÍA ABAJO LLAMA A UN EVENTO (EN ÉSTE CASO 'CAMBIA LA POSICIÓN DEL ITEM') --> 'onMove'
    * */
    ItemTouchHelper retrocede = new ItemTouchHelper(new ItemTouchHelper
            .SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
            ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        // MÉTODO PROPIO PARA CAMBIAR LAS CARDS DE LUGAR
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            // DECLARACIÓN DE LAS POSICIONES A INTERCAMBIAR EN EL ARRAY
            int origin = viewHolder.getAdapterPosition();
            int destiny = viewHolder1.getAdapterPosition();

            //LLAMADO AL MÉTODO 'SWAP' DE LA CALSE 'COLLECTIONS' PARA AJUSTAR LOS VALORES QUE DESEAMOS Y QUE SE REALICE EL 'CAMBIO' DE POSICIÓN
            Collections.swap(elements, origin, destiny);
            // INDICAMOS AL ADAPTADOR EL CAMBIO DEL ARRAY
            adapter.notifyItemMoved(origin, destiny);

            return true;
        }

        // MÉTODO PROPIO PARA ELIMINAR LAS CARDS
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            // DECLARAMOS UN ALERT-DIALOG PARA VERIFICAR LA DECISIÓN DEL USER Y DAR LA OPCIÓN DE VOLVER ATRÁS, DISPARANCO UN EVENTO ON CLICK PARA CADA DECISION
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Desea eliminar al personaje?");
            alert.setMessage("Está seguro?");
            alert.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int indice = viewHolder.getAdapterPosition();
                    elements.remove(indice);
                    adapter.notifyItemRemoved(indice);

                }
            });

            // EN CASO DE QUE EL VALOR DEL EVENTO SEA 'NO' RETORNA LOS VALORES
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    adapter.notifyItemChanged(viewHolder.getAdapterPosition());
                }
            });
            alert.show();
        }
    }

    );

    // UNICAMENTE HACEMOS UN LLAMADO AL MÉTODO INICIAL DE LA APP Y NOS RESETTEA LOS VALORES ORIGINALES
    public void reseting(View view){
        startApp();
    }


}