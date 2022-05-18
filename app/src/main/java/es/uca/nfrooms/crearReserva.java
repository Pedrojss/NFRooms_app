package es.uca.nfrooms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class crearReserva extends AppCompatActivity {

        private TextView txtSaludo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_creserva);

            txtSaludo = (TextView)findViewById(R.id.textView2);
            txtSaludo.setText("Hola, esto es reservas");
        }
}
