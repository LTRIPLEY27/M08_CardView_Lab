package isabelcalzadilla.ioc.cardview_lab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListLayout> elementos;
    private LayoutInflater eleInflater;
    private Context context;

    public ListAdapter(List<ListLayout> elementos, Context context) {
        this.eleInflater = LayoutInflater.from(context);
        this.elementos = elementos;
        this.context = context;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // INSTANCIACIÓN DE LA VIEW CON EL VALOR DEL INFLATE(LISTADO DE ELEMENTOS)
        View v = eleInflater.inflate(R.layout.list_layout, null);

        return new ListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(elementos.get(i));
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    // CLASE INTERNA VIEWHOLDER QUE MOSTRARA CADA ITEM DENTRO DEL CARD
    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView image;
        TextView name, resume;

        ViewHolder(View item) {
            super(item);
            image = item.findViewById(R.id.imageView);
            name = item.findViewById(R.id.character_name);
            resume = item.findViewById(R.id.resume_character);
        }

        // POR CADA ITEM DE LA LISTA
        void bindData(final ListLayout item) {
            name.setText(item.getName());
        }
    }
}
