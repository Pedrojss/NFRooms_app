package es.uca.nfrooms;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class crearReserva extends AppCompatActivity {

        private TextView txtSaludo;
        private Button btnCrearSala;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_creserva);

            Spinner spinnerLanguages=findViewById(R.id.spSalas);

            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.salas, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinnerLanguages.setAdapter(adapter);

            txtSaludo = (TextView)findViewById(R.id.textView2);
            txtSaludo.setText("Crea aqui tu reserva!");

            btnCrearSala = (Button)findViewById(R.id.btnCrearReserva);
            btnCrearSala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = "Has creado una reserva!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(crearReserva.this , text, duration);
                    toast.show();
                }
            });
        }
}
