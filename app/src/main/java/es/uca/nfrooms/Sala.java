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
                SpannableString nom = new SpannableString("Nombre: Sala Kyoto");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                SpannableString desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_kyoto));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                SpannableString cap = new SpannableString("Capacidad: 50 personas");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                SpannableString price = new SpannableString("Precio: 1050€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
            case "Miami":
                nom = new SpannableString("Nombre: Sala Miami");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_miami));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                cap = new SpannableString("Capacidad: 2 personas");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                price = new SpannableString("Precio: 40€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
        }
    }
}