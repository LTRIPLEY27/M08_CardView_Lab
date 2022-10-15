package isabelcalzadilla.ioc.cardview_lab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailCard extends AppCompatActivity {

    //ATRIBUTOS PROPIOS DE LA ACTIVITY DE DETALLE

    private TextView name, resumen;
    private ImageView imagen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LLAMADO A LA VIEW DE DETAILS
        setContentView(R.layout.details_card);

        callStart();
    }

    void callStart(){

        name = findViewById(R.id.detail_character_name);
        resumen = findViewById(R.id.detail_resume_character);
        imagen = findViewById(R.id.detail_img);

        int imag = Integer.parseInt(getIntent().getStringExtra("image"));

        imagen.setImageResource(imag);
        name.setText(getIntent().getStringExtra("name"));
        resumen.setText(getIntent().getStringExtra("resume"));
    }
}
