package isabelcalzadilla.ioc.cardview_lab;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//CLASE 'ADAPTER' QUE ENLAZA LA CLASE DEL TIPO CARD Y LA INTERFAZ MEDIANTE LA MISMA
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    // DECLARAMOS COMO MÍNIMO LOS OBJETOS QUE CONTENDRÁ LA APP Y EL CONTEXTO PARA CAPTURAR CADA CAMBIO Y PROCEDER EN CONSECUENCIA
    private List<ListLayout> elementos;
    private Context context;

    // CONSTRUCTOR DE LA CLASE ADAPTER
    public ListAdapter( Context contexto, List<ListLayout> elementos) {
        this.elementos = elementos;
        this.context = contexto;
    }

    // CLASE INTERNA VIEWHOLDER QUE MOSTRARÁ CADA ITEM DENTRO DEL CARD
    // CONTIENE Y SETTEA LOS VALORES PARA CADA CARD, DECLARADOS EN LA CLASE LÓGICA Y EN EL LAYOUT
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtName, txtResume;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // INICIALIZA LOS VALORES DE LA INTERFAZ
            img = itemView.findViewById(R.id.start_image);
            txtName = itemView.findViewById(R.id.character_name);
            txtResume = itemView.findViewById(R.id.resume_character);

            // ADICIÓN DEL LISTENER PARA MOSTRAR EL DETAIL
            itemView.setOnClickListener(this);
        }

        // MÉTODO 'ONCLICK', PARA VISUALIZAR CON MAYOR DETALLE SI SE ESCOGE EN EL EVENTO
        @Override
        public void onClick(View view) {
            //DECLARAMOS EL OBJETO ACTUAL PULSADO PARA OBTENER LOS VALORES DE LOS ATRIBUTOS Y SETTEAR LOS DETAILS
            var actualObject = elementos.get(getAdapterPosition());

            //DECLARACIÓN DEL INTENT PARA COGER LOS VALORES Y SETTEAR EN CONCORDANCIA
            Intent callToDetail = new Intent(context, DetailCard.class);

            // SETTEO DE LOS VALORES SEGÚN DICTAMINE LA POSICIÓN DEL ADAPTER DECLARADA
            callToDetail.putExtra("image", String.valueOf(actualObject.getImg()));
            callToDetail.putExtra("name", actualObject.getName());
            callToDetail.putExtra("resume", actualObject.getResume());

            // LLAMADO A INICIAR LA ACTIVITY
            context.startActivity(callToDetail);
        }
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // INSTANCIACIÓN DE LA VIEW CON EL VALOR DEL INFLATE(LISTADO DE ELEMENTOS)
        View v = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(v);
    }

    // EL MÉTODO 'ONBIND' SERÁ EL ENCARGADO DE ENLAZAR Y SETTEAR LOS VALORES DE LA CLASE Y LA INTERFAZ
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int i) {
        holder.img.setImageResource(elementos.get(i).getImg());
        holder.txtName.setText(elementos.get(i).getName());
        holder.txtResume.setText(elementos.get(i).getResume());
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }
}
