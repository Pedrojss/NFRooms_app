package es.uca.nfrooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.widget.TextView;

public class Sala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);

        String sala = getIntent().getExtras().getString("sala");
        TextView nombre = findViewById(R.id.nombre);
        TextView descripcion = findViewById(R.id.descripcion);
        TextView capacidad = findViewById(R.id.capacidad);
        TextView precio = findViewById(R.id.precio);

        switch (sala){
            case "Kyoto":
                SpannableString desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_kyoto));

        }
    }
}